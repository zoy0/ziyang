package com.liziyang.www.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.liziyang.www.dao.QuestionDao;
import com.liziyang.www.dao.impl.*;
import com.liziyang.www.pojo.*;
import com.liziyang.www.service.TaskService;
import com.liziyang.www.utils.ServletUtils;
import com.sun.deploy.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    @Override
    public void showTask(HttpServletRequest req, HttpServletResponse resp) {
        String semester = (String) req.getAttribute("{semester}");
        String fuzzy = (String) req.getAttribute("{fuzzy}");
        List<TaskDetail> allTasks = null;
        if ("".equals(semester) && fuzzy == null) {
            allTasks = new TaskDetail().setListStatusStr(new TaskDetailDaoImpl().findAllTasks());
        } else {
            allTasks = new TaskDetail().setListStatusStr(new TaskDetailDaoImpl().findFuzzy(semester, fuzzy));
        }
        try {
            ServletUtils.write(resp, new TaskDetail().mergeSameTasks(allTasks));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTask(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader br = req.getReader();
        String params = br.readLine();
        JsonParser parse = new JsonParser();
        ObjectMapper mapper = new ObjectMapper();
        int classId = 0;
        JsonArray questions = null;
        Tasks task = null;
        try {
            JsonObject result = (JsonObject) parse.parse(params);
            classId = result.get("classId").getAsInt();
            questions = result.get("questions").getAsJsonArray();
            task = mapper.readValue(result.get("task").getAsJsonObject().toString(), Tasks.class);

            new TasksDaoImpl().insert(task);
            int taskId = new TasksDaoImpl().searchLastTaskId();
            new QuestionDaoImpl().insertAll(questions, taskId);
        } catch (JsonSyntaxException | JsonProcessingException e) {
            ServletUtils.write(resp,false);
            e.printStackTrace();
        }
        ServletUtils.write(resp, true);
    }

    @Override
    public void publishTask(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader br = req.getReader();
        String params = br.readLine();
        System.out.println(params);
        JsonParser parse = new JsonParser();
        JsonObject task = parse.parse(params).getAsJsonObject();
        int taskId = task.get("taskId").getAsInt();
        Timestamp endTime = new Timestamp(task.get("endTime").getAsLong());
        try {
            new TasksDaoImpl().updateEndTimeById(taskId, endTime);
            int courseId = new TasksDaoImpl().select(taskId).get(0).getCourseId();
            List<Student> students = new StudentDaoImpl().findByCourseId(courseId);
            List<Question> questions = new QuestionDaoImpl().findByTaskId(taskId);
            for (Student student :
                    students) {
                new StudentTaskDaoImpl().insert(new StudentTask(student.getId(), taskId));
                new StudentQuestionDaoImpl().insertAll(student.getId(), questions);
            }
            ServletUtils.write(resp, true);
        } catch (Exception e) {
            ServletUtils.write(resp, false);
            e.printStackTrace();
        }

    }
}

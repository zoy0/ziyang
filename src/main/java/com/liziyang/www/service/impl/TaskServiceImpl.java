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
            ServletUtils.write(resp, false);
            e.printStackTrace();
        }
        ServletUtils.write(resp, true);
    }

    @Override
    public void publishTask(HttpServletRequest req, HttpServletResponse resp, String params) throws IOException {
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

    @Override
    public void modifyTask(HttpServletRequest req, HttpServletResponse resp, String params) throws IOException {
        JsonParser parse = new JsonParser();
        JsonObject modified = parse.parse(params).getAsJsonObject();
        System.out.println(params);
        String s = (String)req.getAttribute("{taskId}");
        int taskId=Integer.parseInt((String)req.getAttribute("{taskId}"));
        int courseId = 0;
        int totalScore=modified.get("totalScore").getAsInt();

//        获取课程的id
        if (modified.get("courseId").isJsonNull()) {
            courseId=modified.get("initialCourseId").getAsInt();
        } else {
            courseId=modified.get("courseId").getAsInt();
        }

        JsonArray submittedQuestion = modified.get("submittedQuestion").getAsJsonArray();


        //该课程下的学生
        List<Student> students = new StudentDaoImpl().findByCourseId(courseId);

        //改练习名字,题目数量和总分

        new TasksDaoImpl().updateDetail(taskId,modified.get("subjectName").getAsString(), courseId , submittedQuestion.size(),totalScore);


        //插入题目（有则更新，无则插入）
        new QuestionDaoImpl().updateOrInsert(taskId,submittedQuestion);


        //改练习所属课程
        if (modified.get("courseId").isJsonNull()) {

            new  StudentQuestionDaoImpl().updateByArrays(taskId,students,modified.get("deletedQuestion").getAsJsonArray(),modified.get("insertedQuestion").getAsJsonArray());


//            //删除题目和学生端的题目
//            if (modified.get("deletedQuestion").getAsJsonArray().size() != 0) {
//                new QuestionDaoImpl().deleteByArrays(modified.get("deletedQuestion").getAsJsonArray(), taskId);
//                System.out.println(1);
//            }
//
//            //有插入的信息则更新学生端的题目
//            if (modified.get("insertedQuestion").getAsJsonArray().size() == 0) {
//                System.out.println(2);
//            }

        } else {

            //如果不是，则清空学生端该练习的信息，重新在学生端插入题目（学生不同）
            new StudentTaskDaoImpl().deleteByTaskId(taskId);
            new StudentTaskDaoImpl().insertAll(students,taskId);
            new StudentQuestionDaoImpl().deleteByTaskId(taskId);
            new StudentQuestionDaoImpl().insertAllByJsonArray(taskId,students,submittedQuestion);

        }
    }
}

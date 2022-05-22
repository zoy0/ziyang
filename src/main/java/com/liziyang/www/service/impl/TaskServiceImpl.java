package com.liziyang.www.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.liziyang.www.dao.QuestionDao;
import com.liziyang.www.dao.impl.QuestionDaoImpl;
import com.liziyang.www.dao.impl.TaskDetailDaoImpl;
import com.liziyang.www.dao.impl.TasksDaoImpl;
import com.liziyang.www.pojo.Question;
import com.liziyang.www.pojo.TaskDetail;
import com.liziyang.www.pojo.Tasks;
import com.liziyang.www.service.TaskService;
import com.liziyang.www.utils.ServletUtils;
import com.sun.deploy.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
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
        ArrayList<Question> questions = null;
        Tasks task = null;
        try {
            JsonObject result = (JsonObject) parse.parse(params);
            classId = result.get("classId").getAsInt();
            questions = mapper.readValue(result.get("questions").getAsJsonArray().toString(), ArrayList.class);
            task = mapper.readValue(result.get("task").getAsJsonObject().toString(), Tasks.class);
        } catch (JsonSyntaxException | JsonProcessingException e) {
            e.printStackTrace();
        }
        new QuestionDaoImpl().insertAll(questions);
        new TasksDaoImpl().insert(task);
    }
}

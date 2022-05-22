package com.liziyang.www.dao;

import com.google.gson.JsonArray;
import com.liziyang.www.pojo.AClass;
import com.liziyang.www.pojo.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface QuestionDao {
    int insertAll(JsonArray questions, int taskId);
}

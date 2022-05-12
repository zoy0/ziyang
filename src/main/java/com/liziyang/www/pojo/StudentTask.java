package com.liziyang.www.pojo;

import com.liziyang.www.annotation.TableField;
import com.liziyang.www.annotation.TableName;

@TableName("student_task")
public class StudentTask {
    @TableField("student_id")
    private int studentId;
    @TableField("task_id")
    private int tasksId;
    @TableField("state")
    private State state=State.UNFINISH;
    @TableField("answer")
    private String answer;

    public enum State{
        /**
         *
         */
        ISFINISH(1,"已完成"),
        UNFINISH(2,"未提交");

        private final int code;
        private final String mean;

         State(int code, String mean) {
            this.code = code;
            this.mean = mean;
        }

         public int getCode() {
             return code;
         }

         public String getMean() {
             return mean;
         }

         @Override
        public String toString() {
            return  mean;
        }
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTasksId() {
        return tasksId;
    }

    public void setTasksId(int tasksId) {
        this.tasksId = tasksId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "StudentTask{" +
                "studentId=" + studentId +
                ", tasksId=" + tasksId +
                ", state=" + state +
                ", answer='" + answer + '\'' +
                '}';
    }
}

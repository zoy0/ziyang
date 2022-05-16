package com.liziyang.www.pojo;

import com.liziyang.www.annotation.TableField;
import com.liziyang.www.annotation.TableName;

@TableName("student_task")
public class StudentTask {

    @TableField("student_task_id")
    private int studentTaskId;

    @TableField("student_id")
    private int studentId;

    @TableField("task_id")
    private int tasksId;

    @TableField("finish_number")
    private int finishNumber;

    @TableField("state")
    private State state=State.UNFINISH;



    public enum State{
        /**
         *
         */
        ISFINISH(0,"已完成"),
        UNFINISH(1,"未提交");

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

    public StudentTask() {
    }

    public StudentTask(int studentTaskId, int studentId, int tasksId, int finishNumber, State state) {
        this.studentTaskId = studentTaskId;
        this.studentId = studentId;
        this.tasksId = tasksId;
        this.finishNumber = finishNumber;
        this.state = state;
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

    public int getStudentTaskId() {
        return studentTaskId;
    }

    public void setStudentTaskId(int studentTaskId) {
        this.studentTaskId = studentTaskId;
    }

    public int getFinishNumber() {
        return finishNumber;
    }

    public void setFinishNumber(int finishNumber) {
        this.finishNumber = finishNumber;
    }

    @Override
    public String toString() {
        return "StudentTask{" +
                "studentTaskId=" + studentTaskId +
                ", studentId=" + studentId +
                ", tasksId=" + tasksId +
                ", finishNumber=" + finishNumber +
                ", state=" + state +
                '}';
    }
}

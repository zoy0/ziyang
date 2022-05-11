package com.liziyang.www.pojo;

public class StudentTask {
    private int studentId;
    private int tasksId;
    private State state=State.UNFINISH;
    private String answer;

    private static enum State{
        /**
         *
         */
        ISFINISH(1,"已完成"),
        UNFINISH(2,"未提交");

        private int index;
        private String mean;

        State(int index, String mean) {
            this.index = index;
            this.mean = mean;
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
}

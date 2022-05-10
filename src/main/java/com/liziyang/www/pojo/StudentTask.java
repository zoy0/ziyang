package com.liziyang.www.pojo;

public class StudentTask {
    private Student student;
    private Tasks tasks;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
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

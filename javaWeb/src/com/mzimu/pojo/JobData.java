package com.mzimu.pojo;

public class JobData {
    private String job;
    private String deptName;

    public JobData(String job, String deptName) {
        this.job = job;
        this.deptName = deptName;
    }

    public String getJob() {
        return job;
    }

    public String getDeptName() {
        return deptName;
    }
}

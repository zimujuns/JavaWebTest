package com.mzimu.utils;

import com.mzimu.pojo.JobData;

public class Condition {
    private String id;
    private String name;
    private String job;
    private JobData jobData;

    public Condition(JobData jobData) {
        this.jobData = jobData;
    }

    public Condition(String id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getWhere() {
        String where = " && ";
        StringBuffer sb = new StringBuffer();
        if(getId()!=null&&!getId().isEmpty()){
            sb.append(where);
            sb.append("id = ");
            sb.append(getId());
        }
        if(getName()!=null&&!getName().isEmpty()){
            sb.append(where);
            sb.append("name = '");
            sb.append(getName()+"'");
        }
        if(getJob()!=null && !getJob().isEmpty()){
            sb.append(where);
            sb.append("job = '");
            sb.append(getJob()+"'");
        }
        sb.append(";");
        return sb.toString();
    }

    public String getJobWhere(){
        String where = " && ";
        StringBuffer sb = new StringBuffer();
        if(jobData.getJob()!=null || jobData.getJob().isEmpty()){
            sb.append(where).append("job = '").append(jobData.getJob()).append("'");
        }
        if(jobData.getDeptName()!=null||jobData.getDeptName().isEmpty()){
            sb.append(where).append("deptName = '").append(jobData.getDeptName()).append("'");
        }
        return sb.toString();
    }
}

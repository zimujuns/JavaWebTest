package com.mzimu.pojo;

import java.sql.Date;

public class EntityData {
    private String name,job,deptName;
    private Date sdf;
    private int id,age;
    private float salary;


    public EntityData(int id,String name, String job, String deptName, Date sdf, int age, float salary) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.deptName = deptName;
        this.sdf = sdf;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getDeptName() {
        return deptName;
    }

    public Date getSdf() {
        return sdf;
    }

    public int getAge() {
        return age;
    }

    public float getSalary() {
        return salary;
    }
}

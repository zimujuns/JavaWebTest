package com.mzimu.pojo;

import java.io.Serializable;
import java.sql.Date;

public class EntityData implements Serializable {
    private String name,job;
    private Date sdf;
    private int id,age;
    private float salary;


    public EntityData(int id,String name, String job, Date sdf, int age, float salary) {
        this.id = id;
        this.name = name;
        this.job = job;
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

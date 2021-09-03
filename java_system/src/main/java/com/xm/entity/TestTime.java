package com.xm.entity;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class TestTime {
    private String timename;
    private Timestamp times;

    public String getTimename() {
        return timename;
    }

    public void setTimename(String timename) {
        this.timename = timename;
    }

    public Timestamp getTimes() {
        return times;
    }

    public void setTimes(Timestamp times) {
        this.times = times;
    }
}

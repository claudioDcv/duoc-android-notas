package com.dcv.claudio.mantenedordenotas.objects;

import java.util.ArrayList;

/**
 * Created by claudio on 28-03-18.
 */

public class Course {
    private Integer id;
    private String title;
    private ArrayList<Student> students;

    public Course() {
    }

    public Course(String title) {
        this.setTitle(title);
    }

    public Course(Integer id, String title) {
        this.setId(id);
        this.setTitle(title);
    }

    public Course(Integer id, String title , ArrayList<Student> students) {
        this.setId(id);
        this.setTitle(title);
        this.setStudents(students);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        String t = this.getId() + " : " + this.getTitle();
        return t;
    }
}

package com.dcv.claudio.mantenedordenotas.objects;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

/**
 * Created by claudio on 28-03-18.
 */

public class Student {
    private Integer id;
    private String fullName;
    private String naturalKey;
    private List<Course> courses = new ArrayList<Course>();

    public Student() {
    }

    public Student(Integer id, String fullName, String naturalKey, Course course) {
        this.setId(id);
        this.setFullName(fullName);
        this.setNaturalKey(naturalKey);

        this.getCourses().add(course);

    }

    public Student(Integer id, String fullName, String naturalKey, ArrayList<Course> courses) {
        this.setId(id);
        this.setFullName(fullName);
        this.setNaturalKey(naturalKey);
        this.setCourses(courses);
    }

    public Student(Integer id, String fullName, String naturalKey) {
        this.setId(id);
        this.setFullName(fullName);
        this.setNaturalKey(naturalKey);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNaturalKey() {
        return naturalKey;
    }

    public void setNaturalKey(String naturalKey) {
        this.naturalKey = naturalKey;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        String t = this.getId() + " : " + this.getFullName() + " : " + this.getNaturalKey();

        ListIterator<Course> list = this.courses.listIterator();

        while(list.hasNext()) {
            t.concat(" <" + list.next().getTitle() + " >");
        }

        return t;
    }
}

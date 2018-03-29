package objects;

import java.util.ArrayList;

/**
 * Created by claudio on 28-03-18.
 */

public class Student {
    private Integer id;
    private String fullName;
    private String naturalKey;
    private ArrayList<Course> courses;

    public Student(Integer id, String fullName, String naturalKey, ArrayList<Course> courses) {
        this.setId(id);
        this.setFullName(fullName);
        this.setNaturalKey(naturalKey);
        this.setCourses(courses);
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

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}

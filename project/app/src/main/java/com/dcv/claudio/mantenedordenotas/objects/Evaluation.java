package com.dcv.claudio.mantenedordenotas.objects;

/**
 * Created by claudio on 28-03-18.
 */

public class Evaluation {
    private Integer id;
    private Double value;
    private Student student;
    private Course course;

    public Evaluation(Integer id, Double value, Student student, Course course) {
        this.setId(id);
        this.setValue(value);
        this.setStudent(student);
        this.setCourse(course);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

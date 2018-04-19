package com.dcv.claudio.mantenedordenotas.objects;

/**
 * Created by claudio on 19-04-18.
 */

public class CourseStudent {
    private long id;
    private long idStudent;
    private long idCourse;

    public CourseStudent() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(long idCourse) {
        this.idCourse = idCourse;
    }
}

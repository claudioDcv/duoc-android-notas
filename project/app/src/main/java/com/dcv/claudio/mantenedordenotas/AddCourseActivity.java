package com.dcv.claudio.mantenedordenotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dcv.claudio.mantenedordenotas.db.models.CourseModel;
import com.dcv.claudio.mantenedordenotas.objects.Course;
import java.util.ArrayList;

public class AddCourseActivity extends AppCompatActivity {

    private CourseModel courseModel = new CourseModel(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
    }

    public void closeAddCourse(View view) {
        this.finish();
    }

    public void createCourse(View view) {
        EditText auxTitle = findViewById(R.id.txtCourseTitle);
        String title = auxTitle.getText().toString();
        long id = courseModel.create(new Course(title));
        System.out.println(id);
        ArrayList<Course> courses = courseModel.getAll();

        for (Course c: courses) {
            System.out.println(c.toString());
        }
    }
}

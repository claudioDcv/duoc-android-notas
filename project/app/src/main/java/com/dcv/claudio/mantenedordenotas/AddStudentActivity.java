package com.dcv.claudio.mantenedordenotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.dcv.claudio.mantenedordenotas.db.models.CourseModel;
import com.dcv.claudio.mantenedordenotas.objects.Course;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        CourseModel courseModel = new CourseModel(this);
        ArrayList<Course> courses = courseModel.getAll();

        ArrayList<String> coursesStr = new ArrayList<String>();

        for (Course c : courses) {
            coursesStr.add(c.getTitle());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, coursesStr);
        // SPINNER
        Spinner spinnerSelect = findViewById(R.id.spinner_course_select);
        spinnerSelect.setAdapter(arrayAdapter);

    }

    public void closeAddStudent(View view) {
        this.finish();
    }
}

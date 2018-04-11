package com.dcv.claudio.mantenedordenotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.dcv.claudio.mantenedordenotas.db.models.CourseModel;
import com.dcv.claudio.mantenedordenotas.objects.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        ListView lv = findViewById(R.id.courseListView);

        CourseModel courseModel = new CourseModel(this);

        List<Course> elements = courseModel.getAll();
        List<String> strList = new ArrayList<String>();

        for (Course c:
             elements) {
            strList.add(c.getTitle());
        }

        /*
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.list,
                strList
        );
        */

        final ArrayList<Course> courses = courseModel.getAll();
        AdapterCourse adapterCourse = new AdapterCourse(this, courses);

        lv.setAdapter(adapterCourse);
    }

    public void closeCourseList(View view) {
        this.finish();
    }
}

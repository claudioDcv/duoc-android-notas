package com.dcv.claudio.mantenedordenotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CourseItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_item);
    }

    /*
    public void showCourseDetail(View view) {
        TextView textView = findViewById(R.id.txtCourseItemTitle);

        Toast toast = Toast.makeText(this, textView.getText().toString(), Toast.LENGTH_SHORT);
        toast.show();
    }
    */
}

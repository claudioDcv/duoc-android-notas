package com.dcv.claudio.mantenedordenotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void openActivity(Class act) {
        Intent intent = new Intent(MainActivity.this, act);
        MainActivity.this.startActivity(intent);
    }

    public void openAddEvaluation(View view) {
        this.openActivity(AddEvaluationActivity.class);
    }

    public void openAddCourse(View view) {
        this.openActivity(AddCourseActivity.class);
    }

    public void openAddStudent(View view) {
        this.openActivity(AddStudentActivity.class);
    }

    public void openCourseList(View view) {
        this.openActivity(CourseListActivity.class);
    }
}


/* Passing values between views
Intent intent = new Intent(getBaseContext(), SignoutActivity.class);
intent.putExtra("EXTRA_SESSION_ID", sessionId);
startActivity(intent);
Access that intent on next activity

String s = getIntent().getStringExtra("EXTRA_SESSION_ID");
 */
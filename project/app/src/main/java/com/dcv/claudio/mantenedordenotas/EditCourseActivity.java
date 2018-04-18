package com.dcv.claudio.mantenedordenotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dcv.claudio.mantenedordenotas.db.models.CourseModel;
import com.dcv.claudio.mantenedordenotas.objects.Course;

public class EditCourseActivity extends AppCompatActivity {

    private Course course;
    private CourseModel courseModel = new CourseModel(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_course);
        TextView txtId = findViewById(R.id.txtEditCourseID);
        Integer id = getIntent().getIntExtra("id", 0);

        EditText txtTitle = findViewById(R.id.txtEditCourseTitle);

        course = courseModel.get(id);


        txtId.setText(course.getId().toString());
        txtTitle.setText(course.getTitle());
    }

    public void closeAddStudent(View view) {
        this.finish();
    }

    public void btnCourseEditSave(View view) {

        EditText txtTitle = findViewById(R.id.txtEditCourseTitle);

        if (txtTitle.getText().toString().length() == 0){
            txtTitle.setError("No puede estar vacio");
            return;
        }


        TextView txtId = findViewById(R.id.txtEditCourseID);

        course.setTitle(txtTitle.getText().toString());
        Course findModelCourse = courseModel.getByTitle(course.getTitle());
        if (findModelCourse != null && findModelCourse.getId() != Integer.parseInt(txtId.getText().toString())) {
            msg("Error, ya existe un curso llamado:" + findModelCourse.getTitle());
        } else {
            courseModel.update(course);
            msg("Actualizado con exito");
            finish();
            this.openActivity(CourseListActivity.class);
        }
    }
    public void msg (String texto) {
        Toast t = Toast.makeText(this, texto, Toast.LENGTH_SHORT);
        t.show();
    }
    private void openActivity(Class act) {
        Intent intent = new Intent(EditCourseActivity.this, act);
        EditCourseActivity.this.startActivity(intent);
    }
}

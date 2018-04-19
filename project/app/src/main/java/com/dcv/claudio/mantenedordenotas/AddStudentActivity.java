package com.dcv.claudio.mantenedordenotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.dcv.claudio.mantenedordenotas.db.models.CourseModel;
import com.dcv.claudio.mantenedordenotas.db.models.CourseStudentModel;
import com.dcv.claudio.mantenedordenotas.db.models.StudentModel;
import com.dcv.claudio.mantenedordenotas.objects.Course;
import com.dcv.claudio.mantenedordenotas.objects.CourseStudent;
import com.dcv.claudio.mantenedordenotas.objects.Student;
import com.dcv.claudio.mantenedordenotas.utils.Utils;

import java.util.ArrayList;

public class AddStudentActivity extends AppCompatActivity {

    private Spinner spinnerOfferType;
    private TextView selectedId;
    private  Integer idCouseSelected;

    private Course course;
    private CourseModel courseModel = new CourseModel(this);
    private CourseStudentModel courseStudentModel = new CourseStudentModel(this);
    private StudentModel studentModel = new StudentModel(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        CourseModel courseModel = new CourseModel(this);

        final ArrayList<Course> courses = courseModel.getAll();
        //AdapterCourse adapterCourse = new AdapterCourse(this, courses);
        // SPINNER
        selectedId = findViewById(R.id.course_selected_id);

        spinnerOfferType = findViewById(R.id.spinner_course_select);
        CustomArrayAdapter adapter = new CustomArrayAdapter(this, R.layout.activity_course_item_spinner, courses);

        spinnerOfferType.setAdapter(adapter);

        spinnerOfferType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                TextView item = view.findViewById(R.id.course_id);
                String t = item.getText().toString();
                System.out.println(t);
                selectedId.setText(t);
                idCouseSelected = Integer.parseInt(t);
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void closeAddStudent(View view) {
        this.finish();
    }

    private String g(TextView t) {
        return t.getText().toString();
    }
    public void btnAddStudent(View view) {

        EditText fullName = findViewById(R.id.txtAddStudentFullName);
        EditText naturalKey = findViewById(R.id.txtAddStudentNaturalKey);

        if(!Utils.validarRut(g(naturalKey))) {
            naturalKey.setError("Debe ingresar un RUT valido");
            return;
        }

        System.out.println(idCouseSelected);

        System.out.println(fullName.getText().toString());
        System.out.println(naturalKey.getText().toString());

        course = courseModel.get(idCouseSelected);

        System.out.println(course.toString());
        if(course != null){
            Student student = new Student();
            student.setFullName(g(fullName));
            student.setNaturalKey(g(naturalKey));
            student.getCourses().add(course);
            student.toString();

            long idStudent = studentModel.create(student);

            System.out.println(idStudent);

            if(idStudent > 0) {
                CourseStudent courseStudent = new CourseStudent();
                courseStudent.setIdCourse(course.getId());
                courseStudent.setIdStudent(idStudent);
                Long idCourseStudent = courseStudentModel.create(courseStudent);
                System.out.println(idCourseStudent);
            }


        }


    }
}

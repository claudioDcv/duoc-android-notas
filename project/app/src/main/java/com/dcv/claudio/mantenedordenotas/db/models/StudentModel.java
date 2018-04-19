package com.dcv.claudio.mantenedordenotas.db.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dcv.claudio.mantenedordenotas.db.readers.CourseReaderContract;
import com.dcv.claudio.mantenedordenotas.db.readers.DatabaseHelper;
import com.dcv.claudio.mantenedordenotas.db.readers.StudentReaderContract;
import com.dcv.claudio.mantenedordenotas.objects.Course;
import com.dcv.claudio.mantenedordenotas.objects.Student;

import java.util.ArrayList;


public class StudentModel {
    private DatabaseHelper evaluationReaderDbHelper;

    private StudentReaderContract.StudentEntry studentEntry;

    private CourseModel courseModel;

    public StudentModel(Context context) {

        evaluationReaderDbHelper = new DatabaseHelper(context);
        courseModel = new CourseModel(context);
    }

    public long create(Student student) {
        SQLiteDatabase db = evaluationReaderDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(this.studentEntry.COLUMN_NAME_FULL_NAME, student.getFullName());
        values.put(this.studentEntry.COLUMN_NAME_NATURAL_KEY, student.getNaturalKey());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(this.studentEntry.TABLE_NAME, null, values);

        for (Course course : student.getCourses()) {
            courseModel.create(course);
        }


        db.close();

        return newRowId;
    }
}

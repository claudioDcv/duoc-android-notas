package com.dcv.claudio.mantenedordenotas.db.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dcv.claudio.mantenedordenotas.db.readers.CourseStudentReaderContract;
import com.dcv.claudio.mantenedordenotas.db.readers.DatabaseHelper;
import com.dcv.claudio.mantenedordenotas.objects.CourseStudent;

/**
 * Created by claudio on 19-04-18.
 */

public class CourseStudentModel {
    private DatabaseHelper evaluationReaderDbHelper;

    private CourseStudentReaderContract.CourseStudentEntry courseStudentEntry;

    private CourseModel courseModel;

    public CourseStudentModel(Context context) {

        // evaluationReaderDbHelper = new DatabaseHelper(context);
    }

    public long create(CourseStudent courseStudent) {
        long newRowId = 0;
        SQLiteDatabase db = evaluationReaderDbHelper.getWritableDatabase();

        if(!this.ifExistManyToMany(courseStudent.getIdStudent(), courseStudent.getIdStudent())) {
            ContentValues values = new ContentValues();
            values.put(courseStudentEntry.COLUMN_NAME_COURSE_ID, courseStudent.getIdCourse());
            values.put(courseStudentEntry.COLUMN_NAME_STUDENT_ID, courseStudent.getIdCourse());

            System.out.println(courseStudent.getIdCourse());
            System.out.println(courseStudent.getIdStudent());
            // Insert the new row, returning the primary key value of the new row
            // newRowId = db.insert(courseStudentEntry.TABLE_NAME, null, values);
        }

        db.close();

        return newRowId;
    }

    public boolean ifExistManyToMany(Long idStudent, Long idCourse) {
        SQLiteDatabase db = evaluationReaderDbHelper.getReadableDatabase();
        String[] projection = {
                courseStudentEntry._ID
        };

        String selection = courseStudentEntry.COLUMN_NAME_STUDENT_ID + " = ? AND " + courseStudentEntry.COLUMN_NAME_COURSE_ID + " = ?";
        String[] selectionArgs = {idStudent.toString(), idCourse.toString()};
        String sortOrder = courseStudentEntry._ID + " DESC";

        Cursor c = db.query(
                courseStudentEntry.TABLE_NAME,     // The table to query
                projection,                 // The columns to return
                selection,                  // The columns for the WHERE clause
                selectionArgs,              // The values for the WHERE clause
                null,               // don't group the rows
                null,                // don't filter by row groups
                sortOrder                    // The sort order
        );

        db.close();

        return c.getCount() > 0;
    }
}
package com.dcv.claudio.mantenedordenotas.db.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dcv.claudio.mantenedordenotas.db.readers.CourseReaderContract;
import com.dcv.claudio.mantenedordenotas.db.readers.CourseReaderDbHelper;
import com.dcv.claudio.mantenedordenotas.objects.Course;

import java.util.ArrayList;


public class CourseModel {
    private CourseReaderDbHelper evaluationReaderDbHelper;
    private CourseReaderContract.CourseEntry courseEntry;
    public CourseModel(Context context) {
        evaluationReaderDbHelper = new CourseReaderDbHelper(context);
    }

    public long create(Course course) {
        SQLiteDatabase db = evaluationReaderDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(courseEntry.COLUMN_NAME_TITLE, course.getTitle());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(courseEntry.TABLE_NAME, null, values);
        return newRowId;
    }
    public ArrayList<Course> getAll() {
        SQLiteDatabase db = evaluationReaderDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                courseEntry._ID,
                courseEntry.COLUMN_NAME_TITLE
        };

        // Filter results WHERE "title" = 'My Title'
        // String selection = CourseReaderContract.CourseEntry.COLUMN_NAME_TITLE + " = ?";
        // String[] selectionArgs = { "Calculo 1" };

        String selection = null;
        String[] selectionArgs = null;

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                courseEntry.COLUMN_NAME_TITLE + " DESC";

        Cursor c = db.query(
                courseEntry.TABLE_NAME,     // The table to query
                projection,                 // The columns to return
                selection,                  // The columns for the WHERE clause
                selectionArgs,              // The values for the WHERE clause
                null,               // don't group the rows
                null,                // don't filter by row groups
                sortOrder                    // The sort order
        );

        ArrayList<Course> courses = new ArrayList<Course>();
        while(c.moveToNext()) {
            Integer id = c.getInt(0);
            String title = c.getString(1);
            Course course = new Course(id, title);
            courses.add(course);
        }

        return courses;
    }
}

package com.dcv.claudio.mantenedordenotas.db.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dcv.claudio.mantenedordenotas.db.readers.CourseReaderContract;
import com.dcv.claudio.mantenedordenotas.db.readers.DatabaseHelper;
import com.dcv.claudio.mantenedordenotas.objects.Course;

import java.util.ArrayList;


public class CourseModel {
    private DatabaseHelper evaluationReaderDbHelper;
    private CourseReaderContract.CourseEntry courseEntry;
    public CourseModel(Context context) {
        evaluationReaderDbHelper = new DatabaseHelper(context);
    }

    public long create(Course course) {
        SQLiteDatabase db = evaluationReaderDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(courseEntry.COLUMN_NAME_TITLE, course.getTitle());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(courseEntry.TABLE_NAME, null, values);

        db.close();

        return newRowId;
    }
    public ArrayList<Course> getAll() {
        SQLiteDatabase db = evaluationReaderDbHelper.getReadableDatabase();

        String[] projection = {
                courseEntry._ID,
                courseEntry.COLUMN_NAME_TITLE
        };
        String sortOrder = courseEntry.COLUMN_NAME_TITLE + " DESC";

        Cursor c = db.query(
                courseEntry.TABLE_NAME,     // The table to query
                projection,                 // The columns to return
                null,                  // The columns for the WHERE clause
                null,              // The values for the WHERE clause
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

        db.close();

        return courses;
    }

    public Course get(Integer id) {
        SQLiteDatabase db = evaluationReaderDbHelper.getReadableDatabase();
        String[] projection = {
                courseEntry._ID,
                courseEntry.COLUMN_NAME_TITLE
        };

        String selection = CourseReaderContract.CourseEntry._ID + " = ?";
        String[] selectionArgs = { id.toString() };
        String sortOrder = courseEntry.COLUMN_NAME_TITLE + " DESC";

        Cursor c = db.query(
                courseEntry.TABLE_NAME,     // The table to query
                projection,                 // The columns to return
                selection,                  // The columns for the WHERE clause
                selectionArgs,              // The values for the WHERE clause
                null,               // don't group the rows
                null,                // don't filter by row groups
                sortOrder                    // The sort order
        );

        if (c.getCount() > 0) {
            c.moveToFirst();
            Integer _id = c.getInt(c.getColumnIndex(courseEntry._ID));
            String _title = c.getString(c.getColumnIndex(courseEntry.COLUMN_NAME_TITLE));
            Course course = new Course(_id, _title);

            db.close();

            return course;
        }

        db.close();

        return null;
    }

    public Course getByTitle(String title) {
        SQLiteDatabase db = evaluationReaderDbHelper.getReadableDatabase();
        String[] projection = {
                courseEntry._ID,
                courseEntry.COLUMN_NAME_TITLE
        };

        String selection = CourseReaderContract.CourseEntry.COLUMN_NAME_TITLE + " = ?";
        String[] selectionArgs = { title };
        String sortOrder = courseEntry.COLUMN_NAME_TITLE + " DESC";

        Cursor c = db.query(
                courseEntry.TABLE_NAME,     // The table to query
                projection,                 // The columns to return
                selection,                  // The columns for the WHERE clause
                selectionArgs,              // The values for the WHERE clause
                null,               // don't group the rows
                null,                // don't filter by row groups
                sortOrder                    // The sort order
        );

        if (c.getCount() > 0) {
            c.moveToFirst();
            Integer _id = c.getInt(c.getColumnIndex(courseEntry._ID));
            String _title = c.getString(c.getColumnIndex(courseEntry.COLUMN_NAME_TITLE));
            Course course = new Course(_id, _title);

            db.close();

            return course;
        }

        db.close();

        return null;
    }
}

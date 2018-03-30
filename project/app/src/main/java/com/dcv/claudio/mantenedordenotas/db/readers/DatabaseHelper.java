package com.dcv.claudio.mantenedordenotas.db.readers;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "evaluation.db";
    private static final String LOG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CourseReaderContract.SQL_CREATE_ENTRIES);
        db.execSQL(StudentReaderContract.SQL_CREATE_ENTRIES);
        db.execSQL(CourseStudentReaderContract.SQL_CREATE_ENTRIES);
        db.execSQL(EvaluationReaderContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CourseReaderContract.SQL_DELETE_ENTRIES);
        db.execSQL(StudentReaderContract.SQL_DELETE_ENTRIES);
        db.execSQL(CourseReaderContract.SQL_DELETE_ENTRIES);
        db.execSQL(CourseStudentReaderContract.SQL_DELETE_ENTRIES);
        db.execSQL(EvaluationReaderContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}

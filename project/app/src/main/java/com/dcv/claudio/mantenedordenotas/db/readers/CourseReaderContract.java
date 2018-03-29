package com.dcv.claudio.mantenedordenotas.db.readers;

import android.provider.BaseColumns;

/**
 * Created by claudio on 29-03-18.
 */

public final class CourseReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private CourseReaderContract() {}

    /* Inner class that defines the table contents */
    public static class CourseEntry implements BaseColumns {
        public static final String TABLE_NAME = "course";
        public static final String COLUMN_NAME_TITLE = "title";
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    protected static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + CourseReaderContract.CourseEntry.TABLE_NAME + " (" +
                    CourseReaderContract.CourseEntry._ID + " INTEGER PRIMARY KEY," +
                    CourseReaderContract.CourseEntry.COLUMN_NAME_TITLE + TEXT_TYPE + " )";

    protected static final java.lang.String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + CourseReaderContract.CourseEntry.TABLE_NAME;

}
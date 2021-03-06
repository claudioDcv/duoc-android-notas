package com.dcv.claudio.mantenedordenotas.db.readers;

import android.provider.BaseColumns;

public final class CourseReaderContract {
    private CourseReaderContract() {}

    public static class CourseEntry implements BaseColumns {
        public static final String TABLE_NAME = "course";
        public static final String COLUMN_NAME_TITLE = "title";
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + CourseEntry.TABLE_NAME + " (" +
                    CourseEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    CourseEntry.COLUMN_NAME_TITLE + TEXT_TYPE + " UNIQUE)";

    public static final java.lang.String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + CourseEntry.TABLE_NAME;
}
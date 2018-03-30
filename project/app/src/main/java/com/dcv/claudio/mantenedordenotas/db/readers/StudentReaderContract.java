package com.dcv.claudio.mantenedordenotas.db.readers;

import android.provider.BaseColumns;

public final class StudentReaderContract {
    private StudentReaderContract() {}

    /* Inner class that defines the table contents */
    public static class StudentEntry implements BaseColumns {
        public static final String TABLE_NAME = "student";
        public static final String COLUMN_NAME_FULL_NAME = "full_name";
        public static final String COLUMN_NAME_NATURAL_KEY = "natural_key";
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + StudentEntry.TABLE_NAME + " (" +
                    StudentEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    StudentEntry.COLUMN_NAME_FULL_NAME + TEXT_TYPE + COMMA_SEP +
                    StudentEntry.COLUMN_NAME_NATURAL_KEY + TEXT_TYPE + " UNIQUE )";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + StudentEntry.TABLE_NAME;

}
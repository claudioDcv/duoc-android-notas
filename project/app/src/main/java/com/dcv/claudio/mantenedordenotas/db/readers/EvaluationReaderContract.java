package com.dcv.claudio.mantenedordenotas.db.readers;

import android.provider.BaseColumns;

public final class EvaluationReaderContract {
    private EvaluationReaderContract() {}

    /* Inner class that defines the table contents */
    public static class EvaluationStudentEntry implements BaseColumns {
        public static final String TABLE_NAME = "evaluation";
        public static final String COLUMN_NAME_VALUE = "value";
        public static final String COLUMN_NAME_COURSE_STUDENT_ID = "course_student_id";
    }

    private static final String INTEGER_TYPE = " INTEGER";
    private static final String DOUBLE_TYPE = " DOUBLE";
    private static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + EvaluationStudentEntry.TABLE_NAME + " (" +
                    EvaluationStudentEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    EvaluationStudentEntry.COLUMN_NAME_VALUE + INTEGER_TYPE + COMMA_SEP +
                    EvaluationStudentEntry.COLUMN_NAME_COURSE_STUDENT_ID + INTEGER_TYPE + COMMA_SEP +
                    "FOREIGN KEY ("+ EvaluationStudentEntry.COLUMN_NAME_COURSE_STUDENT_ID + " ) REFERENCES course_student(id))";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + EvaluationStudentEntry.TABLE_NAME;

}
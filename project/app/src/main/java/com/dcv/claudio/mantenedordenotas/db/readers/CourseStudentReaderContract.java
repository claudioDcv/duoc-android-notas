package com.dcv.claudio.mantenedordenotas.db.readers;

import android.provider.BaseColumns;

public final class CourseStudentReaderContract {
    private CourseStudentReaderContract() {}

    /* Inner class that defines the table contents */
    public static class CourseStudentEntry implements BaseColumns {
        public static final String TABLE_NAME = "course_student";
        public static final String COLUMN_NAME_COURSE_ID = "course_id";
        public static final String COLUMN_NAME_STUDENT_ID = "student_id";
    }

    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + CourseStudentEntry.TABLE_NAME + " (" +
                    CourseStudentEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    CourseStudentEntry.COLUMN_NAME_COURSE_ID + INTEGER_TYPE + COMMA_SEP +
                    CourseStudentEntry.COLUMN_NAME_STUDENT_ID + INTEGER_TYPE + COMMA_SEP +
                    "FOREIGN KEY ("+ CourseStudentEntry.COLUMN_NAME_COURSE_ID + " ) REFERENCES course(id)" + COMMA_SEP +
                    "FOREIGN KEY ("+ CourseStudentEntry.COLUMN_NAME_STUDENT_ID + " ) REFERENCES student(id))";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + CourseStudentEntry.TABLE_NAME;

}
# duoc android notas

##  Version support
- android Lollipop 5.0
- create in JAVA

## MODEL

```sql
CREATE TABLE course(id INTEGER PRIMARY KEY, title  TEXT);
CREATE TABLE student(id INTEGER PRIMARY KEY, full_name TEXT, natural_key  TEXT UNIQUE);
CREATE TABLE course_student(id INTEGER PRIMARY KEY, course_id INTEGER, student_id   INTEGER,FOREIGN KEY (course_id) REFERENCES course(id),FOREIGN KEY (student_id) REFERENCES student(id));
CREATE TABLE evaluation(id INTEGER PRIMARY KEY, evaluation_id INTEGER, value DOUBLE,FOREIGN KEY (evaluation_id) REFERENCES course_student(id));
```
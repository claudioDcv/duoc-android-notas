package com.dcv.claudio.mantenedordenotas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dcv.claudio.mantenedordenotas.objects.Course;

import java.util.ArrayList;

/**
 * Created by claudio on 30-03-18.
 */

public class AdapterCourse extends BaseAdapter {

    protected Activity activity;
    protected Course course;
    protected ArrayList<Course> courses;

    public AdapterCourse (Activity activity, ArrayList<Course> courses) {
        this.activity = activity;
        this.courses = courses;
    }

    public AdapterCourse (Course course, ArrayList<Course> courses) {
        this.course = course;
        this.courses = courses;
    }

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Object getItem(int i) {
        return this.courses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;

        if (view == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.activity_course_item, null);
        }

        Course dir = courses.get(i);

        TextView id = v.findViewById(R.id.txtCourseItemSubtitle);
        id.setText(dir.getId().toString());

        TextView title = v.findViewById(R.id.txtCourseItemTitle);
        title.setText(dir.getTitle());

        return v;
    }

    public void clear() {
        this.courses.clear();
    }

    public void addAll(ArrayList<Course> courses) {
        for (int i = 0; i < courses.size(); i++) {
            this.courses.add(courses.get(i));
        }
    }
}

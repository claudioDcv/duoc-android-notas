package com.dcv.claudio.mantenedordenotas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dcv.claudio.mantenedordenotas.db.models.CourseModel;
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

    private void  msg(Context c, String texto) {
        Toast t = Toast.makeText(c, texto, Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = view;

        ImageButton btnEdit;

        if (view == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.activity_course_item, null);
        }

        final Course cour = courses.get(i);

        final TextView id = v.findViewById(R.id.txtCourseItemSubtitle);
        id.setText(cour.getId().toString());

        TextView title = v.findViewById(R.id.txtCourseItemTitle);
        title.setText(cour.getTitle());

        btnEdit = v.findViewById(R.id.button_edit);

        btnEdit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Integer _id = Integer.parseInt(id.getText().toString());
                // msg(view.getContext(), id.getText().toString());

                activity.finish();

                Intent intent = new Intent(activity, EditCourseActivity.class);
                intent.putExtra("id", _id);
                activity.startActivity(intent);
            }
        });

        ImageButton btnDelete = v.findViewById(R.id.button_remove);

        final AdapterCourse self = this;
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CourseModel courseModel = new CourseModel(view.getContext());

                Integer _id = cour.getId();
                Integer id = courseModel.delete(_id);
                // msg(view.getContext(), "Elemento eliminado con exito: " + id);

                self.courses.remove(i);
                self.notifyDataSetChanged();
            }
        });
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

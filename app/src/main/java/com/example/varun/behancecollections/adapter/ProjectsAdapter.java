package com.example.varun.behancecollections.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.varun.behancecollections.R;
import com.example.varun.behancecollections.model.CoverImage;
import com.example.varun.behancecollections.model.Project;

import java.util.List;

/**
 * Created by varun on 12-05-2018.
 */

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.MyViewHolder> {


    private Context mContext;
    private List<Project> projectList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, projectId;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            projectId = (TextView) view.findViewById(R.id.projectId);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    public ProjectsAdapter(Context mContext, List<Project> projectList) {
        this.mContext = mContext;
        this.projectList = projectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project_card,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Project project = projectList.get(position);
        holder.title.setText(project.getName());
        holder.projectId.setText(Integer.toString(project.getId()));

        CoverImage covers = project.getCovers();
        Glide.with(mContext).load(covers.getCover_230()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }
}

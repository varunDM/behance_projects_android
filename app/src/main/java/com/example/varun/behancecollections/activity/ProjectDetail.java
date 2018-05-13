package com.example.varun.behancecollections.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.varun.behancecollections.R;
import com.example.varun.behancecollections.model.Project;
import com.example.varun.behancecollections.model.ProjectDetailResponse;
import com.example.varun.behancecollections.model.ProjectsResponse;
import com.example.varun.behancecollections.network.ApiClient;
import com.example.varun.behancecollections.network.ApiInterface;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectDetail extends AppCompatActivity {

    private Project projectDetail = new Project();

    private static final String TAG = "ProjectDetail";
    private static final String API_KEY = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        Project project = (Project) getIntent().getParcelableExtra("project");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(project.getName());

        setCoverImage(project.getCoverImageUrl());
        fetchProjectDetail(project.getId());
    }


    private void setCoverImage(String url) {
        try {
            ImageView backgrop = (ImageView) findViewById(R.id.backdrop);
            Glide.with(this).load(url).into(backgrop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchProjectDetail(int projectId) {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ProjectDetailResponse> call = apiService.getProjectDetail(projectId,API_KEY);
        call.enqueue(new Callback<ProjectDetailResponse>() {
            @Override
            public void onResponse(Call<ProjectDetailResponse> call, Response<ProjectDetailResponse> response) {
                projectDetail = response.body().getResults();
                TextView desc = (TextView) findViewById(R.id.description);
                desc.setText(projectDetail.getDescription());
            }

            @Override
            public void onFailure(Call<ProjectDetailResponse> call, Throwable t) {
                Log.d(TAG, "onFailure:" + t.toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
        return true;
    }
}

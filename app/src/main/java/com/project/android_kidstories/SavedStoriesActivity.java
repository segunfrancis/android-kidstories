package com.project.android_kidstories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.project.android_kidstories.Model.Story;
import com.project.android_kidstories.Views.main.MainActivity;
import com.project.android_kidstories.adapters.SavedStoriesAdapter;
import com.project.android_kidstories.database.StoryLab;

import java.util.ArrayList;
import java.util.List;

public class SavedStoriesActivity extends AppCompatActivity {

    StoryLab storyLab;

    RecyclerView recyclerView;
    SavedStoriesAdapter adapter;
    private Toolbar toolbar;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_stories);
        storyLab = StoryLab.get(this);
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Saved Stories");
        recyclerView = findViewById(R.id.saved_stories_recycler);

        adapter = new SavedStoriesAdapter(this, storyLab.getStories());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                finish();
                break;
        }
        return  true;
    }
}

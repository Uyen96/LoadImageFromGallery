package com.example.uyen.loadimagefromgallery;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static int NUMBER_IMAGE_DISPLAY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        List<Image> images = getData();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, NUMBER_IMAGE_DISPLAY));
        ImageAdapter adapter = new ImageAdapter(this, images);
        recyclerView.setAdapter(adapter);
    }

    private List<Image> getData() {
        List<Image> images = new ArrayList<>();
        File imageFolder =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        Image image;
        if (imageFolder.exists()) {
            File[] files = imageFolder.listFiles();
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                image = new Image();
                image.setUri(Uri.fromFile(file));
                images.add(image);
            }
        }
        return images;
    }
}

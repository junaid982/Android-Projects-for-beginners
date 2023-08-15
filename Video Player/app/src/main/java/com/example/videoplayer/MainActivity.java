package com.example.videoplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements VideoRVAdapter.videoClickInterface {

    private RecyclerView videoRV;
    private ArrayList<VideoRVModel> videoRVModelArrayList;
    private VideoRVAdapter videoRVAdapter;

    private static final int STORAGE_PERMISSION = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoRV = findViewById(R.id.idRVVideo);
        videoRVModelArrayList = new ArrayList<>();
        videoRVAdapter = new VideoRVAdapter(videoRVModelArrayList , this,this::onVideoCLick);

        videoRV.setLayoutManager(new GridLayoutManager(this , 3));
        videoRV.setAdapter(videoRVAdapter);

        if(ContextCompat.checkSelfPermission(MainActivity.this , Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(MainActivity.this , new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION);
        }else{
            getVideos();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==STORAGE_PERMISSION){
            if(grantResults.length > 0 && grantResults[0] ==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                getVideos();
            }else{
                Toast.makeText(this, "The App Will not work without permission", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    private void getVideos() {

        ContentResolver contentResolver = getContentResolver();
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

        Cursor cursor = contentResolver.query(uri , null , null , null , null);

        if(cursor!= null && cursor.moveToFirst()){
            do{
                @SuppressLint("Range") String videoTitle = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.TITLE));
                @SuppressLint("Range") String videoPath = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
                Bitmap videoThumbnail = ThumbnailUtils.createVideoThumbnail(videoPath , MediaStore.Images.Thumbnails.MICRO_KIND);

                videoRVModelArrayList.add(new VideoRVModel(videoTitle , videoPath , videoThumbnail));

            }while(cursor.moveToNext());

        }

        videoRVAdapter.notifyDataSetChanged();
    }

    @Override
    public void onVideoCLick(int position) {

    }
}
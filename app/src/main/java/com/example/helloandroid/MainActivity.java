package com.example.helloandroid;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    myPictureView myPicture;
    String imageFname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        myPicture = (myPictureView) findViewById(R.id.myPictureView1);
        File[] allFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures").listFiles();
        assert allFiles != null;
        if(allFiles.length>0){
            imageFname = allFiles[0].toString();
            myPicture.imagePath=imageFname;
        }
        else{
            imageFname = "";
        }
    }
}
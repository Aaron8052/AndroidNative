package com.AaronJ.androidnative;

import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;


public class AndroidNative extends AppCompatActivity {

    static AndroidNative instance;

    public static AndroidNative getInstance(){
        if(instance == null)
            instance = new AndroidNative();
        return instance;
    }

    public void Share(String title, String message, String url, String imagePath){
        Intent intent = new Intent(Intent.ACTION_SEND);
        if(imagePath.isEmpty()){
            intent.setType("text/plain");
        }
        else{
            intent.setType("image/png");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.parse(imagePath));
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }

        intent.putExtra(Intent.EXTRA_TITLE, message);
        intent.putExtra(Intent.EXTRA_TEXT, url);


        Intent.createChooser(intent,"Share Score");
        startActivity(Intent.createChooser(intent,"Share Score"));
    }

    public void Share(String message){
        Share("Share", message, null,null);
    }
    public void Share(String title, String message){
        Share(title, message, null,null);
    }
    public void Share(String title, String message, String url){
        Share(title, message, url,null);
    }
}
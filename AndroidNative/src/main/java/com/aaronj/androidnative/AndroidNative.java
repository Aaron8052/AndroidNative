package com.AaronJ.androidnative;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Build;

import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Locale;
import com.unity3d.player.UnityPlayer;

public class AndroidNative extends Activity {
    static AndroidNative instance;

    public static AndroidNative getInstance(){
        if(instance == null)
            instance = new AndroidNative();
        return instance;
    }
    Context getContext(){
        return UnityPlayer.currentActivity;
    }

    private static final String AUTHORITY="com.AaronJ.androidnative";


    //region Share
    public void shareTextAndImage(String title, String message, String url, String imagePath){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);//Create Send Action
        intent.putExtra(Intent.EXTRA_TITLE, message); //Add message as title
        intent.putExtra(Intent.EXTRA_TEXT, url);//Add url as text for user to copy

        File imageFile = new File(imagePath);//Get image file from path
        if(imageFile != null){
            Uri imageUri = FileProvider.getUriForFile(this, AUTHORITY, imageFile);
            intent.putExtra(Intent.EXTRA_STREAM, imageUri);//Add image file by path

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){//show preview for image if sdk level >= 29
                intent.setData(imageUri);
            }
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);//Grant read file permission

            //Get and set file extension (Type)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {  //For sdk version higher than 26
                try {
                    intent.setType("image/"+ Files.probeContentType(imageFile.toPath()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{   //Fallback
                String fileName = imageFile.getName();
                intent.setType("image/"+ fileName.substring(fileName.lastIndexOf('.')+1));
            }
        }

        getContext().startActivity(Intent.createChooser(intent, title));//Show Sharing Panel
    }

    public void shareText(String message){
        Intent intent = new Intent(Intent.ACTION_SEND);//Create Send Action
        intent.putExtra(Intent.EXTRA_TEXT, message);//Add message as text for user to copy
        intent.setType("text/plain");
        getContext().startActivity(Intent.createChooser(intent,null));//Show Sharing Panel
    }
    public void shareTextWithTitle(String title, String message){
        Intent intent = new Intent(Intent.ACTION_SEND);//Create Send Action
        intent.putExtra(Intent.EXTRA_TEXT, message);//Add message as text for user to copy
        intent.setType("text/plain");
        getContext().startActivity(Intent.createChooser(intent, title));//Show Sharing Panel
    }
    public void shareTextWithURL(String title, String message, String url){
        Intent intent = new Intent(Intent.ACTION_SEND);//Create Send Action
        intent.putExtra(Intent.EXTRA_TITLE, message); //Add message as title
        intent.putExtra(Intent.EXTRA_TEXT, url);//Add url as text for user to copy
        intent.setType("text/plain");
        getContext().startActivity(Intent.createChooser(intent, title));//Show Sharing Panel
    }
    //endregion

    //region Utilities

    public String getISOCountry(){
        return Locale.getDefault().getCountry();
    }
    public String getISOLanguage(){
        return Locale.getDefault().getLanguage();
    }

    public float getBatteryPercentage(){
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = getContext().registerReceiver(null, ifilter);
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        float batteryPct = level * 100 / (float)scale;
        return batteryPct;
    }
    //endregion
}
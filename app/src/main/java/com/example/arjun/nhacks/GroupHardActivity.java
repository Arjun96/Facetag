package com.example.arjun.nhacks;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.content.ContextWrapper;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Images.Media;



public class GroupHardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    public static final int MEDIA_TYPE_IMAGE = 1;//wont need bc no video, only photos

    private Uri fileUri;
    public Bitmap capture = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_hard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add(view);

                //Intent intent = new Intent(GroupHardActivity.this, ScanResults.class);
               // intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                //startActivity(intent);

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fab.setRippleColor(12397);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.group_hard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nhacks) {
        } else if (id == R.id.oweek) {

        } else if (id == R.id.wasaga) {

        } else if (id == R.id.ewb) {

        } else if (id == R.id.setting) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //////////////////////////////////////////////////
    public void exit(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        //capture = (Bitmap) data.getExtras().get("data");

        if (resultCode == RESULT_OK) {
            Intent i;//UNEEDED
            switch (requestCode) {
                case CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE:
                    Uri uri = fileUri;
                    break;
            }
        }




        //BRANDON CODE

        /*
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                //iv.setImageBitmap(bp);
                storeImage(bp);
            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the image capture
            } else {
                // Image capture failed, advise user
            }

        }

*/      //Step 3 of capturing picture
        Intent inte = new Intent(this, ScanResults.class);
        startActivity(inte);


    }

/*
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), GroupsActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }*/

    public void add(View view){
        //Step 1 of capturing picture
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

        /////////////////////////Check why URI not needed
       // store();
        fileUri = getOutputMediaFileUri(); // create a file to save the image
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name
        //Step 2 of capturing picture
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

        //startActivity(new Intent(view.getContext(), ScanResults.class));

    }

    public void storeImage(Bitmap image) {
        File pictureFile = getOutputMediaFile();
        FileOutputStream fos = null;
        if (pictureFile == null) {
            //   Log.d(TAG,
            //         "Error creating media file, check storage permissions: ");// e.getMessage());
            return;
        }
        try {
            fos = new FileOutputStream(pictureFile);
            image.compress(Bitmap.CompressFormat.PNG, 90, fos);
            fos.close();
        } catch (FileNotFoundException e) {
            //Log.d(TAG, "File not found: " + e.getMessage());
        } catch (IOException e) {
            // Log.d(TAG, "Error accessing file: " + e.getMessage());
        }



    }
    public Uri getOutputMediaFileUri(){
        return Uri.fromFile(getOutputMediaFile());
    }
    public static File mediaStorageDir;
    public void store(){
        File a = this.getDir("capturePic", 0);
        mediaStorageDir = new File(a.getParent(), "DemoFile");

        if (mediaStorageDir.isDirectory()){
            Log.i("aa","a");

        }
        if (mediaStorageDir.isFile()){
            Log.i("bb","b");

        }

    }
    private File getOutputMediaFile(){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
       // File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
               // Environment.DIRECTORY_PICTURES), "MyCameraApp");

       // /*
      //  Context a = this.getApplicationContext();getExternalFilesDir getExternalStorageDirectory
        mediaStorageDir = new File(Environment.getExternalStorageDirectory()
                + "/Android/data/"  + "Captures");


        //*/// for use in external storage. not too sure to use if cannot use getApplicationContext().
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist


        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.i("dsa","dsa");
            }
        }





        // Create a media file name
        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());
        File mediaFile;
        String mImageName="MI_"+ timeStamp +".jpg";
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + mImageName);
        //this.getCapture().BitmapFactory.decodeFile(mediaFile.getAbsolutePath());
        Log.v("WHHYY", mediaStorageDir + "\n");
        Log.v ("WHHYY",mediaFile + "\n");
        return mediaFile;

    }

   public Bitmap getCapture(){
        return capture;
  }

    public void setCapture(Bitmap cap){
         capture = cap;
    }

}


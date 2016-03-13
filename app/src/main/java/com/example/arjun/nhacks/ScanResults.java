package com.example.arjun.nhacks;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.io.ByteArrayOutputStream;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.database.Cursor;
import android.widget.ImageView;
import java.io.File;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ScanResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        /**************
         *
         *
         * ADD ACTION BAR AND BUTTON THAT GOES BACK TO ListFacesActivity.class
         *
         *
         *



        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //Converts most recent picture to base64 string
        String[] projection = {
                MediaStore.Images.ImageColumns._ID,
                MediaStore.Images.ImageColumns.DATA,
                MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME,
                MediaStore.Images.ImageColumns.DATE_TAKEN,
                MediaStore.Images.ImageColumns.MIME_TYPE};
        //Finds most recent picture
        Log.i("fa",projection[0]);
        Log.i("fa",projection[1]);
        Log.i("fa",projection[2]);
        Log.i("fa",projection[3]);
        Log.i("fa",projection[4]);

        Log.i("Fuck", GroupHardActivity.getOutputMediaFileUri().toString());
        Log.i("Fuck", GroupHardActivity.getFileUri().toString());

        Cursor cursor = this.getContentResolver().query(GroupHardActivity.getFileUri(), projection, null, null, null);



        int column_index_data = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String capturedImageFilePath = cursor.getString(column_index_data);
        //Sets picture location to new file
        File imageFile = new File(capturedImageFilePath);
        //Converts image to bitmap
        Bitmap bp = null;
        if (imageFile.exists()) {   // TODO: is there a better way to do this?
            bp = BitmapFactory.decodeFile(capturedImageFilePath);
        }

        GroupHardActivity gHA = new GroupHardActivity();

        //Bitmap bp = GroupHardActivity.getCapture();
        //converts bitmap to base64
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        gHA.setCapture(compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String base64string =Base64.encodeToString(byteArray, Base64.DEFAULT);

        ///Checks if decoded wrong
        LinearLayout linearLayout= new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        linearLayout.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));

        byte[] decodedString = Base64.decode(base64string, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        ImageView base64check = new ImageView(this);
        base64check.setImageBitmap(decodedByte);
        //setting image position

        base64check.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

        //adding view to layout
        linearLayout.addView(base64check);
        //make visible to program
        setContentView(linearLayout);

         */


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scan_resutls, menu);
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
}

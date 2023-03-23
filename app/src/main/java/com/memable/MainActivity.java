package com.memable;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.memable.databinding.ActivityMainBinding;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private LinearLayout recents;
    private TextView emptyRecent;

    private SearchView searchView;
    public static final int IMAGE_RESPONSE = 3;

    /**
     * Convert an image to an array of bytes so it can be passed to another activity
     * @param bmp Bitmap to convert
     * @return Bitmap in byte[] and compressed in the JPEG format
     */
    private byte[] bitmapToBytes(Bitmap bmp){
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, bStream);
        return bStream.toByteArray();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.memable.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        Toolbar toolbar = binding.appBarMain.toolbar;
        recents = binding.appBarMain.contentMain.recentImages;
        emptyRecent = binding.appBarMain.contentMain.emptyRecent;
        searchView = binding.appBarMain.searchView;

        searchView.setOnClickListener(v -> searchView.setIconified(false));

        toolbar.setNavigationOnClickListener(this::openDrawer);
        //setSupportActionBar(binding.appBarMain.toolbar);

        drawer = binding.drawerLayout;


    }

    /**
     * Edit an empty image
     * @param view
     */
    public void editNew(View view) {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.defaultbackground);
        Intent intent = new Intent(this, EditActivity.class);
        byte[] byteArray = bitmapToBytes(bmp);
        intent.putExtra("image", byteArray);
        startActivityForResult(intent, IMAGE_RESPONSE);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == IMAGE_RESPONSE && resultCode == RESULT_OK) {
            System.out.println("OUI");
            Bitmap bitmap;
            byte[] byteArray = intent.getByteArrayExtra("image");
            bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

            ImageView newImage = new ImageView(this);
            newImage.setImageBitmap(bitmap);
            int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics());

            recents.addView(newImage);
            newImage.getLayoutParams().height = dimensionInDp;
            newImage.getLayoutParams().width = dimensionInDp;
            newImage.requestLayout();
        } else {
            System.out.println("NON");
        }

        if (recents.getChildCount() > 0){
            emptyRecent.setVisibility(View.INVISIBLE);
        } else {
            emptyRecent.setVisibility(View.VISIBLE);
        }

    }

    /**
     * Opens the drawer from the left side of the screen
     * @param view
     */
    public void openDrawer(View view) {
        drawer.openDrawer(GravityCompat.START);
    }

    /**
     * Sends an image to the image editor.
     * @param view ImageView containing the image
     */
    public void editImage(View view){
        ImageView imgView = (ImageView) view;
        imgView.setDrawingCacheEnabled(true);
        Bitmap bmp = imgView.getDrawingCache();
        Intent intent = new Intent(this, EditActivity.class);
        byte[] byteArray = bitmapToBytes(bmp);
        intent.putExtra("image", byteArray);
        startActivityForResult(intent, IMAGE_RESPONSE);
    }

}
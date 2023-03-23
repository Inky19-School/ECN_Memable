package com.memable;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.memable.databinding.ActivityMainBinding;
import com.memable.databinding.ContentMainBinding;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private DrawerLayout drawer;
    private LinearLayout recents;
    public static final int IMAGE_RESPONSE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        Toolbar toolbar = binding.appBarMain.toolbar;
        recents = binding.appBarMain.contentMain.recentImages;



        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(v);
            }
        });
        //setSupportActionBar(binding.appBarMain.toolbar);

        drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();


    }
    public void switchActivities(View view) {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.defaultbackground);
        Intent intent = new Intent(this, EditActivity.class);
        //intent.putExtra("Image", bmp);
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, bStream);
        byte[] byteArray = bStream.toByteArray();
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_RESPONSE && resultCode == RESULT_OK) {
            System.out.println("OUI");
        } else {
            System.out.println("NON");
        }

    }

    public void openDrawer(View view) {
        drawer.openDrawer(Gravity.LEFT);
    }

    public void editImage(View view){
        ImageView imgView = (ImageView) view;
        imgView.setDrawingCacheEnabled(true);
        Bitmap bmp = imgView.getDrawingCache();
        Intent intent = new Intent(this, EditActivity.class);
        //intent.putExtra("Image", bmp);
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, bStream);
        byte[] byteArray = bStream.toByteArray();
        intent.putExtra("image", byteArray);
        startActivityForResult(intent, IMAGE_RESPONSE);
    }

    public void addRecent(View view){
        ImageView newImage = new ImageView(this);
        newImage.setImageResource(R.drawable.venus);
        int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics());

        recents.addView(newImage);
        newImage.getLayoutParams().height = dimensionInDp;
        newImage.getLayoutParams().width = dimensionInDp;
        newImage.requestLayout();
    }

}
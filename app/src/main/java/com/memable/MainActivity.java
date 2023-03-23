package com.memable;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.memable.databinding.ActivityMainBinding;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private DrawerLayout drawer;
    private LinearLayout recents;
    private TextView emptyRecent;

    private SearchView searchView;
    public static final int IMAGE_RESPONSE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        Toolbar toolbar = binding.appBarMain.toolbar;
        recents = binding.appBarMain.contentMain.recentImages;
        emptyRecent = binding.appBarMain.contentMain.emptyRecent;
        searchView = binding.appBarMain.searchView;

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setIconified(false);
            }
        });

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
                R.id.drawer_settings, R.id.drawer_profile, R.id.drawer_about)
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
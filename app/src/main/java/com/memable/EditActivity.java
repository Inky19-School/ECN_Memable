package com.memable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;

public class EditActivity extends AppCompatActivity {
    ImageView image;
    Spinner spinner;
    Spinner spinner2;
    EditText fontSize;

    ImageButton previewImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();
        Bitmap bitmap;
        byte[] byteArray = intent.getByteArrayExtra("image");
        bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        image = (ImageView) findViewById(R.id.imageWindow);
        image.setImageBitmap(bitmap);

        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        previewImage = (ImageButton) findViewById(R.id.previewImage);
        previewImage.setImageBitmap(bitmap);


        fontSize = (EditText) findViewById(R.id.fontSize);
        fontSize.setText("12");
        //Spinner
        spinner = (Spinner) findViewById(R.id.mode_spinner);
        spinner2 = (Spinner) findViewById(R.id.family_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.mode_array, android.R.layout.simple_spinner_dropdown_item);
        // Specify the layout to use when the list of choices appears
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.font_array, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);
        spinner.setAdapter(adapter);
    }

    /**
     * Renvoie l'image éditée à la page d'accueil et ferme la page
     * @param view
     */
    public void returnImage(View view) {
        image.setDrawingCacheEnabled(true);
        Bitmap bmp = image.getDrawingCache();
        Intent intent = new Intent(this, EditActivity.class);
        //intent.putExtra("Image", bmp);
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, bStream);
        byte[] byteArray = bStream.toByteArray();
        intent.putExtra("image", byteArray);
        setResult(RESULT_OK,intent);
        finish();

    }
}
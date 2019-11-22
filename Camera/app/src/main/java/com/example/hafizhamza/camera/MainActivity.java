package com.example.hafizhamza.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
private ImageView mimageView;
    private static final int Request_Image_Capture=101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mimageView=(ImageView) findViewById(R.id.imageView);
    }

    public void TakePicture(View view) {

        Intent ImageTakeIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (ImageTakeIntent.resolveActivity(getPackageManager())!=null)
        {
startActivityForResult(ImageTakeIntent,Request_Image_Capture);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==Request_Image_Capture && requestCode==RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mimageView.setImageBitmap(imageBitmap);
        }
    }
}

package e.hemant.easymeds;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity {
    final static int REQUEST_CODE =0;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        Intent i= new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,REQUEST_CODE);
    }

    protected void onActivityResult(int requestcode,int resultcode,Intent intent){
        super.onActivityResult(requestcode,resultcode,intent);
        if(resultcode==RESULT_OK){
            Bundle extras=intent.getExtras();
            Bitmap data=(Bitmap) extras.get("data");
            image=(ImageView) findViewById(R.id.imgView_logo);
            image.setImageBitmap(data);
        }
    }
}


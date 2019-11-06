package com.example.chamadapersonalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class add extends AppCompatActivity {

    public static final int PEDIDO_CAPTURAR_IMAGEM = 1;
    private ImageButton imgPessoa;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        this.editText = (EditText)findViewById(R.id.editText);
        this.imgPessoa = (ImageButton)findViewById(R.id.imgPessoa);
    }

    public void tirarFoto(View view){
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePicture.resolveActivity(getPackageManager()) != null){
            startActivityForResult(takePicture, PEDIDO_CAPTURAR_IMAGEM);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PEDIDO_CAPTURAR_IMAGEM){
            if (resultCode == RESULT_OK){
                Bundle bundle = data.getExtras();
                Bitmap ImageBitMap = (Bitmap) bundle.get("data");
                imgPessoa.setImageBitmap(ImageBitMap);
            }
        }
    }
}

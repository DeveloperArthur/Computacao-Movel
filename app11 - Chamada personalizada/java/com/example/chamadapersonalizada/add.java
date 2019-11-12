package com.example.chamadapersonalizada;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chamadapersonalizada.controllers.AlunoBancoController;
import com.example.chamadapersonalizada.entities.Aluno;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class add extends AppCompatActivity {

    public static final int PEDIDO_CAPTURAR_IMAGEM = 1;
    private ImageButton imgPessoa;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        this.editText = (EditText) findViewById(R.id.editText);
        this.imgPessoa = (ImageButton) findViewById(R.id.imgPessoa);
    }

    public void tirarFoto(View view) {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePicture.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePicture, PEDIDO_CAPTURAR_IMAGEM);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PEDIDO_CAPTURAR_IMAGEM) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                Bitmap ImageBitMap = (Bitmap) bundle.get("data");
                imgPessoa.setImageBitmap(ImageBitMap);
            }
        }
    }

    public void salvarDados(View view) {
        Bitmap bm = ((BitmapDrawable) imgPessoa.getDrawable()).getBitmap();
        String nomeArquivo = saveImageFile(bm);
        Log.d("Arquivo Salvo", nomeArquivo);
        Aluno aluno = new Aluno(0, editText.getText().toString(), nomeArquivo);
        if (new AlunoBancoController(this).add(aluno)) {
            Toast.makeText(this, "Aluno cadastrado", Toast.LENGTH_LONG).show();
            finish();
        } else {
            Toast.makeText(this, "Erro ao Cadastrar Aluno", Toast.LENGTH_LONG).show();
        }
    }

    public String saveImageFile(Bitmap bitmap) {
        FileOutputStream out = null;
        String filename = getFilename();
        try {
            out = new FileOutputStream(filename);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return filename;
    }

    private String getFilename() {
        File file = new File(Environment.getExternalStorageDirectory()
                .getPath(), "TestFolder");
        if (!file.exists()) {
            file.mkdirs();
        }
        String uriString = (file.getAbsolutePath() + "/"
                + System.currentTimeMillis() + ".jpg");
        return uriString;
    }
}

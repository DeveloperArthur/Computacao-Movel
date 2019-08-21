package br.uninove.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class ContatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
    }

    public void enviarEmail(View view) {
        Intent emailIt = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",
                "santosalmeida.arthur@gmail.com",
                null
        ));

        emailIt.putExtra(Intent.EXTRA_SUBJECT, "Assunto do E-mail");
        emailIt.putExtra(Intent.EXTRA_TEXT, "Corpo do E-mail");
        startActivity(Intent.createChooser(emailIt, "Enviar email"));
    }

    public void telefonar(View view) {
        Intent telIt = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "966402850"));
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        startActivity(telIt);
    }
}

package com.sbiixpress.sbiixpress;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Nous contacter");
        setContentView(R.layout.activity_contact);
        EditText ET = (EditText) findViewById(R.id.editTextContact);
        ET.setFocusable(false);
        ET.setFocusableInTouchMode(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }

    public void btnSMS(View v) {
        String numero = "33641619879";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + numero)));
    }

    public void btnMail(View v) {
        try {
            String email[] = {"sbiixpress@gmail.com"};
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL, email);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Contact via mobile");
            startActivity(intent);
        }
        catch (Exception e)
        {
            Toast.makeText(getBaseContext(), "Aucun compte mail n'est configuré ou aucune messagerie n'est installé", Toast.LENGTH_LONG).show();
        }
    }

    public void btnPortable (View v)
    {
        requestPermission();
        if (checkPermission())
        {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:0641619879"));
            startActivity(callIntent);
        }
    }

    public void btnBureau (View v)
    {
        requestPermission();
        if (checkPermission())
        {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:0244023942"));
            startActivity(callIntent);
        }
    }

    private boolean checkPermission()
    {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (result == PackageManager.PERMISSION_GRANTED)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private void requestPermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE))
        {
            Toast.makeText(getBaseContext(), "Activer le téléphone dans \"Paramètres > Applications > SBiiXpress > Autorisations\" pour passer un appel", Toast.LENGTH_LONG).show();
        }
        else
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_REQUEST_CODE);
        }
    }
}


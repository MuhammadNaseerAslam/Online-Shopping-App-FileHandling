package com.example.bitf17a039_a1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class PageSendNotifcationActivity extends AppCompatActivity {
    private Button btnSendMessage;
    private Button btnSendEmail;
    private Button btnCancel;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_send_notification);
        btnSendMessage = (Button) findViewById(R.id.btnSendMessage);
        btnSendEmail = (Button) findViewById(R.id.btnSendEmail);

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendMessage();
            }
        });
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendEmail();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {

                finish();
            }
        });
    }



    private void sendMessage()
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("smsto:"));
        i.setType("vnd.android-dir/mms-sms");
        i.putExtra("address", "0306240371");
        i.putExtra("sms_body"  , "Dear you ordered from our Online Shopping Mall Thank You!");

        try {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                if(PageSendNotifcationActivity.this.checkSelfPermission(Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED) {
                    startActivity(i);
                    finish();
                }
                else
                    {

                }
            }else
                {
                startActivity(i);
                finish();
            }

        }
        catch (Exception ex) {
        }
    }

    private void sendEmail()
    {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("mailto:"));
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_EMAIL, "naseeraslam456@gmail.com");
        i.putExtra(Intent.EXTRA_CC, "bitf17a039@pucite.edu.pk");
        i.putExtra(Intent.EXTRA_SUBJECT, "Online Shopping");
        i.putExtra(Intent.EXTRA_TEXT, "Thank for Online Shopping from our Mall");

        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
            finish();
        }
        catch (Exception ex) {
        }
    }
}

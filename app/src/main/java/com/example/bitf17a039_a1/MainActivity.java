package com.example.bitf17a039_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    Button btnNextFp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_one);
        btnNextFp=(Button)findViewById(R.id.btnNextMain);
        btnNextFp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Intent i=new Intent(MainActivity.this,PageOneActivity.class);
        startActivity(i);
    }
}
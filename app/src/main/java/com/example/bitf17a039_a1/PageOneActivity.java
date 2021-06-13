package com.example.bitf17a039_a1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class PageOneActivity extends AppCompatActivity {
    Button btnNextFirst;

    LinearLayout L1,L2,L3,L4;
    ImageView I1,I2,I3,I4;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_two);
        L1=(LinearLayout) findViewById(R.id.llPaper);
        L2=(LinearLayout)findViewById(R.id.llStationary);
        L3=(LinearLayout)findViewById(R.id.llHardDisk);
        L4=(LinearLayout)findViewById(R.id.llWaste);
        I1=(ImageView) findViewById(R.id.ivPaper);
        I2=(ImageView) findViewById(R.id.ivStationary);
        I3=(ImageView) findViewById(R.id.ivHarddisk);
        I4=(ImageView) findViewById(R.id.ivWaste);
        btnNextFirst=(Button)findViewById(R.id.btn_next_first);


        btnNextFirst.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i = new Intent(PageOneActivity.this, PageTwoActivity.class);
                startActivity(i);
            }
        });
        I1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                L1.setBackgroundResource(R.drawable.layoutborder);


            }
        });
        I2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                L2.setBackgroundResource(R.drawable.layoutborder);


            }
        });
        I3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                L3.setBackgroundResource(R.drawable.layoutborder);


            }
        });
        I4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                L4.setBackgroundResource(R.drawable.layoutborder);


            }
        });
    }
}

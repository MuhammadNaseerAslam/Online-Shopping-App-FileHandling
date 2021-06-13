package com.example.bitf17a039_a1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class PageTwoActivity extends AppCompatActivity {


    Button btnNextSecond,btnPreviousSecond;
    EditText edtFirstName,edtLastName,edtEmail,edtContact;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_three);
        edtFirstName=(EditText)findViewById(R.id.edtFName);
        edtLastName=(EditText)findViewById(R.id.edtLName);
        edtEmail = (EditText)findViewById(R.id.edtMail);
        edtContact=(EditText)findViewById(R.id.edtContact);
        btnNextSecond = (Button) findViewById(R.id.btn_next_second);
        btnPreviousSecond = (Button) findViewById(R.id.btn_previous_second);
       tv=(TextView) findViewById(R.id.tvResult);
        //Recieving data

        Intent i=getIntent();
        final String Position2=i.getStringExtra("Position");
        final String Fname2=i.getStringExtra("FirstName");
        final String Lname2=i.getStringExtra("LastName");
        final String Email2=i.getStringExtra("MailId");
        final String Contact2=i.getStringExtra("ContactNo");
        final String Company=i.getStringExtra("Company");
        final String Zipcode=i.getStringExtra("Zip Code");
        final String State=i.getStringExtra("State");
        final String City=i.getStringExtra("City");
        final String Boxes=i.getStringExtra("Boxes");
        final String Time=i.getStringExtra("Time");


      // if(Position2=="true") {
             edtFirstName.setText(Fname2);
           edtLastName.setText(Lname2);
             edtEmail.setText(Email2);
             edtContact.setText(Contact2);
            // tv.setText(Lname2+Position2);
       // }
        btnNextSecond.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v) {
                String Fname = edtFirstName.getText().toString();
                String Lname = edtLastName.getText().toString();
                String Email = edtEmail.getText().toString();
                String Contact = edtContact.getText().toString();
                String data = (Fname + Lname + Email + Contact);
                if (Fname.equals("") || Lname.equals("") || Email.equals("") || Contact.equals(""))
                {
                    Toast.makeText(PageTwoActivity.this, "Please Fill all the fields", Toast.LENGTH_LONG).show();
                }
                else

                    {
                        //Sending data



                        Intent i = new Intent(PageTwoActivity.this, PageThirdActivity.class);

                    i.putExtra("FirstName",Fname);
                    i.putExtra("LastName",Lname);
                    i.putExtra("MailId",Email);
                    i.putExtra("ContactNo",Contact);
                    i.putExtra("Company",Company);
                    i.putExtra("Zip Code",Zipcode);
                    i.putExtra("State",State);
                    i.putExtra("City",City);
                    i.putExtra("Boxes",Boxes);
                    i.putExtra("Time",Time);
                    i.putExtra("Position",Position2);

                    startActivity(i);




                }
            }
        });
        btnPreviousSecond.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {
                edtFirstName.getText().clear();
                edtLastName.getText().clear();
                edtEmail.getText().clear();
                edtContact.getText().clear();
                finish();
            }
        });
    }
}


 /* try
                        {
                            PersonalData p=new PersonalData(Fname,Lname,Email,Contact);
                            data2=(p.Fname+p.Lname+p.Email+p.Contact);
                            FileOutputStream fOut = openFileOutput("file",MODE_APPEND);
                            OutputStreamWriter osw=new OutputStreamWriter(fOut);
                            osw.write(data);
                            osw.flush();
                            osw.close();
                            //Toast.makeText(PageTwoActivity.this,"Data has been inserted into record.txt file sucessfully",Toast.LENGTH_LONG).show();



                        } catch (FileNotFoundException e)
                       {
                           e.printStackTrace();
                       }
                       catch (IOException e)
                       {
                           e.printStackTrace();
                       }

                      */

package com.example.bitf17a039_a1;
import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
        import java.io.FileOutputStream;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PageThirdActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button btnSubmit,btnPreviousthird,btnNextthird,btnSendMessage,btnSendEmail;
    EditText edtCompanyName,edtZipCode,edtState,edtCity;
    Spinner spBoxes;
    String data;
   TextView tv;
    PageThirdActivity ref;
   private int pos=-1;
    private String records="record";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_four);
        edtCompanyName=(EditText)findViewById(R.id.edtCompany);
        edtZipCode=(EditText)findViewById(R.id.edtZip);
        edtState= (EditText)findViewById(R.id.edtState);
        edtCity=(EditText)findViewById(R.id.edtCity);
        tv= (TextView)findViewById(R.id.tvResult);
        spBoxes=(Spinner) findViewById(R.id.spinnerBoxes);
        btnSubmit=(Button)findViewById(R.id.btn_submit);
        btnPreviousthird=(Button)findViewById(R.id.btn_previous_third);
        btnNextthird=(Button)findViewById(R.id.btn_next4);
        btnSendMessage = (Button) findViewById(R.id.btnSendMessage);
        btnSendEmail = (Button) findViewById(R.id.btnSendEmail);



        //Recieving data

       Intent i=getIntent();
        final String Fname=i.getStringExtra("FirstName");
        final String Lname=i.getStringExtra("LastName");
        final String Email=i.getStringExtra("MailId");
        final String Contact=i.getStringExtra("ContactNo");
        final String Company=i.getStringExtra("Company");
        final String Zipcode=i.getStringExtra("Zip Code");
        final String State=i.getStringExtra("State");
        final String City=i.getStringExtra("City");
        final String Boxes=i.getStringExtra("Boxes");
        final String Time=i.getStringExtra("Time");
        final String Position=i.getStringExtra("Position");

        //final int pos=Integer.parseInt(Position);
       // if(Position!=null) {
            edtCompanyName.setText(Company);
            edtZipCode.setText(Zipcode);
            edtState.setText(State);
            edtCity.setText(City);

        //}

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spineritem,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBoxes.setAdapter(adapter);
        spBoxes.setOnItemSelectedListener(this);


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
        btnSubmit.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {
                String CompanyName=edtCompanyName.getText().toString();
                String ZipCode=edtZipCode.getText().toString();
                String State=edtState.getText().toString();
                String City=edtCity.getText().toString();
                String PossibleBoxes=spBoxes.getSelectedItem().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
                String currentDateandTime = sdf.format(new Date());

                if(CompanyName.equals("")||ZipCode.equals("")||State.equals("")||City.equals("")||PossibleBoxes.equals(""))
                {
                    Toast.makeText(PageThirdActivity.this,"Please Fill all the fields",Toast.LENGTH_LONG).show();
                }
                else
                {
                    try
                    {
                        PersonalData p = new PersonalData(Fname, Lname, Email, Contact);
                        CompanyDetail c = new CompanyDetail(CompanyName, ZipCode, City, State, PossibleBoxes,currentDateandTime);
                        Order o = new Order(p, c);
                        data = (o.pd.Fname + "," + o.pd.Lname + "," + o.pd.Email + "," + o.pd.Contact + "," + o.cd.Company + "," + o.cd.ZipCode + "," + o.cd.City + "," + o.cd.State + "," + o.cd.Boxes+","+o.cd.DateAndTime + ",");

                        FileOutputStream fOut = openFileOutput(records, MODE_APPEND);
                        OutputStreamWriter osw = new OutputStreamWriter(fOut);
                        osw.write(data);
                        osw.flush();
                        osw.close();
                        Toast.makeText(PageThirdActivity.this, "Data has been inserted into record.txt file sucessfully", Toast.LENGTH_LONG).show();





                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }


                }
            }
        });
        btnPreviousthird.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v) {
                edtCompanyName.getText().clear();
                edtZipCode.getText().clear();
                edtState.getText().clear();
                edtCity.getText().clear();
                finish();
            }
        });
        btnNextthird.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v) {


                Intent i = new Intent(PageThirdActivity.this, ListScreenActivity.class);

                //Read Data From File
                int k=0;
                FileInputStream fis = null;
                String rec="";
                try {
                    fis = openFileInput(records);

                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder();
                    String text;
                    while ((text = br.readLine()) != null)
                    {
                        sb.append(text).append("\n");
                    }
                    rec=sb.toString();
                   // k =rec.length();




                    //tv.setText(sb.toString());
                } catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                } catch (IOException e)
                {
                    e.printStackTrace();
                } finally
                {
                    if (fis != null)
                    {
                        try
                        {
                            fis.close();
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }


                 if(Position != null ) {

                     //final int pos=Integer.parseInt(Position);
                     String CompanyName = edtCompanyName.getText().toString();
                     String ZipCode = edtZipCode.getText().toString();
                     String State = edtState.getText().toString();
                     String City = edtCity.getText().toString();
                     String PossibleBoxes = spBoxes.getSelectedItem().toString();
                     SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
                     String currentDateandTime = sdf.format(new Date());

                     String temp[]=rec.split(",");
                     int index=0;

                     ArrayList<Order> orders = new ArrayList<>();

                     for (int m = 0; m< temp.length / 10;  m++)
                     {
                         Order o = new Order();
                         o.pd = new PersonalData();
                         o.cd = new CompanyDetail();
                         o.pd.Fname = temp[m];
                         o.pd.Lname = temp[m + 1];
                         o.pd.Email = temp[m+2];
                         o.pd.Contact = temp[m+3];
                         o.cd.Company = temp[m+4];
                         o.cd.ZipCode = temp[m+5];
                         o.cd.State = temp[m+6];
                         o.cd.City = temp[m+7];
                         o.cd.Boxes = temp[m+8];
                         o.cd.DateAndTime = temp[m+9];

                         orders.add(o);
                     }

                     for (Order order: orders) {
                         if(order.pd.Email.equals(Email))
                             break;
                         index++;
                     }
                     Order order = new Order();
                     order.pd=new PersonalData();
                     order.cd=new CompanyDetail();
                     //update
                     order.pd.Fname = Fname;
                     order.pd.Lname = Lname;
                     order.pd.Email = Email;
                     order.pd.Contact = Contact;
                     order.cd.Company=CompanyName;
                     order.cd.ZipCode=ZipCode;
                     order.cd.State=State;
                     order.cd.City=City;
                     order.cd.Boxes=Boxes;
                     order.cd.DateAndTime=Time;


                     orders.set(index, order);

                    String str = "";

                     ArrayList<String> strList = new ArrayList<>();
                     for (Order o: orders) {
                         str += o.pd.Fname + ",";
                         str += o.pd.Lname + ",";
                         str += o.pd.Email + ",";
                         str += o.pd.Contact + ",";

                         str += o.cd.Company + ",";
                         str += o.cd.ZipCode + ",";
                         str += o.cd.State + ",";
                         str += o.cd.City + ",";
                         str += o.cd.Boxes + ",";
                         str += o.cd.DateAndTime + ",";
                     }


                     try
                     {

                         FileOutputStream fOut = openFileOutput(records, MODE_PRIVATE);
                         OutputStreamWriter osw = new OutputStreamWriter(fOut);
                         osw.write(str);
                         osw.flush();
                         osw.close();





                     }
                     catch (IOException e)
                     {
                         e.printStackTrace();
                     }

                     i.putExtra("Records",str);

                     startActivity(i);
                 }
                 else
                    i.putExtra("Records", rec);
               startActivity(i);

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
                if(PageThirdActivity.this.checkSelfPermission(Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED) {
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
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}

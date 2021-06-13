package com.example.bitf17a039_a1;


        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;
        import android.view.ActionMode;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AbsListView;
        import android.widget.AdapterView;
        import android.widget.ListView;
        import java.util.ArrayList;
        import android.widget.SearchView;
        import android.widget.Toast;

        import com.google.android.material.floatingactionbutton.FloatingActionButton;
        import com.google.android.material.snackbar.Snackbar;


public class ListScreenActivity extends AppCompatActivity implements
        ListView.OnItemClickListener,
        ListView.OnItemLongClickListener, SearchView.OnQueryTextListener   {
    SearchView sv;

    private ListView lvOrder;
    private ArrayList<Order> customer;
    private ListAdapter laCustomer;
    private ArrayList<Order> selectedCustomer;
    ListScreenActivity ref = this;
    String strArray[] = {};
    String WholeRecord="";
    int k;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_five);

        lvOrder = (ListView) findViewById(R.id.lvCustomer);

        customer = new ArrayList<Order>();
        selectedCustomer = new ArrayList<Order>();

        // Locate the SearchView in xmlFile

        sv = (SearchView) findViewById(R.id.search);
        sv.setOnQueryTextListener(this);
        laCustomer = new com.example.bitf17a039_a1.ListAdapter(this, customer, selectedCustomer);

        lvOrder.setAdapter(laCustomer);
        lvOrder.setOnItemClickListener(this);
        lvOrder.setOnItemLongClickListener(this);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "New Order", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent i = new Intent(ListScreenActivity.this, PageTwoActivity.class);

            }
        });



        //Recieved data from ThirdpageActivity
        Intent i = getIntent();
        final String RecordData = i.getStringExtra("Records");
        WholeRecord=RecordData;
        strArray = WholeRecord.split(",");


        int totalOrder = (strArray.length / 10);
        int count = 0;
        for (int k = 0; k < totalOrder; k++) {

            AddListItems(count, strArray);
            count = (count + 10);

        }


    }

    //SearchView


    @Override
    public boolean onQueryTextSubmit(String s) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        laCustomer.getFilter().filter(s);
        return false;
    }


    public void AddListItems(int c, String[] sd) {

        PersonalData pd = new PersonalData();
        pd.Fname = sd[c];
        pd.Lname = sd[c + 1];
        pd.Email = sd[c + 2];
        pd.Contact = sd[c + 3];
        CompanyDetail cd = new CompanyDetail();
        cd.Company = sd[c + 4];
        cd.ZipCode = sd[c + 5];
        cd.State = sd[c + 6];
        cd.City = sd[c + 7];
        cd.Boxes = sd[c + 8];
        cd.DateAndTime = sd[c + 9];
        Order o = new Order(pd, cd);
        customer.add(o);
        laCustomer.notifyDataSetChanged();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            String Fname = strArray[position];
            String Lname = strArray[position + 1];
            String Email = strArray[position + 2];
            String Contact = strArray[position + 3];
            String Company = strArray[position + 4];
            String ZipCode = strArray[position + 5];
            String State = strArray[position + 6];
            String City = strArray[position + 7];
            String Boxes = strArray[position + 8];
            String Time = strArray[position + 9];
            Intent i = new Intent(ListScreenActivity.this, OrderDetail.class);

            i.putExtra("FirstName", Fname);
            i.putExtra("LastName", Lname);
            i.putExtra("MailId", Email);
            i.putExtra("ContactNo", Contact);
            i.putExtra("Company", Company);
            i.putExtra("Zip Code", ZipCode);
            i.putExtra("State", State);
            i.putExtra("City", City);
            i.putExtra("Boxes", Boxes);
            i.putExtra("Time", Time);
            startActivity(i);
        }


        String Fname = strArray[(position * 10)];
        String Lname = strArray[(position * 10) + 1];
        String Email = strArray[(position * 10) + 2];
        String Contact = strArray[(position * 10) + 3];
        String Company = strArray[(position * 10) + 4];
        String ZipCode = strArray[(position * 10) + 5];
        String State = strArray[(position * 10) + 6];
        String City = strArray[(position * 10) + 7];
        String Boxes = strArray[(position * 10) + 8];
        String Time = strArray[(position * 10) + 9];

        Intent i = new Intent(ListScreenActivity.this, OrderDetail.class);

        i.putExtra("FirstName", Fname);
        i.putExtra("LastName", Lname);
        i.putExtra("MailId", Email);
        i.putExtra("ContactNo", Contact);
        i.putExtra("Company", Company);
        i.putExtra("Zip Code", ZipCode);
        i.putExtra("State", State);
        i.putExtra("City", City);
        i.putExtra("Boxes", Boxes);
        i.putExtra("Time", Time);
        startActivity(i);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id)
    {

        lvOrder.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        lvOrder.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener()
        {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu)
            {
                mode.getMenuInflater().inflate(R.menu.main_menu, menu);

                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return true;
            }

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                if (checked) {
                   // k=position*10;
                    selectedCustomer.add(customer.get(position));
                } else {
                    selectedCustomer.remove(customer.get(position));
                }

                laCustomer.notifyDataSetChanged();

                mode.setTitle(lvOrder.getCheckedItemCount() + " Selected");
            }

            @Override
            public boolean onActionItemClicked(final ActionMode mode, MenuItem item) {
                if (item.getItemId() == R.id.delete) {


                    AlertDialog.Builder simple = new AlertDialog.Builder(ref);
                    simple.setTitle("Are you sure to delete Order ??");
                    simple.setPositiveButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getBaseContext(), "So you did not wanna to delete Order", Toast.LENGTH_SHORT).show();

                        }
                    });
                    simple.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {

                            for (int i = 0; i < selectedCustomer.size(); i++)
                            {
                                customer.remove(selectedCustomer.get(i));
                            }

                            laCustomer.notifyDataSetChanged();
                            mode.finish();

                        }
                    });
                    simple.setCancelable(false);
                    simple.create();
                    simple.show();


                    return true;
                } else if (item.getItemId() == R.id.edit) {
                    int count = selectedCustomer.size();
                    if(count>1)
                    {
                        Toast.makeText(getBaseContext(), "Sorry to say you can't edit multiple Items at a time", Toast.LENGTH_LONG).show();
                    }
                   else if(count==1) {
                        Intent i = new Intent(ref, PageTwoActivity.class);
                        //int k= position*10;
                        // i.putExtra("SelectedOrder",selectedCustomer);
                        String pos="True";
                        i.putExtra("Position",pos);
                        i.putExtra("FirstName",selectedCustomer.get(0).pd.Fname);
                        i.putExtra("LastName", selectedCustomer.get(0).pd.Lname);
                        i.putExtra("MailId",selectedCustomer.get(0).pd.Email);
                        i.putExtra("ContactNo",selectedCustomer.get(0).pd.Contact);
                        i.putExtra("Company",selectedCustomer.get(0).cd.Company);
                        i.putExtra("Zip Code",selectedCustomer.get(0).cd.ZipCode);
                        i.putExtra("State",selectedCustomer.get(0).cd.State);
                        i.putExtra("City", selectedCustomer.get(0).cd.City);
                        i.putExtra("Boxes",selectedCustomer.get(0).cd.Boxes);
                        i.putExtra("Time", selectedCustomer.get(0).cd.DateAndTime);

                        startActivity(i);

                    }

                    return true;
                }

                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                int count = selectedCustomer.size();
                for (int i = 0; i < count; i++) {
                    selectedCustomer.remove(0);
                }

                laCustomer.notifyDataSetChanged();
            }
        });

        return true;
    }






}

/*


 */
//String delete[] = {};

                            /*String[] delete  = new String[selectedCustomer.size()];
                            for (int d = 0; d<selectedCustomer.size();d++) {
                                delete[d] = String.valueOf(selectedCustomer.get(d ));
                            }*/
//String[] delete = selectedCustomer.toArray(new String[selectedCustomer.size()]);
/*
    void deleteOrder(String s[]) {

        String M[]= setBulkOfOrder(s);
        String L[] =setBulkOfOrder(strArray);
        String J[]={};

        for(int k=0;k<L.length;k++)
        {
            J=DeleteOrderFromList(L,M[k]);
        }
        String m="";
        for(int j=0;j<J.length;j++)
        {
            m=m.concat(s[j]);

        }
        WholeRecord=m;
    }

    String []  DeleteOrderFromList(String s[],String del) {
        int count = 0;
        //String del="";
        int size = s.length;
        String L[]={};
        for (int i = 0; i < size; i++)
        {
            if (s[i]==del)
            {
                for (int j = i; j < (size - 1); j++)
                {
                    s[j] = s[j + 1];
                }
                count++;
                break;
            }
        }

        if(count>0)
        {

            for(int i=0; i<(size-1); i++)
            {
                L[i]=s[i];
            }

        }


        return L;
    }


    String [] setBulkOfOrder(String s [])
    {
        int size=(s.length/10);
        String  D[]={};
        String m="";
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<10;j++)
            {
                if(i==0 && j==0)
                {
                    m=m.concat(s[(i*10)+j]);
                }
                else
                    m=m.concat(s[(i*10)+j]).concat(",");

            }
            D[i]=m;

        }
        return D;
    }
    */
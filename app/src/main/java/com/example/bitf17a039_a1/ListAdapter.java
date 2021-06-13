package com.example.bitf17a039_a1;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.Filter;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.Locale;


public class ListAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<Order> customer;
    private ArrayList<Order> selectedCustomer;
    private ArrayList<Order> originalData;

    public ListAdapter(Context context, ArrayList<Order> customer, ArrayList<Order> selectedCustomer) {
        super(context, R.layout.list_item, customer);
        this.context = context;
        this.customer = customer;
        this.selectedCustomer = selectedCustomer;
        this.originalData=selectedCustomer;
    }

    @Override
    public int getCount() {
        return customer.size();
    }

    @Override
    public Object getItem(int i) {
        return customer.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View listItem = inflater.inflate(R.layout.list_item, null);

        Order o = customer.get(position);


        ((TextView) listItem.findViewById(R.id.tvFName)).setText(o.pd.Fname);
        ((TextView) listItem.findViewById(R.id.tvEmail)).setText(o.pd.Email);

        ((TextView) listItem.findViewById(R.id.tvTime)).setText(o.cd.DateAndTime);

        if (selectedCustomer.contains(o)) {
            listItem.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        } else {
            listItem.setBackgroundColor(context.getResources().getColor(android.R.color.white));
        }

        return listItem;
    }


    @Override
    public Filter getFilter() {
        return listFilter;
    }

    private Filter listFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence nameSubStr) {

            FilterResults results = new FilterResults();
            originalData.clear();

            for (int i = 0; i < customer.size(); i++)
                originalData.add(customer.get(i));

            if (nameSubStr != null && nameSubStr.length() > 0) {

                ArrayList<Order> filterList = new ArrayList<Order>();
                for (int i = 0; i < originalData.size(); i++) {

                    String fullname = originalData.get(i).pd.Fname.toUpperCase(); //SHAKEEL ZAFAR
                    nameSubStr = nameSubStr.toString().toUpperCase();            //AKEE

                    if ((fullname).contains(nameSubStr)) {
                        Order o = new Order();
                        o.pd = new PersonalData();
                        o.cd = new CompanyDetail();
                        o.pd.Fname = originalData.get(i).pd.Fname;
                        o.pd.Lname = originalData.get(i).pd.Lname;
                        o.pd.Email = originalData.get(i).pd.Email;
                        o.pd.Contact = originalData.get(i).pd.Contact;
                        o.cd.Company = originalData.get(i).cd.Company;
                        o.cd.ZipCode = originalData.get(i).cd.ZipCode;
                        o.cd.State = originalData.get(i).cd.State;
                        o.cd.City = originalData.get(i).cd.City;
                        o.cd.Boxes = originalData.get(i).cd.Boxes;
                        o.cd.DateAndTime = originalData.get(i).cd.DateAndTime;
                        //Order o = new Order(originalData.get(i));
                        filterList.add(o);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = originalData.size();
                results.values = originalData;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence nameSubStr, FilterResults results) {
            customer = (ArrayList<Order>) results.values;
            notifyDataSetChanged();
        }

    };
}

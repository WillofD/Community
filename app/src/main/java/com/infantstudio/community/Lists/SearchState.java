package com.infantstudio.community.Lists;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.infantstudio.community.Countrylist.FragmentCountryList;
import com.infantstudio.community.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchState extends AppCompatActivity {

    private ListView listView;
    private MyAppAdapter myAppAdapter;
    private ArrayList<SearchStatePojo> postArrayList;
    public String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_state);
        listView= (ListView) findViewById(R.id.listView);


        postArrayList=new ArrayList<>();
        postArrayList.add(new SearchStatePojo("AndhraPradesh"));
        postArrayList.add(new SearchStatePojo("ArunachalPradesh"));
        postArrayList.add(new SearchStatePojo("Assam"));
        postArrayList.add(new SearchStatePojo("Bihar"));
        postArrayList.add(new SearchStatePojo("Chhattisgarh"));
        postArrayList.add(new SearchStatePojo("Chandigarh"));
        postArrayList.add(new SearchStatePojo("DadraandNagarHaveli"));
        postArrayList.add(new SearchStatePojo("DamanandDiu"));
        postArrayList.add(new SearchStatePojo("Delhi"));
        postArrayList.add(new SearchStatePojo("Goa"));
        postArrayList.add(new SearchStatePojo("Gujarat"));
        postArrayList.add(new SearchStatePojo("Haryana"));
        postArrayList.add(new SearchStatePojo("HimachalPradesh"));
        postArrayList.add(new SearchStatePojo("JammuandKashmir"));
        postArrayList.add(new SearchStatePojo("Jharkhand"));
        postArrayList.add(new SearchStatePojo("Karnataka"));
        postArrayList.add(new SearchStatePojo("Kerala"));
        postArrayList.add(new SearchStatePojo("MadhyaPradesh"));
        postArrayList.add(new SearchStatePojo("Maharashtra"));
        postArrayList.add(new SearchStatePojo("Manipur"));
        postArrayList.add(new SearchStatePojo("Meghalaya"));
        postArrayList.add(new SearchStatePojo("Mizoram"));
        postArrayList.add(new SearchStatePojo("Nagaland"));
        postArrayList.add(new SearchStatePojo("Orissa"));
        postArrayList.add(new SearchStatePojo("Punjab"));
        postArrayList.add(new SearchStatePojo("Pondicherry"));
        postArrayList.add(new SearchStatePojo("Rajasthan"));
        postArrayList.add(new SearchStatePojo("TamilNadu"));
        postArrayList.add(new SearchStatePojo("Tripura"));
        postArrayList.add(new SearchStatePojo("UttarPradesh"));
        postArrayList.add(new SearchStatePojo("Uttarakhand"));
        postArrayList.add(new SearchStatePojo("WestBengal"));



        myAppAdapter=new MyAppAdapter(postArrayList,SearchState.this);
        listView.setAdapter(myAppAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                    Toast.makeText(SearchActivity.this, "This is my Toast message!"+position+"",
//                            Toast.LENGTH_LONG).show();
                    TextView chidtext = (TextView) view.findViewById(R.id.title);
                     value = chidtext.getText().toString();
                FragmentCountryList.StateLink(value);
                Intent openstatelist = new Intent(SearchState.this,FragmentCountryList.class);
//                opencountrylist.putExtra("StateValue",value);

                System.out.println("aneeeeeeeeeeeeeeeeee"+value);
                startActivity(openstatelist);


            }
        });





    }

    public class MyAppAdapter extends BaseAdapter {

        public class ViewHolder {
            TextView txtTitle,txtSubTitle;
        }

        public List<SearchStatePojo> parkingList;
        public Context context;
        ArrayList<SearchStatePojo> arraylist;

        private MyAppAdapter(List<SearchStatePojo> apps, Context context) {
            this.parkingList = apps;
            this.context = context;
            arraylist = new ArrayList<SearchStatePojo>();
            arraylist.addAll(parkingList);

        }

        @Override
        public int getCount() {
            return parkingList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View rowView = convertView;
            ViewHolder viewHolder;

            if (rowView == null) {
                LayoutInflater inflater = getLayoutInflater();
                rowView = inflater.inflate(R.layout.search_state_item, null);
                // configure view holder
                viewHolder = new ViewHolder();
                viewHolder.txtTitle = (TextView) rowView.findViewById(R.id.title);
//                viewHolder.txtSubTitle = (TextView) rowView.findViewById(R.id.subtitle);
                rowView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.txtTitle.setText(parkingList.get(position).getPostTitle() + "");
//            viewHolder.txtSubTitle.setText(parkingList.get(position).getPostSubTitle() + "");
            return rowView;
        }

        public void filter(String charText) {

            charText = charText.toLowerCase(Locale.getDefault());

            parkingList.clear();
            if (charText.length() == 0) {
                parkingList.addAll(arraylist);

            } else {
                for (SearchStatePojo postDetail : arraylist) {
                    if (charText.length() != 0 && postDetail.getPostTitle().toLowerCase(Locale.getDefault()).contains(charText)) {
                        parkingList.add(postDetail);
                    }

//                    else if (charText.length() != 0 && postDetail.getPostSubTitle().toLowerCase(Locale.getDefault()).contains(charText)) {
//                        parkingList.add(postDetail);
//                    }
                }
            }
            notifyDataSetChanged();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        //*** setOnQueryTextFocusChangeListener ***
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }
            @Override
            public boolean onQueryTextChange(String searchQuery) {
                myAppAdapter.filter(searchQuery.toString().trim());
                listView.invalidate();
                return true;
            }
        });

        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do something when collapsed
                return true;  // Return true to collapse action view
            }
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when expanded
                return true;  // Return true to expand action view
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}

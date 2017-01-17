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

public class SearchCountry extends AppCompatActivity {

    private ListView listView;
    private MyAppAdapter myAppAdapter;
    private ArrayList<SearchCountryPojo> postArrayList;
    public String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_country);
        listView= (ListView) findViewById(R.id.listView);


        postArrayList=new ArrayList<>();
        postArrayList.add(new SearchCountryPojo("Afghanistan"));
        postArrayList.add(new SearchCountryPojo("AlandIslands"));
        postArrayList.add(new SearchCountryPojo("Albania"));
        postArrayList.add(new SearchCountryPojo("Algeria"));
        postArrayList.add(new SearchCountryPojo("AmericanSamoa"));
        postArrayList.add(new SearchCountryPojo("Afghanistan"));
        postArrayList.add(new SearchCountryPojo("AndorrA"));
        postArrayList.add(new SearchCountryPojo("Angola"));
        postArrayList.add(new SearchCountryPojo("Anguilla"));
        postArrayList.add(new SearchCountryPojo("Antarctica"));
        postArrayList.add(new SearchCountryPojo("AntiguaandBarbuda"));
        postArrayList.add(new SearchCountryPojo("Argentina"));
        postArrayList.add(new SearchCountryPojo("Armenia"));
        postArrayList.add(new SearchCountryPojo("Aruba"));
        postArrayList.add(new SearchCountryPojo("Australia"));
        postArrayList.add(new SearchCountryPojo("Austria"));
        postArrayList.add(new SearchCountryPojo("Azerbaijan"));
        postArrayList.add(new SearchCountryPojo("Bahamas"));
        postArrayList.add(new SearchCountryPojo("Bahrain"));
        postArrayList.add(new SearchCountryPojo("Bangladesh"));
        postArrayList.add(new SearchCountryPojo("Barbados"));
        postArrayList.add(new SearchCountryPojo("Belarus"));
        postArrayList.add(new SearchCountryPojo("Belgium"));
        postArrayList.add(new SearchCountryPojo("Belize"));
        postArrayList.add(new SearchCountryPojo("Benin"));
        postArrayList.add(new SearchCountryPojo("Bermuda"));
        postArrayList.add(new SearchCountryPojo("Botswana"));
        postArrayList.add(new SearchCountryPojo("BosniaandHerzegovina"));
        postArrayList.add(new SearchCountryPojo("BouvetIsland"));
        postArrayList.add(new SearchCountryPojo("BritishIndianOceanTerritory"));
        postArrayList.add(new SearchCountryPojo("BruneiDarussalam"));
        postArrayList.add(new SearchCountryPojo("Bulgaria"));
        postArrayList.add(new SearchCountryPojo("BurkinaFaso"));
        postArrayList.add(new SearchCountryPojo("Burundi"));
        postArrayList.add(new SearchCountryPojo("Cambodia"));
        postArrayList.add(new SearchCountryPojo("Cameroon"));
        postArrayList.add(new SearchCountryPojo("Canada"));
        postArrayList.add(new SearchCountryPojo("CapeVerde"));
        postArrayList.add(new SearchCountryPojo("CaymanIslands"));
        postArrayList.add(new SearchCountryPojo("CentralAfricanRepublic"));
        postArrayList.add(new SearchCountryPojo("Chad"));
        postArrayList.add(new SearchCountryPojo("Chile"));
        postArrayList.add(new SearchCountryPojo("China"));
        postArrayList.add(new SearchCountryPojo("ChristmasIsland"));
        postArrayList.add(new SearchCountryPojo("Cocos(Keeling)Islands"));
        postArrayList.add(new SearchCountryPojo("Colombia"));
        postArrayList.add(new SearchCountryPojo("Comoros"));
        postArrayList.add(new SearchCountryPojo("Congo"));
        postArrayList.add(new SearchCountryPojo("Congo,TheDemocraticRepublicofthe"));
        postArrayList.add(new SearchCountryPojo("CookIslands"));
        postArrayList.add(new SearchCountryPojo("CostaRica"));
        postArrayList.add(new SearchCountryPojo("CoteD\"Ivoire"));
        postArrayList.add(new SearchCountryPojo("Croatia"));
        postArrayList.add(new SearchCountryPojo("Cuba"));
        postArrayList.add(new SearchCountryPojo("Cyprus"));
        postArrayList.add(new SearchCountryPojo("CzechRepubli"));
        postArrayList.add(new SearchCountryPojo("Denmark"));
        postArrayList.add(new SearchCountryPojo("Djibouti"));
        postArrayList.add(new SearchCountryPojo("Dominica"));
        postArrayList.add(new SearchCountryPojo("DominicanRepublic"));
        postArrayList.add(new SearchCountryPojo("Ecuador"));
        postArrayList.add(new SearchCountryPojo("Egypt"));
        postArrayList.add(new SearchCountryPojo("lSalvador"));
        postArrayList.add(new SearchCountryPojo("quatorialGuinea"));
        postArrayList.add(new SearchCountryPojo("Eritrea"));
        postArrayList.add(new SearchCountryPojo("Estonia"));
        postArrayList.add(new SearchCountryPojo("Ethiopia"));
        postArrayList.add(new SearchCountryPojo("FalklandIslands(Malvinas)"));
        postArrayList.add(new SearchCountryPojo("FaroeIslands"));
        postArrayList.add(new SearchCountryPojo("Fiji"));
        postArrayList.add(new SearchCountryPojo("Finland"));
        postArrayList.add(new SearchCountryPojo("France"));
        postArrayList.add(new SearchCountryPojo("FrenchGuiana"));
        postArrayList.add(new SearchCountryPojo("FrenchPolynesia"));
        postArrayList.add(new SearchCountryPojo("FrenchSouthernTerritories"));
        postArrayList.add(new SearchCountryPojo("Gabon"));
        postArrayList.add(new SearchCountryPojo("Gambia"));
        postArrayList.add(new SearchCountryPojo("Georgia"));
        postArrayList.add(new SearchCountryPojo("Germany"));
        postArrayList.add(new SearchCountryPojo("Ghana"));
        postArrayList.add(new SearchCountryPojo("Gibraltar"));
        postArrayList.add(new SearchCountryPojo("Greece"));
        postArrayList.add(new SearchCountryPojo("Greenland"));
        postArrayList.add(new SearchCountryPojo("Grenada"));
        postArrayList.add(new SearchCountryPojo("Guadeloupe"));
        postArrayList.add(new SearchCountryPojo("Guam"));
        postArrayList.add(new SearchCountryPojo("Guatemala"));
        postArrayList.add(new SearchCountryPojo("Guernsey"));
        postArrayList.add(new SearchCountryPojo("Guinea"));
        postArrayList.add(new SearchCountryPojo("Guinea-Bissau"));
        postArrayList.add(new SearchCountryPojo("Guyana"));
        postArrayList.add(new SearchCountryPojo("Haiti"));
        postArrayList.add(new SearchCountryPojo("HeardIslandandMcdonaldIslands"));
        postArrayList.add(new SearchCountryPojo("HolySee(VaticanCityState)"));
        postArrayList.add(new SearchCountryPojo("Honduras"));
        postArrayList.add(new SearchCountryPojo("HongKong"));
        postArrayList.add(new SearchCountryPojo("Hungary"));
        postArrayList.add(new SearchCountryPojo("Iceland"));
        postArrayList.add(new SearchCountryPojo("India"));
        postArrayList.add(new SearchCountryPojo("Indonesia"));
        postArrayList.add(new SearchCountryPojo("Iran,IslamicRepublicOf"));
        postArrayList.add(new SearchCountryPojo("Iraq"));
        postArrayList.add(new SearchCountryPojo("Ireland"));
        postArrayList.add(new SearchCountryPojo("IsleofMan"));
        postArrayList.add(new SearchCountryPojo("Israel"));
        postArrayList.add(new SearchCountryPojo("Italy"));
        postArrayList.add(new SearchCountryPojo("Jamaica"));
        postArrayList.add(new SearchCountryPojo("Japan"));
        postArrayList.add(new SearchCountryPojo("Jersey"));
        postArrayList.add(new SearchCountryPojo("Jordan"));
        postArrayList.add(new SearchCountryPojo("Kazakhstan"));
        postArrayList.add(new SearchCountryPojo("Kenya"));
        postArrayList.add(new SearchCountryPojo("Kiribati"));
        postArrayList.add(new SearchCountryPojo("Korea,DemocraticPeopleSRepublicof"));
        postArrayList.add(new SearchCountryPojo("Korea,Republicof"));
        postArrayList.add(new SearchCountryPojo("Kuwait"));
        postArrayList.add(new SearchCountryPojo("LaoPeopleSDemocraticRepublic"));
        postArrayList.add(new SearchCountryPojo("Latvia"));
        postArrayList.add(new SearchCountryPojo("Lebanon"));
        postArrayList.add(new SearchCountryPojo("Lesotho"));
        postArrayList.add(new SearchCountryPojo("Liberia"));
        postArrayList.add(new SearchCountryPojo("LibyanArabJamahiriya"));
        postArrayList.add(new SearchCountryPojo("Liechtenstein"));
        postArrayList.add(new SearchCountryPojo("Lithuania"));
        postArrayList.add(new SearchCountryPojo("Luxembourg"));
        postArrayList.add(new SearchCountryPojo("Macao"));
        postArrayList.add(new SearchCountryPojo("Macedonia,TheFormerYugoslavRepublicof"));
        postArrayList.add(new SearchCountryPojo("Madagascar"));
        postArrayList.add(new SearchCountryPojo("Malawi"));
        postArrayList.add(new SearchCountryPojo("Malaysia"));
        postArrayList.add(new SearchCountryPojo("Maldives"));
        postArrayList.add(new SearchCountryPojo("Mali"));
        postArrayList.add(new SearchCountryPojo("Malta"));
        postArrayList.add(new SearchCountryPojo("MarshallIslands"));
        postArrayList.add(new SearchCountryPojo("Martinique"));
        postArrayList.add(new SearchCountryPojo("Mauritania"));
        postArrayList.add(new SearchCountryPojo("Mauritius"));
        postArrayList.add(new SearchCountryPojo("Mayotte"));
        postArrayList.add(new SearchCountryPojo("Mexico"));
        postArrayList.add(new SearchCountryPojo("Micronesia,FederatedStatesof"));
        postArrayList.add(new SearchCountryPojo("Moldova,Republicof"));
        postArrayList.add(new SearchCountryPojo("Monaco"));
        postArrayList.add(new SearchCountryPojo("Mongolia"));
        postArrayList.add(new SearchCountryPojo("Montserrat"));
        postArrayList.add(new SearchCountryPojo("Morocco"));
        postArrayList.add(new SearchCountryPojo("Mozambique"));
        postArrayList.add(new SearchCountryPojo("Myanmar"));
        postArrayList.add(new SearchCountryPojo("Namibia"));
        postArrayList.add(new SearchCountryPojo("Nauru"));
        postArrayList.add(new SearchCountryPojo("Nepal"));
        postArrayList.add(new SearchCountryPojo("Netherlands"));
        postArrayList.add(new SearchCountryPojo("NetherlandsAntilles"));
        postArrayList.add(new SearchCountryPojo("NewCaledonia"));
        postArrayList.add(new SearchCountryPojo("NewZealand"));
        postArrayList.add(new SearchCountryPojo("Nicaragua"));
        postArrayList.add(new SearchCountryPojo("Niger"));
        postArrayList.add(new SearchCountryPojo("Nigeria"));
        postArrayList.add(new SearchCountryPojo("Niue"));
        postArrayList.add(new SearchCountryPojo("NorfolkIsland"));
        postArrayList.add(new SearchCountryPojo("NorthernMarianaIslands"));
        postArrayList.add(new SearchCountryPojo("Norway"));
        postArrayList.add(new SearchCountryPojo("Oman"));
        postArrayList.add(new SearchCountryPojo("Pakistan"));
        postArrayList.add(new SearchCountryPojo("Palau"));
        postArrayList.add(new SearchCountryPojo("PalestinianTerritory,Occupied"));
        postArrayList.add(new SearchCountryPojo("Panama"));
        postArrayList.add(new SearchCountryPojo("PapuaNewGuinea"));
        postArrayList.add(new SearchCountryPojo("Paraguay"));
        postArrayList.add(new SearchCountryPojo("Peru"));
        postArrayList.add(new SearchCountryPojo("Philippines"));
        postArrayList.add(new SearchCountryPojo("Pitcairn"));
        postArrayList.add(new SearchCountryPojo("Poland"));
        postArrayList.add(new SearchCountryPojo("Portugal"));
        postArrayList.add(new SearchCountryPojo("PuertoRico"));
        postArrayList.add(new SearchCountryPojo("PuertoRico"));
        postArrayList.add(new SearchCountryPojo("Reunion"));
        postArrayList.add(new SearchCountryPojo("Romania"));
        postArrayList.add(new SearchCountryPojo("RWANDA"));
        postArrayList.add(new SearchCountryPojo("RussianFederation"));
        postArrayList.add(new SearchCountryPojo("SaintHelena"));
        postArrayList.add(new SearchCountryPojo("SaintKittsandNevis"));
        postArrayList.add(new SearchCountryPojo("SaintLucia"));
        postArrayList.add(new SearchCountryPojo("SaintPierreandMiquelon"));
        postArrayList.add(new SearchCountryPojo("SaintVincentandtheGrenadines"));
        postArrayList.add(new SearchCountryPojo("Samoa"));
        postArrayList.add(new SearchCountryPojo("SanMarino"));
        postArrayList.add(new SearchCountryPojo("SaoTomeandPrincipe"));
        postArrayList.add(new SearchCountryPojo("SaudiArabia"));
        postArrayList.add(new SearchCountryPojo("Senegal"));
        postArrayList.add(new SearchCountryPojo("SerbiaandMontenegro"));
        postArrayList.add(new SearchCountryPojo("Seychelles"));
        postArrayList.add(new SearchCountryPojo("SierraLeone"));
        postArrayList.add(new SearchCountryPojo("Singapore"));
        postArrayList.add(new SearchCountryPojo("Slovakia"));
        postArrayList.add(new SearchCountryPojo("Slovenia"));
        postArrayList.add(new SearchCountryPojo("SolomonIsland"));
        postArrayList.add(new SearchCountryPojo("Somalia"));
        postArrayList.add(new SearchCountryPojo("SouthAfrica"));
        postArrayList.add(new SearchCountryPojo("SouthGeorgiaandtheSouthSandwichIslands"));
        postArrayList.add(new SearchCountryPojo("Spain"));
        postArrayList.add(new SearchCountryPojo("SriLanka"));
        postArrayList.add(new SearchCountryPojo("Sudan"));
        postArrayList.add(new SearchCountryPojo("Suriname"));
        postArrayList.add(new SearchCountryPojo("SvalbardandJanMayen"));
        postArrayList.add(new SearchCountryPojo("Swaziland"));
        postArrayList.add(new SearchCountryPojo("Sweden"));
        postArrayList.add(new SearchCountryPojo("Switzerland"));
        postArrayList.add(new SearchCountryPojo("SyrianArabRepublic"));
        postArrayList.add(new SearchCountryPojo("aiwan,ProvinceofChina"));
        postArrayList.add(new SearchCountryPojo("Tajikistan"));
        postArrayList.add(new SearchCountryPojo("Tanzania,UnitedRepublicof"));
        postArrayList.add(new SearchCountryPojo("Thailand"));
        postArrayList.add(new SearchCountryPojo("Timor-Leste"));
        postArrayList.add(new SearchCountryPojo("Togo"));
        postArrayList.add(new SearchCountryPojo("Tokelau"));
        postArrayList.add(new SearchCountryPojo("Tonga"));
        postArrayList.add(new SearchCountryPojo("TrinidadandTobago"));
        postArrayList.add(new SearchCountryPojo("Tunisia"));
        postArrayList.add(new SearchCountryPojo("Turkey"));
        postArrayList.add(new SearchCountryPojo("Turkmenistan"));
        postArrayList.add(new SearchCountryPojo("TurksandCaicosIslands"));
        postArrayList.add(new SearchCountryPojo("Tuvalu"));
        postArrayList.add(new SearchCountryPojo("Uganda"));
        postArrayList.add(new SearchCountryPojo("Ukraine"));
        postArrayList.add(new SearchCountryPojo("UnitedArabEmirates"));
        postArrayList.add(new SearchCountryPojo("UnitedKingdom"));
        postArrayList.add(new SearchCountryPojo("UnitedStates"));
        postArrayList.add(new SearchCountryPojo("UnitedStatesMinorOutlyingIslands"));
        postArrayList.add(new SearchCountryPojo("Uruguay"));
        postArrayList.add(new SearchCountryPojo("Uzbekistan"));
        postArrayList.add(new SearchCountryPojo("Vanuatu"));
        postArrayList.add(new SearchCountryPojo("Venezuela"));
        postArrayList.add(new SearchCountryPojo("VietNam"));
        postArrayList.add(new SearchCountryPojo("VirginIslands,British"));
        postArrayList.add(new SearchCountryPojo("VirginIslands,U.S."));
        postArrayList.add(new SearchCountryPojo("WallisandFutuna"));
        postArrayList.add(new SearchCountryPojo("WesternSahara"));
        postArrayList.add(new SearchCountryPojo("Yemen"));
        postArrayList.add(new SearchCountryPojo("Zambia"));
        postArrayList.add(new SearchCountryPojo("Zimbabwe"));



        myAppAdapter=new MyAppAdapter(postArrayList,SearchCountry.this);
        listView.setAdapter(myAppAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                    Toast.makeText(SearchActivity.this, "This is my Toast message!"+position+"",
//                            Toast.LENGTH_LONG).show();
                    TextView chidtext = (TextView) view.findViewById(R.id.title);
                     value = chidtext.getText().toString();
                FragmentCountryList.CountryLink(value);
                Intent opencountrylist = new Intent(SearchCountry.this,FragmentCountryList.class);
//                opencountrylist.putExtra("CountryValue",value);
                startActivity(opencountrylist);




            }
        });





    }

    public class MyAppAdapter extends BaseAdapter {

        public class ViewHolder {
            TextView txtTitle,txtSubTitle;
        }

        public List<SearchCountryPojo> parkingList;
        public Context context;
        ArrayList<SearchCountryPojo> arraylist;

        private MyAppAdapter(List<SearchCountryPojo> apps, Context context) {
            this.parkingList = apps;
            this.context = context;
            arraylist = new ArrayList<SearchCountryPojo>();
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
                rowView = inflater.inflate(R.layout.search_country_item, null);
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
                for (SearchCountryPojo postDetail : arraylist) {
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

package com.infantstudio.community;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class DisplayUser extends AppCompatActivity {


    private TextView nametxt,lastnametxt,addrestxt,communitytxt,professiontxt,citytxt,statetxt,countrytxt;

    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_user);
         // in this text view i will display the text



        String txtid = getIntent().getStringExtra("txtpersonid");

        loading = ProgressDialog.show(this,"Please wait...","Fetching...",false,false);

        nametxt = (TextView) findViewById(R.id.person_name_id);
        lastnametxt = (TextView) findViewById(R.id.person_lastname_id);
        addrestxt = (TextView) findViewById(R.id.person_adress_id);
        communitytxt = (TextView) findViewById(R.id.person_community_id);
        professiontxt = (TextView)findViewById(R.id.person_profesion_id);
        citytxt = (TextView)findViewById(R.id.person_city_id);
        statetxt = (TextView)findViewById(R.id.person_state_id);
        countrytxt = (TextView)findViewById(R.id.person_country_id);





        String url = statics_demo.USER_URL+txtid;// this is fixed url where i am getting the data
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DisplayUser.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
    JSONObject result;
    private void showJSON(String response){
        String info="";
        try {
            JSONObject jsonObject = new JSONObject(response);

            JSONObject resopnseObject = jsonObject.getJSONObject("responseMsg");
            String name = resopnseObject.getString("name");
            String lastname = resopnseObject.getString("last_name");
            String address = resopnseObject.getString("address");
            String community = resopnseObject.getString("community_name");
            String profestion = resopnseObject.getString("profession");
            String city = resopnseObject.getString("city");
            String State = resopnseObject.getString("state");
            String country = resopnseObject.getString("country");
           String imageex = resopnseObject.getString("image");

            System.out.println("BASE644444444444"+imageex);


            nametxt.setText("Name: "+name);
            lastnametxt.setText("lastname: "+lastname);
            addrestxt.setText("Address: "+address);
            communitytxt.setText("Community: "+community);
            professiontxt.setText("Profestion: "+profestion);
            citytxt.setText("City: "+city);
            statetxt.setText("State: "+State);
            countrytxt.setText("Country: "+country);


//            System.out.println("hasssssssssssssssss"+name);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}

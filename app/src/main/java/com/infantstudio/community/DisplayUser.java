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

public class DisplayUser extends AppCompatActivity {

    private TextView textViewResult;

    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_user);
        textViewResult = (TextView) findViewById(R.id.check_data_id); // in this text view i will display the text

        loading = ProgressDialog.show(this,"Please wait...","Fetching...",false,false);


        String url = statics_demo.USER_URL+"4";// this is fixed url where i am getting the data
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
             info = jsonObject.getString(statics_demo.RESPONSE_INFO);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        textViewResult.setText("Name:\t"+info);
    }

}

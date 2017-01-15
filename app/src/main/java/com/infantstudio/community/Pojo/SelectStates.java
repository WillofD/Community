package com.infantstudio.community.Pojo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.infantstudio.community.R;

public class SelectStates extends AppCompatActivity {
    EditText inputSearch;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_states);
        inputSearch = (EditText) findViewById(R.id.editText2);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String SelectState = bundle.getString("CountrySelected");

        Toast.makeText(SelectStates.this, SelectState, Toast.LENGTH_LONG).show();


        final ListView lv;
        lv = (ListView) findViewById(R.id.listview2);

        if (SelectState.equals("India")) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.india));
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String StateSelected = (String) lv.getItemAtPosition(position);
                    //  Toast.makeText(SearchCountry.this,countrySelected,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SelectStates.this, SelectMembers.class);
                    intent.putExtra("StateSelected", StateSelected);
                    startActivity(intent);
                    intent.putExtra("Id", id);
                }
            });


            inputSearch.addTextChangedListener(new TextWatcher() {      ///Search Engine
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    SelectStates.this.adapter.getFilter().filter(s);
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    SelectStates.this.adapter.getFilter().filter(s);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
    }
}

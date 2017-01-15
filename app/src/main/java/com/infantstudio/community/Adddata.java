package com.infantstudio.community;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by user on 8/1/17.
 */

public class Adddata extends AppCompatActivity {
    EditText fname,lname,address,community_name,profession,city,state,country;
    public TextView result;
    Button submit;
    String f,l,a,c,p,ci,s,co,encodedImage;
    public static final int PICK_IMAGE = 100;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adddata);
        fname = (EditText) findViewById(R.id.firstname);
        lname = (EditText) findViewById(R.id.lastname);
        address = (EditText) findViewById(R.id.address);
        community_name = (EditText) findViewById(R.id.community_name);
        profession = (EditText) findViewById(R.id.profession);
        city = (EditText) findViewById(R.id.city);
        state = (EditText) findViewById(R.id.state);
        country = (EditText) findViewById(R.id.country);
        result = (TextView) findViewById(R.id.result);
        submit = (Button) findViewById(R.id.submit);
        Button btn = (Button) findViewById(R.id.btn_upload);






        if (btn != null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE);
                }
            });
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f=fname.getText().toString();
                l=lname.getText().toString();
                a=address.getText().toString();
                c=community_name.getText().toString();
                p=profession.getText().toString();
                ci=city.getText().toString();
                s=state.getText().toString();
                co=country.getText().toString();
                new JSONTask().execute("http://52.89.46.93/communityApp/?methodName=add.person&name="+f+"&last_name="+l+"&address="+a+"&community_name="+c+"&profession="+p+"&city="+ci+"&state="+s+"&country="+co+"&member_in_house=&image="+encodedImage);
            }
        });



    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {

            android.net.Uri selectedImage = data.getData();
             try {


                 Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);

                 ImageView imageView = (ImageView) findViewById(R.id.imageView);
                 imageView.setImageBitmap(bitmap);


                 ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
                 byte[] b = baos.toByteArray();

                  encodedImage = Base64.encodeToString(b, Base64.DEFAULT);

                 System.out.println("the enocoded text is:"+encodedImage);

             }catch(IOException e) {
                 e.printStackTrace();
            }
        }
    }


    public class JSONTask extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... urls) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(urls[0]);
                connection = (HttpURLConnection) url.openConnection();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line= "";
                while ((line=reader.readLine())!=null){
                    buffer.append(line);


                    return buffer.toString();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                if(connection!=null)
                    connection.disconnect();
                try {
                    if(reader!=null)
                        reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(fname.getText().toString().trim().equals("")){
                fname.setText("Field mandatory!");
            }
            else if(lname.getText().toString().trim().equals("")){
                lname.setText("Field mandatory!");

            }
            else if(address.getText().toString().trim().equals("")){
                address.setText("Field mandatory!");

            }
            else if(lname.getText().toString().trim().equals("")){
                lname.setText("Field mandatory!");

            }
            else {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Adddata.this);

                final TextView et = new TextView(Adddata.this);
                et.setTextSize(30);
                et.setText("Thank You! Your details have been saved.");


                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(et);

                // set dialog message
                alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();
            }

        }
    }
}

package com.infantstudio.community.Fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.infantstudio.community.*;
import com.infantstudio.community.Lists.SearchCountry;

/**
 * Created by user on 26/12/16.
 */

public class DetailsFragment extends Fragment{
    TextView what;
    LinearLayout l;
    Button b,searchState,cloaseCountryBtn;
    TextView display;
    private PopupWindow pwindocountry;




    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.activity_search, container, false);
        b=(Button) rootView.findViewById(R.id.bbbb);



        l = (LinearLayout) rootView.findViewById(R.id.ll);
        l.setVisibility(View.VISIBLE);

        searchState = (Button)rootView.findViewById(R.id.searchbystate_id);

        searchState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 final Intent opencountryselect = new Intent(getActivity(), SearchCountry.class);
                startActivity(opencountryselect);



            }
        });




       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i= new Intent("android.intent.action.ADDDATA");
               startActivity(i);
           }
       });



        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        l.setVisibility(View.VISIBLE);
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        l.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroyView() {
        l.setVisibility(View.VISIBLE);
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        l.setVisibility(View.VISIBLE);

        super.onDetach();
    }

//    private View.OnClickListener cancel_button_click_listener = newlogo View.OnClickListener() {
//        public void onClick(View v) {
//            pwindocountry.dismiss();
//
//        }
//    };
//
//    public class OnSpinnerItemClicked implements AdapterView.OnItemSelectedListener {
//
//        @Override
//        public void onItemSelected(AdapterView<?> parent,
//                                   View view, int pos, long id) {
//            Toast.makeText(parent.getContext(), "Clicked : " +
//                    parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
//
//
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView parent) {
//            // Do nothing.
//        }
//    }
}

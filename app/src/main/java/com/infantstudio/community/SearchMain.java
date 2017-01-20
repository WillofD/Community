package com.infantstudio.community;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.infantstudio.community.Countrylist.FragmentCountryList;
import com.infantstudio.community.Lists.SearchCity;
import com.infantstudio.community.Lists.SearchCommunity;
import com.infantstudio.community.Lists.SearchCountry;
import com.infantstudio.community.Lists.SearchProfestion;
import com.infantstudio.community.Lists.SearchState;

public class SearchMain extends Fragment implements View.OnClickListener {
    ImageButton logo1,logo2,logo3,logo4,logo5,logo6;

    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.activity_search_main_content, container, false);


        logo1 = (ImageButton) rootView.findViewById(R.id.logo1);
        logo2 = (ImageButton) rootView.findViewById(R.id.logo2);
        logo3 = (ImageButton) rootView.findViewById(R.id.logo3);
        logo4 = (ImageButton) rootView.findViewById(R.id.logo4);
        logo5 = (ImageButton) rootView.findViewById(R.id.logo5);
        logo6 = (ImageButton) rootView.findViewById(R.id.logo6);


        logo1.setOnClickListener(this);
        logo2.setOnClickListener(this);
        logo3.setOnClickListener(this);
        logo4.setOnClickListener(this);
        logo5.setOnClickListener(this);
        logo6.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.logo1:        //"Block SMSs" button pressed
                startActivity(new Intent(getActivity(),SearchCountry.class));

                break;
            case R.id.logo2:

                startActivity(new Intent(getActivity(),SearchState.class));
                break;
            case R.id.logo3:

                startActivity(new Intent(getActivity(),SearchCity.class));
                break;
            case R.id.logo4:

                startActivity(new Intent(getActivity(),SearchCommunity.class));
                break;
            case R.id.logo5:

                startActivity(new Intent(getActivity(),SearchProfestion.class));
                break;
            case R.id.logo6:
                startActivity(new Intent(getActivity(),FragmentCountryList.class));

              //  startActivity(newlogo Intent(getActivity(),Adddata.class));
                break;
        }
    }
}

package com.infantstudio.community;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by diva on 11/16/2016.
 */

public class spinnerAdapterCity extends ArrayAdapter<String> {

    public spinnerAdapterCity(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        // TODO Auto-generated constructor stub

    }

    @Override
    public int getCount() {

        // TODO Auto-generated method stub
        int count = super.getCount();

        return count>0 ? count-1 : count ;


    }


}

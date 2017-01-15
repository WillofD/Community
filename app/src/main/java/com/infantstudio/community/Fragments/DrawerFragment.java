package com.infantstudio.community.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.infantstudio.community.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrawerFragment extends Fragment implements View.OnClickListener {

    static DrawerLayout drawerLayout;
    private TextView textView, textView1, textView2 ,adddata;
    ViewPager viewPager;

    public static DrawerFragment newInstance(DrawerLayout drawer) {
        // Required empty public constructor
        drawerLayout = drawer;
        DrawerFragment f = new DrawerFragment();
        return f;


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.drawyer_laout_items, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = (ViewPager) getActivity().findViewById(R.id.viewPager);


        initialise(view);
        Animation animation1 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_left);


        view.findViewById(R.id.textView2).startAnimation(animation1);
        view.findViewById(R.id.textView3).startAnimation(animation1);
        view.findViewById(R.id.textView4).startAnimation(animation1);
        view.findViewById(R.id.adddata).startAnimation(animation1);




    }

    private void callback(View view, int position) {
        Intent intent;
        drawerLayout.closeDrawer(Gravity.LEFT);

    }

    private void initialise(View view) {
//        view.findViewById(R.id.textView).setOnClickListener(this);


        textView = (TextView) view.findViewById(R.id.textView2);
        textView1 = (TextView) view.findViewById(R.id.textView3);
        textView2 = (TextView) view.findViewById(R.id.textView4);
        adddata = (TextView) view.findViewById(R.id.adddata);




        textView.setText("News");
            textView1.setText("Members");
            textView2.setText("About");
            adddata.setText("Sign up");





        view.findViewById(R.id.textView2).setOnClickListener(this);
        view.findViewById(R.id.textView3).setOnClickListener(this);
        view.findViewById(R.id.textView4).setOnClickListener(this);
        view.findViewById(R.id.adddata).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        drawerLayout.closeDrawers();
        switch (v.getId()) {

            case R.id.textView2:
                viewPager.setCurrentItem(0);


                break;
            case R.id.textView3:
                viewPager.setCurrentItem(1);

                break;
            case R.id.textView4:
                viewPager.setCurrentItem(2);
                break;

            case R.id.adddata:
                Intent i = new Intent("android.intent.action.ADDDATA");
                startActivity(i);
                break;

        }

    }


}

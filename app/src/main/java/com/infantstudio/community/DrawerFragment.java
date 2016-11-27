package com.infantstudio.community;


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




/**
 * A simple {@link Fragment} subclass.
 */
public class DrawerFragment extends Fragment implements View.OnClickListener {

    static DrawerLayout drawerLayout;
    private TextView textView, textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8;
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
        view.findViewById(R.id.textView5).startAnimation(animation1);
        view.findViewById(R.id.textView6).startAnimation(animation1);
        view.findViewById(R.id.textView7).startAnimation(animation1);


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
        textView3 = (TextView) view.findViewById(R.id.textView5);
        textView4 = (TextView) view.findViewById(R.id.textView6);
        textView5 = (TextView) view.findViewById(R.id.textView7);
        textView6 = (TextView) view.findViewById(R.id.churchname);


            textView.setText("Feeds");
            textView1.setText("Church News");
            textView2.setText("Church Group");
            textView3.setText("Daily Read");
            textView4.setText("Charity");
            textView5.setText("About");
            textView6.setText("Chickkamana Halli Church");





        view.findViewById(R.id.textView2).setOnClickListener(this);
        view.findViewById(R.id.textView3).setOnClickListener(this);
        view.findViewById(R.id.textView4).setOnClickListener(this);
        view.findViewById(R.id.textView5).setOnClickListener(this);
        view.findViewById(R.id.textView6).setOnClickListener(this);
        view.findViewById(R.id.textView7).setOnClickListener(this);

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
            case R.id.textView5:
                viewPager.setCurrentItem(3);
                break;
            case R.id.textView6:
                viewPager.setCurrentItem(4);
                break;
            case R.id.textView7:
                viewPager.setCurrentItem(5);
                break;

        }

    }


}

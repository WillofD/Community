package com.infantstudio.community.Adapaters;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.infantstudio.community.DisplayContent;
import com.infantstudio.community.Fragments.AboutFragment;
import com.infantstudio.community.Fragments.Fragment_Church_News;
import com.infantstudio.community.Fragments.ItemFragment;
import com.infantstudio.community.Fragments.TestFragment;
import com.infantstudio.community.R;

import com.infantstudio.community.SearchMain;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    Activity context;
    private int[] imageResId = {
            R.drawable.hum1,
            R.drawable.hum1,
            R.drawable.hum1,
            R.drawable.hum1,
            R.drawable.hum1,


    };
    private String tabTitles[] = new String[] { "News", "Members","About",};





    public ViewPagerAdapter(FragmentManager fm, Activity context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        ListFragment lf = null;
        switch (position) {


            case 0:
                fragment = new Fragment_Church_News();
                break;
            case 1:
                    fragment = new SearchMain();//FragmentSearchMain

                break;
            case 2:
                fragment = new AboutFragment();
                break;
            case 3:
                fragment = new DisplayContent();
                break;
            case 4:
                fragment = new ItemFragment();

                break;
            case 5:
                fragment = new DisplayContent();
                break;




        }

       return fragment;

    }
    android.app.ListFragment list(){
           android.app.ListFragment lf = new TestFragment();
        return lf;
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;


        Drawable image = ContextCompat.getDrawable(context, imageResId[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        SpannableString sb = new SpannableString("          " + tabTitles[position]+"       ");
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


return sb;
//        switch (position) {
//
//            case 0:
//
//                title ="        "+ "News";
//
//
//                break;
//            case 1:
//
//
//                    title = "Members";
//
//                break;
//            case 2:
//
//                    title = "About";
//
//          break;
//
//            default:
//                break;
//
//        }
//
//        return title;

    }

}

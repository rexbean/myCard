package com.example.zihaoli.mycard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by zihaoli on 18/1/3.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<MyFragment> fragmentList;

    public MyFragmentAdapter(FragmentManager fm, ArrayList<MyFragment> fragmentList) {
        super(fm);
        // TODO Auto-generated constructor stub
        this.fragmentList=fragmentList;
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return fragmentList.get(arg0);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return fragmentList.size();
    }

}

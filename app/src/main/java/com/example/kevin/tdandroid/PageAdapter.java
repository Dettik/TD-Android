package com.example.kevin.tdandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter{

    private String[] titres = {"Choix", "Vue"};
    private fragment1 fragment1;
    private fragment2 fragment2;

    public PageAdapter(FragmentManager fm) {
        super(fm);
        fragment1=new fragment1();
        fragment2=new fragment2();
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0:
                return fragment1;
            case 1:
                return fragment2;
        }
        return null;
    }

    @Override
    public int getCount() {
        return titres.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titres[position];
    }
}

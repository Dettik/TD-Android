package com.example.kevin.tdandroid;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.astuetz.PagerSlidingTabStrip;


public class MainActivity extends FragmentActivity implements fragment1.DataTransmit {

    private PageAdapter pageAdapter;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageAdapter = new PageAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(pageAdapter);

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setShouldExpand(true);
        tabs.setViewPager(viewPager);

    }

    @Override
    public void transmit(String data) {
        fragment2 fragment2=(fragment2) pageAdapter.getItem(1);
        fragment2.changeData(data);
    }


    private class TabListener<T extends Fragment> implements ActionBar.TabListener {

        private Fragment mFragment;
        private final FragmentActivity mActivity;
        private final String mTag;
        private final Class<T> mClass;

        public TabListener(FragmentActivity activity, String tag, Class<T> clz) {
            mActivity = activity;
            mTag = tag;
            mClass = clz;
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            // TODO Auto-generated method stub
            if(mFragment == null)
            {
                mFragment = Fragment.instantiate(mActivity, mClass.getName());
                ft.add(android.R.id.content, mFragment, mTag);
            } else {
                ft.attach(mFragment);
            }
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            // TODO Auto-generated method stub
            if(mFragment != null)
            {
                ft.detach(mFragment);
            }
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    }
}

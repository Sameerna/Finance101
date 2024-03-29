package com.example.finance101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);

    }
    private class SectionsPagerAdapter extends FragmentPagerAdapter{
        public  SectionsPagerAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public int getCount(){
            return 4;
        }
        @Override
        public Fragment getItem(int position){
            switch (position){
                case 0:
                    return new TopFragment();
                case 1 :
                    return new BasicsFragment();
                case 2:
                    return new InvestmentsFragment();
                case 3:
                    return new LoanFragment();
            }
        return null;
        }
        @Override
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return getResources().getText(R.string.home_tab);
                case 1:
                    return getResources().getText(R.string.basics_tab);
                case 2:
                    return getResources().getText(R.string.Investments_tab);
                case 3:
                    return getResources().getText(R.string.loans_tab);
            }
            return null;
        }
    }
}

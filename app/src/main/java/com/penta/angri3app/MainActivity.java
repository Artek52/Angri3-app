package com.penta.angri3app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager);

        Adapter pagerAdapter = new Adapter(getSupportFragmentManager());

        pager.setAdapter(pagerAdapter);
    }

    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return getResources().getText(R.string.title_carta);
            case 1:
                return getResources().getText(R.string.title_punto);
        }
        return null;
    }
}

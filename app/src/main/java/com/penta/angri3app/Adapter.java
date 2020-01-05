package com.penta.angri3app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapter extends FragmentPagerAdapter {

    public Adapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public int getCount() {
        return 2; //The number of pages in the ViewPager
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new CartaFragment();

            case 1:
                return new PuntoFragment();
        }

//The fragment to be displayed on each page
        return null;
    }
    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Carta di clan";
            case 1:
                return "Punto della strada";
        }
        return null;
    }

}


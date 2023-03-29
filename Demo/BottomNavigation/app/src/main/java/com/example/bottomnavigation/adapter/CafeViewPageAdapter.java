package com.example.bottomnavigation.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.bottomnavigation.fragment.cafe.FragmentCoffee;
import com.example.bottomnavigation.fragment.cafe.FragmentTraSua;

public class CafeViewPageAdapter extends FragmentStatePagerAdapter {
    public CafeViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:return new FragmentCoffee();
            case 1:return new FragmentTraSua();
            default:return new FragmentCoffee();
        }
    }
    @Override
    public int getCount() {return 3;}
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:return "Coffee";
            case 1:return "Trà Sữa";
            default:return "Coffee";
        }
    }

}

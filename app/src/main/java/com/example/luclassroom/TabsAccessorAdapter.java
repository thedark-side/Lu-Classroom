package com.example.luclassroom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabsAccessorAdapter extends FragmentPagerAdapter {
    public TabsAccessorAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                GroupsFragment ClessesFragment= new GroupsFragment();
                return ClessesFragment;

            case 1:
                OthersFragment OthersFragment= new OthersFragment();
                return OthersFragment;
            default:


        return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Classes";


            case 1:

                return "Others";
            default:


                return null;
        }

    }
}

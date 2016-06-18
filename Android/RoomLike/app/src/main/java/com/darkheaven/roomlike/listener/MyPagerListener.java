package com.darkheaven.roomlike.listener;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.activity.MainActivity;
import com.darkheaven.roomlike.fragment.ToolbarFragment;
import com.darkheaven.roomlike.sync.GetMessages;
import com.darkheaven.roomlike.utils.SP;

public class MyPagerListener extends ViewPager.SimpleOnPageChangeListener {
    FragmentManager manager;
    public void setFragmentManager(FragmentManager manager){
        this.manager = manager;
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageSelected(int arg0) {
        manager.beginTransaction().replace(R.id.tool_bar, ToolbarFragment.newInstance(arg0)).commit();
    }
}

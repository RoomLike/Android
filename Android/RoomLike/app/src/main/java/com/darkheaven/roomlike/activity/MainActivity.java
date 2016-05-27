package com.darkheaven.roomlike.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.adapter.PagerAdapter;
import com.darkheaven.roomlike.fragment.*;
import com.darkheaven.roomlike.listener.*;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends FragmentActivity {
    public static ArrayList<BaseFragment> fragments;
    public static HashMap<String, BaseListener> listeners;
    public static ToolbarFragment toolbarFragment;
    private static FragmentManager manager;
    PagerAdapter pagerAdapter;
    MyPagerListener pageListener;
    static ViewPager pager;
    public static final String CHORE_SCREEN = "chore_screen";
    public static final String GROCERY_SCREEN = "grocery_screen";
    public static final String PAYMENT_SCREEN = "payment_screen";
    public static final String MESSAGES_SCREEN = "messages_screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        initializeFragments();

        pagerAdapter = new PagerAdapter(manager);
        pager = (ViewPager)findViewById(R.id.main_pager);
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(0);
        pager.setOffscreenPageLimit(3);
        pageListener = new MyPagerListener();
        pageListener.setFragmentManager(manager);
        pager.setOnPageChangeListener(pageListener);
    }

    public void changeScreen(String newScreen){

    }

    public void initializeFragments(){
        fragments = new ArrayList<>();
        fragments.add(ChoreFragment.newInstance());
        fragments.add(GroceryFragment.newInstance());
        fragments.add(MessageFragment.newInstance());
        fragments.add(PaymentFragment.newInstance());

        toolbarFragment = ToolbarFragment.newInstance(0);
        manager.beginTransaction().add(R.id.tool_bar, toolbarFragment).commit();
    }
}

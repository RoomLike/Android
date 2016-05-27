package com.darkheaven.roomlike.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.adapter.PagerAdapter;
import com.darkheaven.roomlike.fragment.*;
import com.darkheaven.roomlike.listener.*;

import java.util.HashMap;

public class MainActivity extends FragmentActivity {
    public static HashMap<String, BaseFragment> fragments;
    public static HashMap<String, BaseListener> listeners;
    public static ToolbarFragment toolbarFragment;
    FragmentManager manager;
    PagerAdapter pagerAdapter;
    MyPagerListener pageListener;
    ViewPager pager;
    public static final String CHORE_SCREEN = "chore_screen";
    public static final String GROCERY_SCREEN = "grocery_screen";
    public static final String PAYMENT_SCREEN = "payment_screen";
    public static final String MESSAGES_SCREEN = "messages_screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout toolBarLayout = (FrameLayout)findViewById(R.id.tool_bar);
        FrameLayout bodyAreaLayout = (FrameLayout)findViewById(R.id.fragment);
        initializeFragments();
        manager = getSupportFragmentManager();

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
        fragments = new HashMap<>();
        fragments.put(CHORE_SCREEN, ChoreFragment.newInstance());
        fragments.put(GROCERY_SCREEN, GroceryFragment.newInstance());
        fragments.put(MESSAGES_SCREEN, MessageFragment.newInstance());
        fragments.put(PAYMENT_SCREEN, PaymentFragment.newInstance());



        toolbarFragment = ToolbarFragment.newInstance(0);
    }
}

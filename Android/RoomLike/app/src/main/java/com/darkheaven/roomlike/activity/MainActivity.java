package com.darkheaven.roomlike.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.darkheaven.roomlike.R;
import com.darkheaven.roomlike.adapter.PagerAdapter;
import com.darkheaven.roomlike.fragment.*;
import com.darkheaven.roomlike.listener.*;
import com.darkheaven.roomlike.object.ObjectStore;
import com.darkheaven.roomlike.utils.TestUtils;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    public static ArrayList<BaseFragment> fragments;
    public static ArrayList<BaseListener> listeners;
    public static ArrayList<BaseFragment> editFragments;
    public static ArrayList<BaseListener> editListeners;
    public static BaseFragment scheduleFragment;
    public static BaseListener scheduleListener;

    public static ToolbarFragment toolbarFragment;
    public static FragmentManager manager;
    PagerAdapter pagerAdapter;
    MyPagerListener pageListener;
    public static ViewPager pager;
    static ScrollView backgroundContainer;
    static FrameLayout backgroundScheduleContainer;
    static LinearLayout bodyContainer;

    public static final String CHORE_SCREEN_EDIT = "chore_screen_edit";
    public static final String GROCERY_SCREEN_EDIT = "grocery_screen_edit";
    public static final String PAYMENT_SCREEN_EDIT = "payment_screen_edit";
    public static final String ACTIVE_SCREEN = "active_screen_edit";

    public static final ObjectStore os = new ObjectStore();
    public static boolean mainIsShowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        TestUtils.init();
        initializeFragments();

        pagerAdapter = new PagerAdapter(manager);
        pager = (ViewPager)findViewById(R.id.main_pager);
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(1);
        pager.setOffscreenPageLimit(3);
        pageListener = new MyPagerListener();
        pageListener.setFragmentManager(manager);
        pager.setOnPageChangeListener(pageListener);

        backgroundContainer = (ScrollView)findViewById(R.id.background_container);
        backgroundScheduleContainer = (FrameLayout)findViewById(R.id.background_schedule_fragment);
        bodyContainer = (LinearLayout)findViewById(R.id.body_container);
        mainIsShowing = true;
    }

    public static void changeScreen(String newScreen){
        if(newScreen.contains("edit")) {
            bodyContainer.setVisibility(View.GONE);
            backgroundContainer.setVisibility(View.VISIBLE);
            mainIsShowing = false;
            if (newScreen.equals(CHORE_SCREEN_EDIT)) {
                manager.beginTransaction().add(R.id.background_fragment, ChoreEditFragment.newInstance()).commit();
                manager.beginTransaction().add(R.id.background_schedule_fragment, ScheduleFragment.newInstance(1)).commit();
            }else if(newScreen.equals(GROCERY_SCREEN_EDIT)){
                manager.beginTransaction().add(R.id.background_fragment, GroceryEditFragment.newInstance()).commit();
                manager.beginTransaction().add(R.id.background_schedule_fragment, ScheduleFragment.newInstance(2)).commit();
            }else if(newScreen.equals(PAYMENT_SCREEN_EDIT)){
                manager.beginTransaction().add(R.id.background_fragment, PaymentEditFragment.newInstance()).commit();
                manager.beginTransaction().add(R.id.background_schedule_fragment, ScheduleFragment.newInstance(3)).commit();
            }
        }else{
            bodyContainer.setVisibility(View.VISIBLE);
            backgroundContainer.setVisibility(View.GONE);
            mainIsShowing = true;
        }
    }

    public void initializeFragments(){
        fragments = new ArrayList<>();
        fragments.add(MessageFragment.newInstance());
        fragments.add(ChoreFragment.newInstance());
        fragments.add(GroceryFragment.newInstance());
        fragments.add(PaymentFragment.newInstance());
        fragments.add(FilesFragment.newInstance());

        listeners = new ArrayList<>();
        listeners.add(new MessageListener(this));
        listeners.add(new ChoreListener(this));
        listeners.add(new GroceryListener(this));
        listeners.add(new PaymentListener(this));
        listeners.add(new FilesListener(this));

        editFragments = new ArrayList<>();
        editFragments.add(ChoreEditFragment.newInstance());
        editFragments.add(GroceryEditFragment.newInstance());
        editFragments.add(PaymentEditFragment.newInstance());

        editListeners = new ArrayList<>();
        editListeners.add(new ChoreEditListener(this));
        editListeners.add(new GroceryEditListener(this));
        editListeners.add(new PaymentEditListener(this));

        for(int i = 0; i < fragments.size(); i++){
            fragments.get(i).setListener(listeners.get(i));
            listeners.get(i).setView(fragments.get(i));
        }

        for(int i = 0; i < editFragments.size(); i++){
            editFragments.get(i).setListener(listeners.get(i));
            editListeners.get(i).setView(fragments.get(i));
        }

        scheduleFragment = ScheduleFragment.newInstance(0);
        scheduleListener = new ScheduleListener(this);
        scheduleFragment.setListener(scheduleListener);
        scheduleListener.setView(scheduleFragment);

        toolbarFragment = ToolbarFragment.newInstance(0);
        manager.beginTransaction().add(R.id.tool_bar, toolbarFragment).commit();
    }

    @Override
    public void onBackPressed(){
        if(mainIsShowing){
            super.onBackPressed();
        }else{
            changeScreen("ANYTHING");
        }
    }
}

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
import com.darkheaven.roomlike.utils.SP;
import com.darkheaven.roomlike.utils.TestUtils;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    public static ArrayList<BaseFragment> fragments;
    public static ArrayList<BaseListener> listeners;
    public static ArrayList<BaseFragment> editFragments;
    public static ArrayList<BaseListener> editListeners;
    public static BaseFragment scheduleFragment;
    public static BaseListener scheduleListener;
    public static BaseFragment loginFragment;
    public static BaseListener loginListener;

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
    public static final String LOGIN_SCREEN = "login_screen";
    public static final String ACTIVE_SCREEN = "active_screen_edit";

    public static final ObjectStore os = new ObjectStore();
    public static boolean mainIsShowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //SP.saveString(SP.USER_NAME_KEY, "Curtis");
        //SP.saveInt(SP.GROUP_ID_KEY, 1);
        manager = getSupportFragmentManager();
        TestUtils.init();
        initializeFragments();

        pagerAdapter = new PagerAdapter(manager);
        pager = (ViewPager)findViewById(R.id.main_pager);
        pager.setAdapter(pagerAdapter);

        toolbarFragment = ToolbarFragment.newInstance(1);
        manager.beginTransaction().add(R.id.tool_bar, toolbarFragment).commit();

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
            // TODO : clean scheduleFragment views
            if (newScreen.equals(CHORE_SCREEN_EDIT)) {
                manager.beginTransaction().add(R.id.background_fragment, editFragments.get(0)).commit();
                ((ScheduleListener)scheduleListener).setScreen(0);
                manager.beginTransaction().add(R.id.background_schedule_fragment, scheduleFragment).commit();
            }else if(newScreen.equals(GROCERY_SCREEN_EDIT)){
                manager.beginTransaction().add(R.id.background_fragment, editFragments.get(1)).commit();
                ((ScheduleListener)scheduleListener).setScreen(1);
                manager.beginTransaction().add(R.id.background_schedule_fragment, scheduleFragment).commit();
            }else if(newScreen.equals(PAYMENT_SCREEN_EDIT)){
                manager.beginTransaction().add(R.id.background_fragment, editFragments.get(2)).commit();
                ((ScheduleListener)scheduleListener).setScreen(2);
                manager.beginTransaction().add(R.id.background_schedule_fragment, scheduleFragment).commit();
            }
        }else if(newScreen.equals(LOGIN_SCREEN)) {
            bodyContainer.setVisibility(View.GONE);
            backgroundContainer.setVisibility(View.VISIBLE);
            mainIsShowing = false;
            manager.beginTransaction().add(R.id.background_fragment, loginFragment).commit();
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
        fragments.add(SettingsFragment.newInstance());

        listeners = new ArrayList<>();
        listeners.add(new MessageListener(this));
        listeners.add(new ChoreListener(this));
        listeners.add(new GroceryListener(this));
        listeners.add(new PaymentListener(this));
        listeners.add(new FilesListener(this));
        listeners.add(new SettingsListener(this));

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
            editFragments.get(i).setListener(editListeners.get(i));
            editListeners.get(i).setView(editFragments.get(i));
        }

        scheduleFragment = ScheduleFragment.newInstance();
        scheduleListener = new ScheduleListener(this);
        scheduleFragment.setListener(scheduleListener);
        scheduleListener.setView(scheduleFragment);

        if(SP.getString(SP.USER_NAME_KEY).equals("")){
            loginFragment = LoginFragment.newInstance();
            loginListener = new LoginListener(this);
            loginFragment.setListener(loginListener);
            loginListener.setView(loginFragment);
        }
    }

    @Override
    public void onBackPressed(){
        if(mainIsShowing){
            super.onBackPressed();
        }else{
            changeScreen("ANYTHING");
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        if(SP.getString(SP.USER_NAME_KEY).equals("")){
            changeScreen(LOGIN_SCREEN);
        }
    }
}

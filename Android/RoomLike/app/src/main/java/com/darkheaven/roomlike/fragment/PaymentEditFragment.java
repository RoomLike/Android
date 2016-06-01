package com.darkheaven.roomlike.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darkheaven.roomlike.R;

/**
 * Created by tinyiota on 5/27/16.
 */
public class PaymentEditFragment extends BaseFragment {
    public PaymentEditFragment(){}

    public static BaseFragment newInstance(){
        PaymentEditFragment fragment = new PaymentEditFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_payment_edit, container, false);
        return rootView;
    }
}

package com.example.kevin.tdandroid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class fragment2 extends Fragment {
    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        imageView=(ImageView)view.findViewById(R.id.imageView);
        return view;
    }

    public void changeData(String data)
    {
        int resId = getResources().getIdentifier(data.toLowerCase(),"drawable", getContext().getPackageName());
        imageView.setImageResource(resId);
    }
}

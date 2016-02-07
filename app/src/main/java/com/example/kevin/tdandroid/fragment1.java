package com.example.kevin.tdandroid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

public class fragment1 extends Fragment {

    private String[] vehicules = {"voiture", "moto", "camion", "bateau", "avion"};
    private DataTransmit dataTransmit;

    public fragment1() {
        // Required empty public constructor
    }

    public interface DataTransmit{
        public void transmit(String data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_fragment1, container, false);
        final NumberPicker picker = (NumberPicker)view.findViewById(R.id.nbrPicker);
        picker.setMinValue(0);
        picker.setMaxValue(vehicules.length - 1);
        picker.setDisplayedValues(vehicules);
        picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                dataTransmit = (DataTransmit) getActivity();
                dataTransmit.transmit(vehicules[picker.getValue()]);
            }
        });

        return view;
    }
}

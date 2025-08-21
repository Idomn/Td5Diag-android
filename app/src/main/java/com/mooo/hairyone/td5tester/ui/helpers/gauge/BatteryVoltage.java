package com.mooo.hairyone.td5tester.ui.helpers.gauge;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import com.mooo.hairyone.td5tester.R;
import com.mooo.hairyone.td5tester.ui.helpers.Td5Gauge;

public class BatteryVoltage extends Td5Gauge {

    public BatteryVoltage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        int min = getContext().getResources().getInteger(R.integer.batteryVoltage_gaugeMin_V);
        int max = getContext().getResources().getInteger(R.integer.batteryVoltage_gaugeMax_V);

        setGaugeName(getContext().getResources().getString(R.string.battery_voltage_short));
        setGraduationMin(min);
        setGraduationMax(max);
        setValue(max);
        setValueDisplayFormat("%2.1f");
        setUnitText("V");
        setValueTextSize(12f);
        setGraduationCountMajor((int) (max - min) + 1);
        section_add(min,
                getContext().getResources().getInteger(R.integer.batteryVoltage_empty_mV) / 1000.0f,
                Color.RED);
        section_add(getContext().getResources().getInteger(R.integer.batteryVoltage_empty_mV) / 1000.0f,
                getContext().getResources().getInteger(R.integer.batteryVoltage_full_mV) / 1000.0f,
                Color.GRAY);
        section_add(getContext().getResources().getInteger(R.integer.batteryVoltage_charging_mV) / 1000.0f,
                getContext().getResources().getInteger(R.integer.batteryVoltage_high_mV) / 1000.0f,
                Color.GREEN);
        section_add(getContext().getResources().getInteger(R.integer.batteryVoltage_high_mV) / 1000.0f,
                max,
                Color.RED);
    }
}


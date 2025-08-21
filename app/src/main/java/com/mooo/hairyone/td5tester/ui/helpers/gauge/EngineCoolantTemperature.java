package com.mooo.hairyone.td5tester.ui.helpers.gauge;

import android.content.Context;
import android.util.AttributeSet;

import com.mooo.hairyone.td5tester.R;
import com.mooo.hairyone.td5tester.ui.helpers.Td5Gauge;

public class EngineCoolantTemperature extends Td5Gauge {

    public EngineCoolantTemperature(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    protected void init() {
        int min = getContext().getResources().getInteger(R.integer.engine_coolantTemperature_gaugeMin);
        int max = getContext().getResources().getInteger(R.integer.engine_coolantTemperature_gaugeMax);

        setGraduationMin(min);
        setGraduationMax(max);
        setGaugeName(getContext().getResources().getString(R.string.engine_coolant_temperature_short));
        setValue(max);
        setValueDisplayFormat("%3.0f");
        setUnitText("°C");
        section_add(min,
                getContext().getResources().getInteger(R.integer.engine_coolantTemperature_cold),
                getContext().getResources().getColor(R.color.valueInc_low));
        section_add(getContext().getResources().getInteger(R.integer.engine_coolantTemperature_cold),
                getContext().getResources().getInteger(R.integer.engine_coolantTemperature_thermostat_closed),
                getContext().getResources().getColor(R.color.valueInc_ok_low));
        section_add(getContext().getResources().getInteger(R.integer.engine_coolantTemperature_thermostat_closed),
                getContext().getResources().getInteger(R.integer.engine_coolantTemperature_thermostat_opened),
                getContext().getResources().getColor(R.color.valueInc_ok));
        section_add(getContext().getResources().getInteger(R.integer.engine_coolantTemperature_thermostat_opened),
                getContext().getResources().getInteger(R.integer.engine_coolantTemperature_load_reduction),
                getContext().getResources().getColor(R.color.valueInc_ok_high));
        section_add(getContext().getResources().getInteger(R.integer.engine_coolantTemperature_load_reduction),
                getContext().getResources().getInteger(R.integer.engine_coolantTemperature_dangerzone),
                getContext().getResources().getColor(R.color.valueInc_high));
        section_add(getContext().getResources().getInteger(R.integer.engine_coolantTemperature_dangerzone),
                max,
                getContext().getResources().getColor(R.color.valueInc_veryHigh));
    }
}


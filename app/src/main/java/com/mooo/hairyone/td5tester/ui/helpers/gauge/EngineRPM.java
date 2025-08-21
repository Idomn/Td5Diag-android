package com.mooo.hairyone.td5tester.ui.helpers.gauge;

import android.content.Context;
import android.util.AttributeSet;

import com.mooo.hairyone.td5tester.R;
import com.mooo.hairyone.td5tester.ui.helpers.Td5Gauge;

public class EngineRPM extends Td5Gauge {

    public EngineRPM(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    protected void init() {
        int min = getContext().getResources().getInteger(R.integer.engine_rpm_gaugeMin);
        int max = getContext().getResources().getInteger(R.integer.engine_rpm_gaugeMax);

        setGraduationMin(min);
        setGraduationMax(max);
        setGaugeName(getContext().getResources().getString(R.string.engine_rpm_short));
        setValue(max);
        setValueDisplayFormat("%4.0f");
        setUnitText("RPM");
        setDialValueRangeFactor(1000);
        setGraduationCountMajor(((max - min) / 1000) + 1);
        setGraduationCountMinor(((max - min) / 1000) + 1);
        setGraduationMajorFormat("%.0f");
        section_add(min,
                getContext().getResources().getInteger(R.integer.engine_rpm_idle_low),
                getContext().getResources().getColor(R.color.valueInc_invalid));
        section_add(getContext().getResources().getInteger(R.integer.engine_rpm_idle_low),
                getContext().getResources().getInteger(R.integer.engine_rpm_idle_high),
                getContext().getResources().getColor(R.color.valueInc_veryLow));
        section_add(getContext().getResources().getInteger(R.integer.engine_rpm_idle_high),
                getContext().getResources().getInteger(R.integer.engine_rpm_torque80_low),
                getContext().getResources().getColor(R.color.valueInc_low));
        section_add(getContext().getResources().getInteger(R.integer.engine_rpm_torque80_low),
                getContext().getResources().getInteger(R.integer.engine_rpm_torque90),
                getContext().getResources().getColor(R.color.valueInc_ok_low));
        section_add(getContext().getResources().getInteger(R.integer.engine_rpm_torque90),
                getContext().getResources().getInteger(R.integer.engine_rpm_torqueMax),
                getContext().getResources().getColor(R.color.valueInc_ok));
        section_add(getContext().getResources().getInteger(R.integer.engine_rpm_torqueMax),
                getContext().getResources().getInteger(R.integer.engine_rpm_torque80_high),
                getContext().getResources().getColor(R.color.valueInc_ok_high));
        section_add(getContext().getResources().getInteger(R.integer.engine_rpm_torque80_high),
                getContext().getResources().getInteger(R.integer.engine_rpm_maxGovernedSpeed),
                getContext().getResources().getColor(R.color.valueInc_high));
        section_add(getContext().getResources().getInteger(R.integer.engine_rpm_maxGovernedSpeed),
                max,
                getContext().getResources().getColor(R.color.valueInc_veryHigh));
    }
}


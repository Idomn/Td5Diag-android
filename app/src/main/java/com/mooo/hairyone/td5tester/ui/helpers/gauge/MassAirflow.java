package com.mooo.hairyone.td5tester.ui.helpers.gauge;

import android.content.Context;
import android.util.AttributeSet;

import com.mooo.hairyone.td5tester.R;
import com.mooo.hairyone.td5tester.ui.helpers.Td5Gauge;

public class MassAirflow extends Td5Gauge {

    public MassAirflow(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    protected void init() {
        int min = getContext().getResources().getInteger(R.integer.intake_massAirflow_gaugeMin);
        int max = getContext().getResources().getInteger(R.integer.intake_massAirflow_gaugeMax);

        setGaugeName(getContext().getResources().getString(R.string.mass_airflow_short));
        setGraduationMin(min);
        setGraduationMax(max);
        setValue(max);
        setValueDisplayFormat("%3.1f");
        setUnitText(getContext().getResources().getString(R.string.mass_airflow_unit_short));
        setGraduationCountMajor((int) ((max - min) / 100.0f) + 1);
        setGraduationCountMinor((int) ((max - min) / 50.0f) + 1);
        setGraduationMajorFormat("%.0f");
        setGraduationMinorFormat("");
        section_add(min,
                getContext().getResources().getInteger(R.integer.intake_massAirflow_low),
                getContext().getResources().getColor(R.color.valueInc_veryLow));
    }
}


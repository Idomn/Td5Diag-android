package com.mooo.hairyone.td5tester.ui.helpers.gauge;

import android.content.Context;
import android.util.AttributeSet;

import com.mooo.hairyone.td5tester.R;
import com.mooo.hairyone.td5tester.ui.helpers.Td5Gauge;

public class ManifoldAirPressure extends Td5Gauge {

    public ManifoldAirPressure(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        float minBar = getContext().getResources().getInteger(R.integer.intake_manifoldAirPressure_gaugeMin_mBar) / 1000.0f;
        float maxBar = getContext().getResources().getInteger(R.integer.intake_manifoldAirPressure_gaugeMax_mBar) / 1000.0f;

        setGaugeName(getContext().getResources().getString(R.string.manifold_turbo_pressure_short));
        setAngles(-135, 90);
        setGraduationMin(minBar);
        setGraduationMax(maxBar);
        setValue(maxBar);
        setValueDisplayFormat("% 1.1f");
        setUnitText(getContext().getResources().getString(R.string.manifold_turbo_pressure_unit_short));
        setGraduationCountMajor((int) ((maxBar - minBar) / 0.5f) + 1);
        setGraduationCountMinor((int) ((maxBar - minBar) / 0.25f) + 1);
        setGraduationMajorFormat("%.1f");
        setGraduationMinorFormat("");
        section_add(minBar,
                0,
                getContext().getResources().getColor(R.color.valueInc_veryLow));
        section_add(0,
                getContext().getResources().getInteger(R.integer.intake_manifoldAirPressure_max_mBar) / 1000.0f,
                getContext().getResources().getColor(R.color.valueInc_ok));
        section_add(getContext().getResources().getInteger(R.integer.intake_manifoldAirPressure_max_mBar) / 1000.0f,
                maxBar,
                getContext().getResources().getColor(R.color.valueInc_high));
    }
}


package com.franmelado.lapses;

import android.app.*;
import android.os.*;

public class LapsesActivity extends Activity
    implements ScaleFragment.ScaleFragmentListener {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onScaleFragmentSelected(int scale) {
        // The user selected a new scale value from the ScaleFragment
        // Pass this value to SlidersFragment
        SlidersFragment slidersFrag = (SlidersFragment)
                getFragmentManager().findFragmentById(R.id.fragment_sliders);
        slidersFrag.updateScale(scale);
    }

}

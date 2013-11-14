package com.franmelado.lapses;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.franmelado.lapses.*;

public class SlidersFragment extends Fragment {

	SeekBar seekbarScale;
	SeekBar seekbarSSD;
	SeekBar seekbarSSI;
	SeekBar seekbarFMD;
	SeekBar seekbarFMF;

	TextView scaleValue;
	TextView valueSSD;
	TextView valueSSI;
	TextView valueFMD;
	TextView valueFMF;
	TextView picTotal;
	
	@Override
	public void onActivityCreated(){
		super.onActivityCreated();
		((LapsesActivity)this.getActivity()).getLapse();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_sliders,container,false);
		setHasOptionsMenu(false);
		return view;
		
		/**
         * Initialization of variables
         */
        
        /*
		//Initialization of Scale
        LayoutInflater factory = LayoutInflater.from(this);
        scaleview = factory.inflate(R.layout.scale, null);
        seekbarScale = (SeekBar) scaleview.findViewById(R.id.sbScale);
		scaleValue = (TextView) scaleview.findViewById(R.id.tvScaleValue2);
		seekbarScale = (SeekBar) scaleview.findViewById(R.id.sbScale);
		seekbarScale.setProgress (myLapse.getScale() - 1);
		scaleValue.setText ("max. " + myLapse.getScale() + " h");
		*/
		
        //Initialization of Shooting session - Duration
        valueSSD = (TextView) findViewById(R.id.tvSSDurationV);
        seekbarSSD = (SeekBar) findViewById(R.id.sbSSDuration);
        seekbarSSD.setProgress(myLapse.getSsd() - 1);
        valueSSD.setText(myLapse.formatS(myLapse.getSsd()));
        
        // Initialization of Shooting session - Interval
        valueSSI = (TextView) findViewById(R.id.tvSSIntervalV);
        seekbarSSI = (SeekBar) findViewById(R.id.sbSSInterval);
        seekbarSSI.setProgress(myLapse.getSsi() - 1);
        valueSSI.setText(myLapse.formatS(myLapse.getSsi()));
        
        //Initialization of Final movie - Duration
        valueFMD = (TextView) findViewById(R.id.tvFMDurationV);
        seekbarFMD = (SeekBar) findViewById(R.id.sbFMDuration);
        seekbarFMD.setProgress(myLapse.getFmd() - 1);
        valueFMD.setText(myLapse.formatS(myLapse.getFmd()));
        
        //Initialization of Final movie - FPS
        valueFMF = (TextView) findViewById(R.id.tvFMfpsV);
        seekbarFMF = (SeekBar) findViewById(R.id.sbFMfps);
        seekbarFMF.setProgress(myLapse.getFmf() - 1);
        valueFMF.setText(myLapse.getFmf() + " fps");
        
        //Initialization of pictotal
        picTotal = (TextView) findViewById(R.id.tvNumpic);
        picTotal.setText (myLapse.getPt() + " " + getString(R.string.pictotal));
		
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.activity_lapses, menu);
	}

}

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
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		((LapsesActivity)this.getActivity()).getLapse();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_sliders,container,false);
		setHasOptionsMenu(false);
		
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
        valueSSD = (TextView) view.findViewById(R.id.tvSSDurationV);
        seekbarSSD = (SeekBar) view.findViewById(R.id.sbSSDuration);
        seekbarSSD.setProgress(((LapsesActivity)this.getActivity()).getLapse().getSsd() - 1);
        valueSSD.setText(((LapsesActivity)this.getActivity()).getLapse().formatS(((LapsesActivity)this.getActivity()).getLapse().getSsd()));
        
        // Initialization of Shooting session - Interval
        valueSSI = (TextView) view.findViewById(R.id.tvSSIntervalV);
        seekbarSSI = (SeekBar) view.findViewById(R.id.sbSSInterval);
        seekbarSSI.setProgress(((LapsesActivity)this.getActivity()).getLapse().getSsi() - 1);
        valueSSI.setText(((LapsesActivity)this.getActivity()).getLapse().formatS(((LapsesActivity)this.getActivity()).getLapse().getSsi()));
        
        //Initialization of Final movie - Duration
        valueFMD = (TextView) view.findViewById(R.id.tvFMDurationV);
        seekbarFMD = (SeekBar) view.findViewById(R.id.sbFMDuration);
        seekbarFMD.setProgress(((LapsesActivity)this.getActivity()).getLapse().getFmd() - 1);
        valueFMD.setText(((LapsesActivity)this.getActivity()).getLapse().formatS(((LapsesActivity)this.getActivity()).getLapse().getFmd()));
        
        //Initialization of Final movie - FPS
        valueFMF = (TextView) view.findViewById(R.id.tvFMfpsV);
        seekbarFMF = (SeekBar) view.findViewById(R.id.sbFMfps);
        seekbarFMF.setProgress(((LapsesActivity)this.getActivity()).getLapse().getFmf() - 1);
        valueFMF.setText(((LapsesActivity)this.getActivity()).getLapse().getFmf() + " fps");
        
        //Initialization of pictotal
        picTotal = (TextView) view.findViewById(R.id.tvNumpic);
        picTotal.setText (((LapsesActivity)this.getActivity()).getLapse().getPt() + " " + getString(R.string.pictotal));
		
	    return view;
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.activity_lapses, menu);
	}

}

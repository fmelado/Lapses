package com.franmelado.lapses;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.SeekBar.*;

public class SlidersFragment extends Fragment {

	SeekBar seekbarSSD;
	SeekBar seekbarSSI;
	SeekBar seekbarFMD;
	SeekBar seekbarFMF;

	TextView valueSSD;
	TextView valueSSI;
	TextView valueFMD;
	TextView valueFMF;
	TextView picTotal;
	
	int scale;
	
	Lapse myLapse;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_sliders,container,false);
		setHasOptionsMenu(true);
		
		/**
         * Initialization of variables
         */
		 
		myLapse = new Lapse();
		
        //Initialization of Shooting session - Duration
        valueSSD = (TextView) view.findViewById(R.id.tvSSDurationV);
        seekbarSSD = (SeekBar) view.findViewById(R.id.sbSSDuration);
        seekbarSSD.setProgress(myLapse.getSsd() - 1);
        valueSSD.setText(myLapse.formatS(myLapse.getSsd()));
		// Retrieve saved scale value, default=2
		final SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
		scale = sharedPref.getInt("com.franmelado.lapses.scale", 2);
		seekbarSSD.setMax((scale * 3600) - 1);
        
        // Initialization of Shooting session - Interval
        valueSSI = (TextView) view.findViewById(R.id.tvSSIntervalV);
        seekbarSSI = (SeekBar) view.findViewById(R.id.sbSSInterval);
        seekbarSSI.setProgress(myLapse.getSsi() - 1);
        valueSSI.setText(myLapse.formatS(myLapse.getSsi()));
        
        //Initialization of Final movie - Duration
        valueFMD = (TextView) view.findViewById(R.id.tvFMDurationV);
        seekbarFMD = (SeekBar) view.findViewById(R.id.sbFMDuration);
        seekbarFMD.setProgress(myLapse.getFmd() - 1);
        valueFMD.setText(myLapse.formatS(myLapse.getFmd()));
        
        //Initialization of Final movie - FPS
        valueFMF = (TextView) view.findViewById(R.id.tvFMfpsV);
        seekbarFMF = (SeekBar) view.findViewById(R.id.sbFMfps);
        seekbarFMF.setProgress(myLapse.getFmf() - 1);
        valueFMF.setText(myLapse.getFmf() + " fps");
        
        //Initialization of pictotal
        picTotal = (TextView) view.findViewById(R.id.tvNumpic);
        picTotal.setText (myLapse.getPt() + " " + getString(R.string.pictotal));
		
		/**
         * Handle changes on seekbars
		 */
		
        //Handle changes on SSD seekbar
        seekbarSSD.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {

        	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        		myLapse.setSsd(seekbarSSD.getProgress() + 1);
             	//Calculate pt (=ssd/ssi) and fmd (=pt/fmf)
             	myLapse.setPt(seekbarSSD.getProgress() + 1, seekbarSSI.getProgress() + 1);
             	myLapse.setFmd(seekbarFMF.getProgress() + 1);
                 //Refresh views
             	valueSSD.setText(myLapse.formatS(myLapse.getSsd()));
             	valueFMD.setText(myLapse.formatS(myLapse.getFmd()));
             	seekbarFMD.setProgress(myLapse.getFmd() - 1);
             	picTotal.setText(myLapse.getPt() + " " + getString(R.string.pictotal));
            }
             	
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
             	
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
             
        //Handle changes on SSI seekbar
        seekbarSSI.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {
                 	
        	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                myLapse.setSsi(seekbarSSI.getProgress() + 1);
                //Calculate
                myLapse.setPt(seekbarSSD.getProgress() + 1, seekbarSSI.getProgress() + 1);
                myLapse.setFmd(seekbarFMF.getProgress() + 1);
                //Refresh views
                valueSSI.setText(myLapse.formatS(myLapse.getSsi()));
             	valueFMD.setText(myLapse.formatS(myLapse.getFmd()));
             	seekbarFMD.setProgress(myLapse.getFmd() - 1);
             	picTotal.setText(myLapse.getPt() + " " + getString(R.string.pictotal));
            }
                 	
        	public void onStartTrackingTouch(SeekBar seekBar) {
            }
                 	
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        }); 
             
        //Handle changes on FMD seekbar
        seekbarFMD.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {
             	
        	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
             	myLapse.setFmd(seekbarFMD.getProgress() + 1);
             	//Calculate
             	myLapse.setPt(seekbarSSD.getProgress() + 1, seekbarSSI.getProgress() + 1);
             	myLapse.setFmf(seekbarFMD.getProgress() + 1);
                //Refresh views
             	valueFMD.setText(myLapse.formatS(myLapse.getFmd()));
             	valueFMF.setText(myLapse.getFmf() + " fps");
             	seekbarFMF.setProgress(myLapse.getFmf() - 1);
             	picTotal.setText(myLapse.getPt() + " " + getString(R.string.pictotal));
        	}
             	
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
             	
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
             
        //Handle changes on FMF seekbar
        seekbarFMF.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {
                 	
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                myLapse.setFmf(seekbarFMF.getProgress() + 1);
                //Calculate
                myLapse.setPt(seekbarSSD.getProgress() + 1, seekbarSSI.getProgress() + 1);
                myLapse.setFmd(seekbarFMF.getProgress() + 1);
                //Refresh views
                valueFMF.setText(myLapse.getFmf() + " fps");
             	valueFMD.setText(myLapse.formatS(myLapse.getFmd()));
             	seekbarFMD.setProgress(myLapse.getFmd() - 1);
             	picTotal.setText(myLapse.getPt() + " " + getString(R.string.pictotal));
            }
                 	
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
                 	
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
		
		return view;
    }

    public void updateScale(int scale) {
        // The activity calls this method when
		// the scale in ScaleFragment changes
		seekbarSSD.setMax((scale * 3600) - 1);
    }
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.fragment_sliders, menu);
	}
	
	/* Pasar a SlidersFragment.java
	// Updates scale menu item
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		MenuItem scaleItem;
		scaleItem = menu.findItem(R.id.menuScale);
		String hh = myLapse == null ? "2H" : String.valueOf(myLapse.getScale());
		//Integer hh = myLapse == null ? 1 : myLapse.getScale();
		//scaleItem.setTitle(Integer.parseInt(hh));
		scaleItem.setTitle(hh);
		return super.onPrepareOptionsMenu(menu);
	}
	*/

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case (R.id.menuScale):
			FragmentManager fm = getFragmentManager();
            ScaleFragment sf = new ScaleFragment();
            sf.show(fm, "fragment_scale");
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
    public void onFinishScaleDialog(int scale) {
        myLapse.setScale(scale);
	}
}

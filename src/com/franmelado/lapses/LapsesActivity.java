package com.franmelado.lapses;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class LapsesFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_lapses,container,false);
		setHasOptionsMenu(false);
		return view;
	}

}

public class LapsesActivity extends Activity {

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
	
	Lapse myLapse;
	
	private static final int SCALE_DIALOG_ID = 0;
	AlertDialog.Builder scaledialogbuilder;
	AlertDialog scaledialog;
	View scaleview;
	
	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog;
    	switch(id) {
    		case (SCALE_DIALOG_ID): {
				//Create and setup the dialog builder
				scaledialogbuilder = new AlertDialog.Builder(LapsesActivity.this);
				scaledialogbuilder.setView(scaleview);
				scaledialogbuilder.setTitle(getString(R.string.scale));
				scaledialogbuilder.setPositiveButton(R.string.hide, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id){
							dialog.cancel();
						}	
					});
				//Create and show the dialog
				scaledialog = scaledialogbuilder.create();	
				dialog = scaledialog;
				break;
    		}
    		default: dialog = null;
    	}
		return dialog;
    }
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        myLapse = new Lapse();
        
        /**
         * Initialization of variables
         */
        
        //Initialization of Scale
        LayoutInflater factory = LayoutInflater.from(this);
        scaleview = factory.inflate(R.layout.scale, null);
        seekbarScale = (SeekBar) scaleview.findViewById(R.id.sbScale);
		scaleValue = (TextView) scaleview.findViewById(R.id.tvScaleValue2);
		seekbarScale = (SeekBar) scaleview.findViewById(R.id.sbScale);
		seekbarScale.setProgress (myLapse.getScale() - 1);
		scaleValue.setText ("max. " + myLapse.getScale() + " h");
		
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
             
        /**
         * Handle changes on seekbars
         */
        
        //Handle changes on Scale
      	seekbarScale.setOnSeekBarChangeListener ( new OnSeekBarChangeListener() {
      		
      		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
      			//Seekbar values: 0-29, text values: 1-30. It's the same with the other seekbars.
              	//Calculate
              	myLapse.setScale(progress + 1);
                seekbarSSD.setMax(myLapse.getScale() * 3600);
                //Refresh views
              	invalidateOptionsMenu(); //Reloads the menu
              	scaleValue.setText ("max. " + myLapse.getScale() + " h");
      		}
      		
      		public void onStopTrackingTouch(SeekBar seekBar) {
			}
                
      		public void onStartTrackingTouch(SeekBar seekBar) {
            }
      	});
        
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_lapses, menu);
		return super.onCreateOptionsMenu(menu);
    }
	
	// Updates scale menu item
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		MenuItem scaleItem;
		scaleItem = menu.findItem(R.id.menuScale);
		//String hh = myLapse == null ? "2H" : String.valueOf(myLapse.getScale());
		Integer hh = myLapse == null ? 1 : myLapse.getScale();
		//scaleItem.setTitle(Integer.parseInt(hh));
		scaleItem.setTitle(hh);
		return super.onPrepareOptionsMenu(menu);
	}
    
	@SuppressWarnings("deprecation")
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case (R.id.menuScale):
			showDialog(SCALE_DIALOG_ID);
			return true;
		case (R.id.menuHelp):
			Intent intent = new Intent(LapsesActivity.this, HelpActivity.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
    
}

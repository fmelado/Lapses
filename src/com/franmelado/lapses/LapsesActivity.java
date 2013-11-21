package com.franmelado.lapses;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.SeekBar.*;

public class LapsesActivity extends Activity {
	
	/* Convertir en DialogFragment
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
	*/
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
    
    }
}

package com.franmelado.lapses;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.SeekBar.*;

public class ScaleFragment extends DialogFragment {
    ScaleFragmentListener mCallback;
	
	int scale;
	SeekBar seekbarScale;
	TextView scaleValue;

    public interface ScaleFragmentListener {
        void onScaleFragmentSelected(int scale);
    }

    public ScaleFragment() {
        // Empty constructor required for DialogFragment
    }

	@Override
	public void onAttach(Activity activity) {
        super.onAttach(activity);
        
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws  an exception.
        try {
            mCallback = (ScaleFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View scaleview = inflater.inflate(R.layout.fragment_scale, null);
		builder.setTitle(R.string.scale)
            .setView(scaleview)
            .setPositiveButton(R.string.hide, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dismiss();
                }
            });
		
		// Initialization of Scale
        seekbarScale = (SeekBar) scaleview.findViewById(R.id.sbScale);
		scaleValue = (TextView) scaleview.findViewById(R.id.tvScaleValue2);
		// Retrieve saved scale value, default=2
		final SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
		scale = sharedPref.getInt("com.franmelado.lapses.scale", 2);
		// Seekbar values: 0-29, text values: 1-30. It's the same with the other seekbars.
		seekbarScale.setProgress(scale - 1);
		scaleValue.setText("max. " + scale + " h");
		
		// Handle changes on Scale
		seekbarScale.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {

		    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
			    scale = progress + 1;
		        scaleValue.setText ("max. " + scale + " h");
			    mCallback.onScaleFragmentSelected(scale); // Sends scale value to the activity
		    }

		    public void onStopTrackingTouch(SeekBar seekBar) {
			    // Save scale value in preferences
				SharedPreferences.Editor editor = sharedPref.edit();
		        editor.putInt("com.franmelado.lapses.scale", scale);
		        editor.commit();
		    }

		    public void onStartTrackingTouch(SeekBar seekBar) {
		    }
		});

        return builder.create();
    }
}

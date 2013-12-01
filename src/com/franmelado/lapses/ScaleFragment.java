package com.franmelado.lapses;

import android.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

import android.R;

public class ScaleFragment extends DialogFragment {
    ScaleFragmentListener mCallback;

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
        // the callback interface. If not, it throws  an exception
        try {
            mCallback = (ScaleFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
		Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_scale, null);
		
		// Initialization of Scale
        //seekbarScale = (SeekBar) scaleview.findViewById(R.id.sbScale);
		//scaleValue = (TextView) scaleview.findViewById(R.id.tvScaleValue2);
		//seekbarScale.setProgress (myLapse.getScale() - 1);
		//scaleValue.setText ("max. " + myLapse.getScale() + " h");
		
		getDialog().setTitle(R.id.string/lapse);

        return view;
    }
	
	@Override
    public void onScaleFragmentSelected(int scale) {
        // Send the event to the host activity
        mCallback.onScaleFragmentSelected(scale);
    }

}

package com.franmelado.lapses;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class HelpFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_help,container,false);
		setHasOptionsMenu(false);
		ImageButton gplusbutton = (ImageButton) view.findViewById(R.id.gplusButton);
		ImageButton gplv3button = (ImageButton) view.findViewById(R.id.gplv3Button);
	
	    gplusbutton.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick (View v) {
		        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about5)));
		        startActivity(browserIntent);
	        }
	    });
	
	    gplv3button.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick (View v) {
		    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about7)));
		    startActivity(browserIntent);
	        }
	    });
		
		return view;
	}
}

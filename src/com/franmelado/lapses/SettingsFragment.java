package com.franmelado.lapses;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class SettingsFragment extends Fragment {

	/*
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Load the preferences from an XML resource
		addPreferencesFromResource(R.xml.preferences);
	}
	*/

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_help,container,false);
        setHasOptionsMenu(false);
		
		ImageButton gplusbutton = (ImageButton) view.findViewById(R.id.gplusButton);
		ImageButton gplv3button = (ImageButton) view.findViewById(R.id.gplv3Button);
	
	    gplusbutton.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick (View v) {
		        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about5)));
		        startActivity(browserIntent);
	        }
	    });
	
	    gplv3button.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick (View v) {
		    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about7)));
		    startActivity(browserIntent);
	        }
	    });
		
		return view;
	}
}

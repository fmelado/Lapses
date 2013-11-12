package com.franmelado.lapses;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class HelpFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_help,container,false);
		setHasOptionsMenu(false);
		return view;
	}
	
	ImageButton gplusbutton = (ImageButton) findViewById(R.id.gplusButton);
	gplusbutton.setOnClickListener(new OnClickListener() {
	@Override
	public void onClick (View v) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about5)));
		startActivity(browserIntent);
	}
	});

	ImageButton gplv3button = (ImageButton) findViewById(R.id.gplv3Button);
	gplv3button.setOnClickListener(new OnClickListener()) {
	@Override
	public void onClick (View v) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about7)));
		startActivity(browserIntent);
	}
	});

}

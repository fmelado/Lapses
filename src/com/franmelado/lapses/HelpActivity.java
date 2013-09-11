package com.franmelado.lapses;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class HelpActivity extends Activity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

	    ImageButton gplusbutton = (ImageButton) findViewById(R.id.gplusButton);
	    gplusbutton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick (View v) {
					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about5)));
					startActivity(browserIntent);
				}
			});

	    ImageButton gplv3button = (ImageButton) findViewById(R.id.gplv3Button);
	    gplv3button.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick (View v) {
					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about7)));
					startActivity(browserIntent);
				}
			});
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
    	return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
    	//Handle item selection
    	switch (item.getItemId()) {
    		case android.R.id.home:
    			//App icon in action bar clicked, go home
				Intent intent = new Intent(HelpActivity.this, LapsesActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
    }
}

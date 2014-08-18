package com.franmelado.lapses;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class LapsesActivity extends Activity
//implements ScaleFragment.ScaleFragmentListener
{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.main, new SlidersFragment())
                    .commit();
        }
    }

    /* public void onScaleFragmentSelected(int scale) {
        // The user selected a new scale value from the ScaleFragment
        // Pass this value to SlidersFragment
        SlidersFragment slidersFrag = (SlidersFragment)
                getFragmentManager().findFragmentById(R.id.fragment_sliders);
        slidersFrag.updateScale(scale);
    } */
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case (R.id.menuHelp):
				getFragmentManager().beginTransaction()
				.addToBackStack(null)
				.replace(R.id.main, new SettingsFragment())
				.commit();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

}

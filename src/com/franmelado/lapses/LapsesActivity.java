package com.franmelado.lapses;

import android.app.*;
import android.os.*;
import android.view.*;

public class LapsesActivity extends Activity
implements ScaleFragment.ScaleFragmentListener
{

	@Override
	public FragmentManager getFragmentManager()
	{
		// TODO: Implement this method
		return super.getFragmentManager();
	}
	
	FragmentManager fm = getFragmentManager();
	FragmentTransaction ft = fm.beginTransaction();
	SlidersFragment fragment = new SlidersFragment();
	ft.add(R.id.main, fragment);
	ft.commit;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
		
	    ft.addToBackStack(null)
		.add(R.id.main, new SlidersFragment)
		.commit;
		
    }

    public void onScaleFragmentSelected(int scale) {
        // The user selected a new scale value from the ScaleFragment
        // Pass this value to SlidersFragment
        SlidersFragment slidersFrag = (SlidersFragment)
                getFragmentManager().findFragmentById(R.id.fragment_sliders);
        slidersFrag.updateScale(scale);
    }
	
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
				.replace(android.R.id.main, new SettingsFragment())
				.commit();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

}

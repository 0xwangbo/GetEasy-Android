package com.example.interface_activity;

import android.app.ActionBar;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class HomeActivity extends FragmentActivity {
	
	private FrameLayout mhomecontent;
	private RadioGroup mhomeradiogroup;
	private RadioButton mremoteradiobutton; 
	private RadioButton mlocalradiobutton;
	private RadioButton maboutradiobutton;
	
	static final int NUM_ITEMS = 3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		initview();
		
	}
	
	protected void initview()
	{
		mhomecontent = (FrameLayout) findViewById(R.id.mhomecontent);
		mhomeradiogroup = (RadioGroup)findViewById(R.id.mhomeradiogroup);
		mremoteradiobutton = (RadioButton) findViewById(R.id.mremoteradiobutton);
		mlocalradiobutton = (RadioButton) findViewById(R.id.mlocalradiobutton);
		maboutradiobutton = (RadioButton) findViewById(R.id.maboutradiobutton);
		mhomeradiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				int index = 0;
				switch(checkedId){
				case R.id.mremoteradiobutton:
					index = 0;
					break;
				case R.id.mlocalradiobutton:
					index = 1;
				//Log.i("TAG", "onCheckedChanged: local");
					break;
				case R.id.maboutradiobutton:
					index = 2;
					break;
				default:
					break;
				}
				Fragment fragment = (Fragment) fragments.instantiateItem(mhomecontent, index);
				fragments.setPrimaryItem(mhomecontent, 0, fragment);
				fragments.finishUpdate(mhomecontent);
			}
		});
	}
	
	@Override
	protected void onStart() {

		super.onStart();
		mhomeradiogroup.check(R.id.mremoteradiobutton);
	}

	FragmentStatePagerAdapter fragments = new FragmentStatePagerAdapter(getSupportFragmentManager())
	{
		@Override
		public int getCount(){

			return NUM_ITEMS;
		}

		@Override
		public Fragment getItem(int i)
		{
			Fragment fragment = null;
			switch (i)
			{
			case 0:
				fragment = new Remotefragment();
				break;
			case 1:
				fragment = new Localfragment();
				break;
			case 2:
				fragment = new Aboutfragment();
				break;
			default :
				new Localfragment();
				break;
			}
			return fragment;
		}
	};
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		switch(item.getItemId()){
		case R.id.action_settings :
			break;
		case android.R.id.home :
			finish();
			break;
		default :
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}

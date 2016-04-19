package com.example.interface_activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Remotefragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			View view = LayoutInflater.from(getActivity()).inflate(R.layout.inflate_remote, null);
		return view;
	}

	@Override
	public void setMenuVisibility(boolean menuVisible) {
		super.setMenuVisibility(menuVisible);
		if(this.getView() != null)
		{
			this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
		}
			
	}
	
}

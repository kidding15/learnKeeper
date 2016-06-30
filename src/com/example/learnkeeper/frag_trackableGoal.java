package com.example.learnkeeper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class frag_trackableGoal  extends Fragment {
	 final static String TAG = frag_trackableGoal.class.getSimpleName();
		
	public frag_trackableGoal() {
		// TODO Auto-generated constructor stub
	}

	public static frag_trackableGoal newInstance() {
		return new frag_trackableGoal();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_webview, container, false);
	}
	


}

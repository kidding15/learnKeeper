package com.example.learnkeeper;

import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabbedActivity extends Fragment {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	public static final String TAG = TabbedActivity.class.getSimpleName();
	
	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	
	public static TabbedActivity newInstance() {
		return new TabbedActivity();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_item_one, container, false);
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getChildFragmentManager());
		
		mViewPager = (ViewPager) v.findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		
		return v;
	}
	
	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			//Fragment fragment = new DummySectionFragment();	
			Fragment fragment = new Fragment();
			switch(position){
			
				case 0 : 
					fragment = new frag_trackableGoal();	
					break;
				case 1 :
					fragment = new frag_trackableGoal();	
					break;
			}
//			Fragment fragment = new Fragment_gps_loc();	
//			Bundle args = new Bundle();
//			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
//			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
//	public static class DummySectionFragment extends Fragment {
//		/**
//		 * The fragment argument representing the section number for this
//		 * fragment.
//		 */
//		public static final String ARG_SECTION_NUMBER = "section_number";
//
//		public DummySectionFragment() {
//		}
//
//		@Override
//		public View onCreateView(LayoutInflater inflater, ViewGroup container,
//				Bundle savedInstanceState) {
//			View rootView = null;
//			//Log.v(TAG, "List View Item: " + getArguments().getInt(ARG_SECTION_NUMBER));
//			switch(getArguments().getInt(ARG_SECTION_NUMBER)){
//			case 1 :
//					rootView = new Fragment_case_list().onCreateView(inflater, container, savedInstanceState);	
//					break;
//			case 2 :
//					rootView = new Fragment_map_act().onCreateView(inflater, container, savedInstanceState);
//					break;
//			case 3 : 
//					rootView = new Fragment_gps_loc().onCreateView(inflater, container, savedInstanceState);
//					break;
//			
//			}
//			
//			
//			
//		
//			return rootView;
//		}
//	}

}

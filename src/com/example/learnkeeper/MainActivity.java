package com.example.learnkeeper;


import android.os.Bundle;


import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {
	
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	private String[] mDrawerItmes;
	private long exitTime = 0;	
	private String login_token = "";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//getContent();
		mTitle = mDrawerTitle = getTitle();
		
		mDrawerItmes = getResources().getStringArray(R.array.drawer_titles);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		
		// set a custom shadow that overlays the main content when the drawer oepns
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,  GravityCompat.START);
		
		// Add items to the ListView
		mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mDrawerItmes));
		// Set the OnItemClickListener so something happens when a 
		// user clicks on an item.
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		
		// Enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		
		mDrawerToggle = new ActionBarDrawerToggle(
				this, 
				mDrawerLayout, 
				R.drawable.ic_drawer, 
				R.string.drawer_open, 
				R.string.drawer_close
				) {
			@Override
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
			}
			@Override
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
			}
		};
		
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		// Set the default content area to item 0
		// when the app opens for the first time
		if(savedInstanceState == null) {
			navigateTo(0);
		}
	
	}
	
	private class DrawerItemClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			//Log.v(TAG, "ponies");
			navigateTo(position);
		}
	}
	
	private void navigateTo(int position) {
		//Log.v(TAG, "List View Item: " + position);
		
		Fragment fragment = null;
		
		
		switch(position){
		
		case 0 : 
			fragment = new TabbedActivity();
			break;
		
		case 1 : 
			//fragment = new Fragment_add_case();
			break;
		
		case 2 : 
			//fragment = new CertifyFragment();
			break;
			
		case 3 : 
			//fragment = new ReadingFragment();
			break;
			
		case 4 :
			//fragment = new WisdomFragment();
			break;
			
		case 5 :
			//fragment = new TrainingFragment();
			break;
			
		case 6 :
			//fragment = new MagazineFragment();
			break;
			
		default:
			return;
		
		}
		
		 FragmentManager fragmentManager = getSupportFragmentManager();
		   FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.content_frame, fragment);
			fragmentTransaction.addToBackStack("home");
			fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
			fragmentTransaction.commit();
		
//		switch(position) {
//		case 0:
//			/*getSupportFragmentManager()
//				.beginTransaction()
//				.add(R.id.content_frame, 
//						ItemOne.newInstance(),
//						ItemOne.TAG).commit();*/
//			getSupportFragmentManager()
//				.beginTransaction()
//				.replace(R.id.content_frame, TabbedActivity.newInstance(), TabbedActivity.TAG).commit();
//			break;
//		case 1:
//			getSupportFragmentManager()
//			.beginTransaction()
//			.replace(R.id.content_frame,
//					Fragment_add_case.newInstance(),
//					Fragment_add_case.TAG).commit();
//			break;
//		case 2:
//			getSupportFragmentManager()
//			.beginTransaction()
//			.replace(R.id.content_frame,
//					CertifyFragment.newInstance(),
//					CertifyFragment.TAG).commit();
//			break;
//		case 3:
//			getSupportFragmentManager()
//			.beginTransaction()
//			.replace(R.id.content_frame,
//					ReadingFragment.newInstance(),
//					ReadingFragment.TAG).commit();
//			break;
//		case 4:
//			getSupportFragmentManager()
//			.beginTransaction()
//			.replace(R.id.content_frame,
//					WisdomFragment.newInstance(),
//					WisdomFragment.TAG).commit();
//			break;
//		case 5:
//			getSupportFragmentManager()
//			.beginTransaction()
//			.replace(R.id.content_frame,
//					TrainingFragment.newInstance(),
//					TrainingFragment.TAG).commit();
//			break;
//		case 6:
//			getSupportFragmentManager()
//			.beginTransaction()
//			.replace(R.id.content_frame,
//					MagazineFragment.newInstance(),
//					MagazineFragment.TAG).commit();
//			break;
//
//		}
		
		
		
		
		mDrawerList.setItemChecked(position, true);
		 setTitle(mDrawerItmes[position]);
		mDrawerLayout.closeDrawer(mDrawerList);
		
	}
	
	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
		return super.onOptionsItemSelected(item);
	}
}

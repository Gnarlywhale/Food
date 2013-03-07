package com.github.cmput301w13t04.food;

import java.util.Locale;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewRecipe extends FragmentActivity implements
		ActionBar.TabListener {

	SectionsPagerAdapter mSectionsPagerAdapter;
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Setup View
		setContentView(R.layout.activity_view_recipe);

		// Setup ActionBar
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		// actionBar.setTitle( <!-- RECIPE TITLE HERE --> );

		// TODO: We're temporarily making fake ingredients.
		getIntent().putExtra("KENT_TEST", "IS A SUCCESS");

		// Setup Tab Navigation
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// Add Tab Names
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
	}

	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		mViewPager.setCurrentItem(tab.getPosition());
	}

	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// Not used.
	}

	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// Not used.
	}

	/* Handle Page Switching */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {
		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment;

			switch (position) {
			// First Tab: Description
			case 0:
				fragment = new RecipeDescriptionFragment();

				// Pass Current Recipe
				attachBundle(fragment);

				return fragment;
				
			// Second Tab: Ingredients
			case 1:
				fragment = new RecipeIngredientsFragment();

				// Pass Current Recipe
				attachBundle(fragment);

				return fragment;

			// Third Tab: Steps
			case 2:
				fragment = new RecipeStepFragment();

				// Pass Current Recipe
				attachBundle(fragment);

				return fragment;
			}

			return null;
		}

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.recipe_title_description)
						.toUpperCase(l);
			case 1:
				return getString(R.string.recipe_title_ingredients)
						.toUpperCase(l);
			case 2:
				return getString(R.string.recipe_title_steps).toUpperCase(l);
			}
			return null;
		}

		public void attachBundle(Fragment fragment) {
			Bundle bundle = getIntent().getExtras();
			Log.d("BUNDLE", bundle.toString());
			// bundle.get(key) containing
		}

	}

	/* Description Fragment */
	public static class RecipeDescriptionFragment extends Fragment {
		public RecipeDescriptionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_recipe_description, container, false);

			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);

			dummyTextView.setText("Description goes here");

			return rootView;
		}
	}

	/* Ingredient Fragment */
	public static class RecipeIngredientsFragment extends Fragment {
		public RecipeIngredientsFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_recipe_ingredients, container, false);

			// TODO: Populate ingredients
			// savedInstanceState.get(key);

			return rootView;
		}
	}

	/* Step Fragment */
	public static class RecipeStepFragment extends Fragment {
		public RecipeStepFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_recipe_steps,
					container, false);

			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.recipe_steps_test);

			dummyTextView.setText("Recipe steps go here");

			return rootView;
		}
	}
}

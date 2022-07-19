package com.example.sharedpreferencesassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addFragment(FragmentForm.newInstance());
	}

	private void addFragment(Fragment fragment){
		getSupportFragmentManager()
				.beginTransaction()
				.add(R.id.containerFragment,fragment,fragment.getTag())
				.addToBackStack(fragment.getTag())
				.commit();
	}
}
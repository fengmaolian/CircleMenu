package com.szugyi.circlemenu;

/*
 * Copyright 2013 Csaba Szugyiczki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.szugyi.circlemenu.view.CircleImageView;
import com.szugyi.circlemenu.view.CircleLayout;
import com.szugyi.circlemenu.view.CircleLayout.OnItemClickListener;
import com.szugyi.circlemenu.view.CircleLayout.OnItemSelectedListener;

public class MainActivity extends Activity implements OnItemSelectedListener, OnItemClickListener{
	TextView selectedTextView;
	Button mBtn1,mBtn2,mBtn3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		CircleLayout circleMenu = (CircleLayout)findViewById(R.id.main_circle_layout);
		circleMenu.setOnItemSelectedListener(this);
		circleMenu.setOnItemClickListener(this);

		selectedTextView = (TextView)findViewById(R.id.main_selected_textView);
		mBtn1 = (Button) findViewById(R.id.btn_one);
		mBtn2 = (Button) findViewById(R.id.btn_two);
		mBtn3 = (Button) findViewById(R.id.btn_three);
		mBtn1.setText(((CircleImageView)circleMenu.getSelectedItem()).getName()+"-one");
		mBtn2.setText(((CircleImageView)circleMenu.getSelectedItem()).getName()+"-two");
		mBtn3.setText(((CircleImageView)circleMenu.getSelectedItem()).getName()+"-three");
	}

	@Override
	public void onItemSelected(View view, int position, long id, String name) {	
		Log.i("TAG", "哈哈2"+position);
		mBtn1.setText(name+"-one");
		mBtn2.setText(name+"-two");
		mBtn3.setText(name+"-three");
	}

	@Override
	public void onItemClick(View view, int position, long id, String name) {
		Toast.makeText(getApplicationContext(), name + " " + name, Toast.LENGTH_SHORT).show();
	}

}

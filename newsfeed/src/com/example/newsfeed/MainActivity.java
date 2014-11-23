package com.example.newsfeed;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener {
 Spinner spinnerOsversions;
 TextView selVersion;
 String radiochecked = "";
 String dropchecked = "";
 private String[] state = { "The Telegraph", "The Times of India", "The Hindu" };
 private String[] tele =  {"http://www.telegraphindia.com/1141123/jsp/frontpage/index.jsp#.VHHI02PCu3Q","http://www.telegraphindia.com/1141123/jsp/nation/index.jsp#.VHHIvmPCu3Q","http://www.telegraphindia.com/1141123/jsp/foreign/index.jsp#.VHHIw2PCu3Q","http://www.telegraphindia.com/1141123/jsp/sports/index.jsp#.VHHIxmPCu3Q"};
 private String[] hindu = {"http://m.thehindu.com/top-stories/","http://m.thehindu.com/national/","http://m.thehindu.com/international/","http://m.thehindu.com/sport/"};
 private String[] times = {"http://timesofindia.feedsportal.com/c/33039/f/533965/index.rss","http://timesofindia.feedsportal.com/c/33039/f/533916/index.rss","http://timesofindia.feedsportal.com/c/33039/f/533917/index.rss","http://timesofindia.feedsportal.com/c/33039/f/533921/index.rss"};
 
 
  @Override
 public void onCreate(Bundle savedInstanceState) {
				  super.onCreate(savedInstanceState);
				  setContentView(R.layout.activity_main);
				  contentview();
				  
  }
  
  public void contentview(){
	  System.out.println(state.length);
	  selVersion = (TextView) findViewById(R.id.selVersion);
	  spinnerOsversions = (Spinner) findViewById(R.id.osversions);
	  ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this,
	    android.R.layout.simple_spinner_item, state);
	  adapter_state
	    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	  spinnerOsversions.setAdapter(adapter_state);
	  spinnerOsversions.setOnItemSelectedListener(this);
	  addButtonListener();
  }
  
  public void addButtonListener() {
	  	 	  
	 	    Button button = (Button) findViewById(R.id.SubmitButton);
	 	    button.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
				// TODO Auto-generated method stub
			RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
			if(radioGroup.getCheckedRadioButtonId()<=0)
		    {
		       Toast.makeText(getApplicationContext(),"Please select an option",
		       Toast.LENGTH_SHORT).show();
		       //setContentView(R.layout.activity_main);
		       contentview();
		    }
			
			
			dropchecked = (String) spinnerOsversions.getSelectedItem();
			if(dropchecked == "The Telegraph"){
					if(radiochecked == "Top News"){
				    	Toast.makeText(getBaseContext(), "You are redirected to The Telegraph Top news section",
								Toast.LENGTH_LONG).show();	
						Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tele[0]));
						startActivity(browserIntent);	
						}else if(radiochecked == "India"){
							Toast.makeText(getBaseContext(), "You are redirected to The Telegraph India's new section",
									Toast.LENGTH_LONG).show();	
							Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tele[1]));
							startActivity(browserIntent);					
								}else if(radiochecked == "World"){
									Toast.makeText(getBaseContext(), "You are redirected to The Telegraph International news section",
											Toast.LENGTH_LONG).show();	
									Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tele[2]));
									startActivity(browserIntent);
								}else if(radiochecked == "Sports"){
									Toast.makeText(getBaseContext(), "You are redirected to The Telegraph Sports news section",
											Toast.LENGTH_LONG).show();	
										Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tele[3]));
										startActivity(browserIntent);
								}
			}else if(dropchecked == "The Times of India"){
					if(radiochecked == "Top News"){
						Toast.makeText(getBaseContext(), "You are redirected to Times of India Top news section",
								Toast.LENGTH_LONG).show();	
							Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(times[0]));
							startActivity(browserIntent);	
							}else if(radiochecked == "India"){
								Toast.makeText(getBaseContext(), "You are redirected to Times of India India's new section",
										Toast.LENGTH_LONG).show();		
									Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(times[1]));
									startActivity(browserIntent);
										}else if(radiochecked == "World"){
											Toast.makeText(getBaseContext(), "You are redirected to Times of India World's new section",
													Toast.LENGTH_LONG).show();		
											Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(times[2]));
											startActivity(browserIntent);
											}else if(radiochecked == "Sports"){
												Toast.makeText(getBaseContext(), "You are redirected to Times of India Sports news section",
														Toast.LENGTH_LONG).show();		
												Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(times[3]));
												startActivity(browserIntent);
												}
									}
				else if(dropchecked == "The Hindu")
						if(radiochecked == "Top News"){
							Toast.makeText(getBaseContext(), "You are redirected to The Hindu Top news section",
									Toast.LENGTH_LONG).show();		
								Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(hindu[0]));
								startActivity(browserIntent);
									}else if(radiochecked == "India"){
										Toast.makeText(getBaseContext(), "You are redirected to The Hindu India's news section",
												Toast.LENGTH_LONG).show();		
										Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(hindu[1]));
										startActivity(browserIntent);
										}else if(radiochecked == "World"){
											Toast.makeText(getBaseContext(), "You are redirected to The Hindu World's news section",
													Toast.LENGTH_LONG).show();	
												Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(hindu[2]));
												startActivity(browserIntent);
											}else if(radiochecked == "Sports"){
												Toast.makeText(getBaseContext(), "You are redirected to The Hindu Sports's news section",
														Toast.LENGTH_LONG).show();	
												Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(hindu[3]));
												startActivity(browserIntent);
											}
			}
	 	   });
	 	    
  }
  
  public String onRadioButtonClicked(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	   
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.radioButton1:
	            if (checked)
	            	radiochecked = "Top News";
	            break;
	        case R.id.radioButton2:
	            if (checked)
	            	radiochecked = "India";
	            break;
	        case R.id.radioButton3:
	            if (checked)
	            	 radiochecked = "World";    	
	            break;
	        case R.id.radioButton4:
	            if (checked)
	            	radiochecked = "Sports";	                
	            break;
	    }
	    return radiochecked;
	}

  public void onItemSelected(AdapterView<?> parent, View view, int position,
   long id) {
  spinnerOsversions.setSelection(position);
  String selState = (String) spinnerOsversions.getSelectedItem();
  selVersion.setText("Selected Site is :" + selState);
 }

  @Override
 public void onNothingSelected(AdapterView<?> arg0) {
  // TODO Auto-generated method stub

  }

}
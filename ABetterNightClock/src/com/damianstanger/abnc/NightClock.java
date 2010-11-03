package com.damianstanger.abnc;

import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class NightClock extends Activity {
    private static final int AEROPLANEMODEOFF = 0;
    private static final int AEROPLANEMODEON = 1;
    private Context applicationContext;
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        applicationContext = this.getApplicationContext();
        goToFullscreenMode(); 
        setContentView(R.layout.main);
        setTodaysDate();
        //turnAirplaneModeOff();  
        UpdateAirplaneNotificationDisplay();
    }
	
	private void UpdateAirplaneNotificationDisplay() {
		View objButton = findViewById(R.id.airplainModeButton);
		Button airplaneButton=(Button)objButton;
		if(aeroplaneModeIsOn())
		{
			airplaneButton.setText(R.string.aeroplaneOn);
		}
		else
		{
			airplaneButton.setText(R.string.aeroplaneOff);
		}
	}

	private void turnAirplaneModeOff() {
		Context applicationContext = this.getApplicationContext();
		Settings.System.putInt(applicationContext.getContentResolver(),
				      		   Settings.System.AIRPLANE_MODE_ON, AEROPLANEMODEOFF);			
	}

	private void turnAirplaneModeOn() {		
		Settings.System.putInt(applicationContext.getContentResolver(),
				      		   Settings.System.AIRPLANE_MODE_ON, AEROPLANEMODEON);
	}
	
	private boolean aeroplaneModeIsOn() {
		int airplaneModeVal = Settings.System.getInt(
			      applicationContext.getContentResolver(), 
			      Settings.System.AIRPLANE_MODE_ON, 0);
		return airplaneModeVal == AEROPLANEMODEON;		
	}

	private void setTodaysDate() {
		View objDateView = findViewById(R.id.dateview);
		TextView dateView=(TextView)objDateView; 
        String todaysDate = (new Date()).toString();
		dateView.setText(todaysDate);
	}

	private void goToFullscreenMode() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);         
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
	}
}
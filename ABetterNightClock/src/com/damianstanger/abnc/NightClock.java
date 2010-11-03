package com.damianstanger.abnc;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class NightClock extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        goToFullscreenMode(); 
        setContentView(R.layout.main);
        setTodaysDate();
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
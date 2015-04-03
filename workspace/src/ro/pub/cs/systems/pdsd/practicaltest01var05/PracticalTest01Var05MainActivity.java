package ro.pub.cs.systems.pdsd.practicaltest01var05;

import ro.pub.cs.systems.pdsd.practicaltest01var05.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var05MainActivity extends Activity {

	protected ButtonClickListener buttonListener = new ButtonClickListener();
	protected int number_of_registers;
	
	protected class ButtonClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			TextView myTextView = (TextView)findViewById(R.id.coordinates);
			String myText = myTextView.getText().toString();

			if (v instanceof Button) {
				switch (v.getId()) {
				case R.id.north:
					if(myText.length() == 0) 
						myText = "North";
					else
						myText = myText + ", " + "North";
					myTextView.setText(myText);
					break;
				case R.id.south:
					if(myText.length() == 0) 
						myText = "South";
					else
						myText = myText + ", " + "South";
					myTextView.setText(myText);
					break;
				case R.id.west:
					if(myText.length() == 0) 
						myText = "West";
					else
						myText = myText + ", " + "West";
					myTextView.setText(myText);
					break;
				case R.id.east:
					if(myText.length() == 0) 
						myText = "East";
					else
						myText = myText + ", " + "East";
					myTextView.setText(myText);
					break;
					
				case R.id.navigate_to_second_activity:
					
					break;
				}
			}

		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var05_main);
		
		Button northButton = (Button) findViewById(R.id.north);
		northButton.setOnClickListener(buttonListener);
		
		Button southButton = (Button) findViewById(R.id.south);
		southButton.setOnClickListener(buttonListener);
		
		Button eastButton = (Button) findViewById(R.id.east);
		eastButton.setOnClickListener(buttonListener);
		
		Button westButton = (Button) findViewById(R.id.west);
		westButton.setOnClickListener(buttonListener);
		
		if (savedInstanceState != null) {
			String numberElem = savedInstanceState.getString("numberOfRegisters");
			if (numberElem != null){
				number_of_registers = Integer.parseInt(numberElem);
			} else {
				number_of_registers = 0;
			}
		} else {
			number_of_registers = 0;
		}
		
		Log.d("myTag", "numberOfRegisters: " + number_of_registers);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putString("numberOfRegisters", Integer.toString(number_of_registers));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var05_main, menu);
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

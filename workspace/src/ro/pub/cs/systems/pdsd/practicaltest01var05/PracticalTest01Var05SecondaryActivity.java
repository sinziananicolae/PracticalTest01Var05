package ro.pub.cs.systems.pdsd.practicaltest01var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var05SecondaryActivity extends Activity {

	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	
	private class ButtonClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			if (v instanceof Button){
				switch (v.getId()){
					case R.id.register_button:
						setResult(RESULT_OK, new Intent());
						finish();
						break;
					case R.id.cancel_button:
						setResult(RESULT_CANCELED, new Intent());
						finish();
						break;
				}
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var05_secondary);
		
		Button registerButton = (Button)findViewById(R.id.register_button);
		registerButton.setOnClickListener(buttonClickListener);
		
		Button cancelButton = (Button)findViewById(R.id.cancel_button);
		cancelButton.setOnClickListener(buttonClickListener);
		
		TextView numberOfRegisters = (TextView)findViewById(R.id.number_of_registers);
		TextView directionsSet = (TextView)findViewById(R.id.directions);
		
		Intent intent = getIntent();
		if(intent != null){
			String number_of_registers = intent.getStringExtra("number_of_registers");
			if(number_of_registers != null){
				numberOfRegisters.setText(getResources().getString(R.string.number_of_reg).replace("???", number_of_registers));
			}
			
			String directions = intent.getStringExtra("directions");
			if(directions != null){
				directionsSet.setText(getResources().getString(R.string.directions_list).replace("???", directions));
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.practical_test01_var05_secondary, menu);
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

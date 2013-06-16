package com.trane.android.simplecountingdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity {


    private Button mCountButton;
    private Switch mIncDecSwitch;
    private TextView mCountNumberTextView;
    private int mCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCountButton = (Button) findViewById(R.id.count_button);
        mIncDecSwitch = (Switch) findViewById(R.id.inc_dec_switch);
        mCountNumberTextView = (TextView) findViewById(R.id.count_number);

        //Initialize our text to something useful
        mCountNumberTextView.setText(String.valueOf(mCount) );

        //Make sure the switch is initialized
        mIncDecSwitch.setActivated(true);
        mIncDecSwitch.setChecked(true);
        mIncDecSwitch.setOnCheckedChangeListener( new IncDecSwitchChangedListener() );

        mCountButton.setText(R.string.increment_label);

        mCountButton.setOnClickListener(new CountButtonClickListener() );



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    /**
     *  @Class CountButtonClickListener
     *
     *  Private inner class that implements our button click listener that will increment or decrement
     *  the count for our simple demo.
     *
     */
    private class CountButtonClickListener implements View.OnClickListener {

        public void onClick(View view) {
            if ( mIncDecSwitch.isChecked() ) {
                // Checked is the positive count-up state
                mCount++;
                mCountNumberTextView.setText(String.valueOf(mCount));
            } else {
                // unChecked is the negative count-down state
                mCount--;
                mCountNumberTextView.setText(String.valueOf(mCount));

            }
        }
    }

    private class IncDecSwitchChangedListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                mCountButton.setText( R.string.increment_label );
            }
            else {
                mCountButton.setText( R.string.decrement_label );
            }
        }
    }

}

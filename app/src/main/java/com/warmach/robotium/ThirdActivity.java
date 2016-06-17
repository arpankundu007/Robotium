package com.warmach.robotium;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by WarMach on 17-Jun-16.
 */
public class ThirdActivity extends SecondActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        Button b = (Button) findViewById(R.id.but);
        final EditText et = (EditText) findViewById(R.id.editText_3a);
        final TextView tv = (TextView) findViewById(R.id.textView_3a);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(et.getText().toString());
            }
        });
    }
}

package com.example.normansyahputa.parcelertest;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mylibrary.TestAja;

import org.parceler.Parcels;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.hello_world);

        if(savedInstanceState!=null){
            TestAja testAja = Parcels.unwrap(savedInstanceState.getParcelable("TEST"));
            textView.setText(testAja.toString());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("TEST", Parcels.wrap(new TestAja()));
    }
}

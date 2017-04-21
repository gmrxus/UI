package com.gmrxus.roundprogress;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gmrxus.roundprogress.view.RoundProgress;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RoundProgress rd = (RoundProgress) findViewById(R.id.rp);
        rd.setProgress(89);
        rd.setMaxProgress(877);

    }

    public void setColor(@ColorRes int color) {
        Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();
    }
}

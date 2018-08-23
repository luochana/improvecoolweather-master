package com.coolweather.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class devoloper_introdution extends Activity {

    private Button back_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devoloper_introdution);
        back_button=(Button)findViewById(R.id.back_button2);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}

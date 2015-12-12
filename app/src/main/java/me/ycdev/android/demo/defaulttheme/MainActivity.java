package me.ycdev.android.demo.defaulttheme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_attributes_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AttributesTestActivity.class);
            }
        });
    }

    private void startActivity(Class<? extends Activity> target) {
        Intent intent = new Intent(this, target);
        startActivity(intent);
    }
}

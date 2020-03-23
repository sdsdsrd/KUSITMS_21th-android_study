package com.example.instagramfrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int likeCount = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox likeButton = findViewById(R.id.likebutton);
        likeButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView liketext = findViewById(R.id.liketext);
                if(isChecked) {
                    liketext.setText("좋아요 " + (++likeCount) + "개");
                }
                else {
                    liketext.setText("좋아요 " + (--likeCount) + "개");
                }
            }
        });
    }
}

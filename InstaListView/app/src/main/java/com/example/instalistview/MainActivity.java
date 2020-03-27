package com.example.instalistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<FeedItemData> items = new ArrayList<>();
                final FeedItemAdapter feedItemAdapter = new FeedItemAdapter(getApplicationContext(), items);

                ListView feedView = findViewById(R.id.feedView);
                feedView.setAdapter(feedItemAdapter);

                items.add(new FeedItemData(R.drawable.sample1, 3, "첫 번째 피드!"));
                items.add(new FeedItemData(R.drawable.sample2, 10, "두 번째 피드!"));
                items.add(new FeedItemData(R.drawable.sample3, 100, "세 번째 피드!"));

                feedItemAdapter.notifyDataSetChanged();
            }
        });
    }
}

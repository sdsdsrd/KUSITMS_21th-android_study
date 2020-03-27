package com.example.instalistview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FeedItemAdapter extends BaseAdapter {
    Context context;
    ArrayList<FeedItemData> items;

    public FeedItemAdapter(Context context, ArrayList<FeedItemData> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View feed_item = inflater.inflate(R.layout.feed_item, parent, false);
        final FeedItemData item = items.get(position);

        ImageView imageView = feed_item.findViewById(R.id.imageView);
        imageView.setImageResource(item.getImageId());
        final TextView likeTextView = feed_item.findViewById(R.id.likeTextView);
        likeTextView.setText("좋아요 " + Integer.toString(item.getLike()) + "개");
        TextView contentView = feed_item.findViewById(R.id.contentView);
        contentView.setText(item.getContent());

        CheckBox likeButton = feed_item.findViewById(R.id.likeButton);
        likeButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    likeTextView.setText("좋아요 " + Integer.toString(item.getLike() + 1) + "개");
                    Toast.makeText(context, "좋아요를 눌렀습니다!", Toast.LENGTH_SHORT).show();
                }
                else {
                    likeTextView.setText("좋아요 " + Integer.toString(item.getLike()) + "개");
                    Toast.makeText(context, "좋아요를 취소했습니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });




        return feed_item;
    }
}

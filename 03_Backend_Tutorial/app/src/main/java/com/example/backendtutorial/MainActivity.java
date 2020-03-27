package com.example.backendtutorial;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        /* Touch Listener */
        /*
        TextView textView =  findViewById(R.id.textView);
        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                if(action == MotionEvent.ACTION_DOWN) {
                    Log.d("kusitms", "onTouch : action down");
                }
                else if(action == MotionEvent.ACTION_UP) {
                    Log.d("kusitms", "onTouch: action up");
                }
                else if(action == MotionEvent.ACTION_MOVE) {
                    Log.d("kusitms", "onTouch: action move");
                }

                return true;
            }
        });
        */

        /*
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "토스트 테스트 메시지", Toast.LENGTH_SHORT).show();
            }
        });
        */


//        Button button = findViewById(R.id.button2);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar snackbar = Snackbar.make("")
//            }
//        });

        /*
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("안내창 실험");
                builder.setMessage("버튼을 누르셨습니까?");
                builder.setIcon(android.R.drawable.ic_dialog_alert);

                builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("alertDialog", "onClick: 네!");
                    }
                });
                builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("alertDialog", "onClick: 아니오!");
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        */

        //ListView
        ArrayList<BoardItemData> items = new ArrayList<>();
        BoardItemAdapter boardItemAdapter = new BoardItemAdapter(this, items);

        ListView boardView = findViewById(R.id.boardView);
        boardView.setAdapter(boardItemAdapter);

        items.add(new BoardItemData("테스트 제목1", "테스트 콘텐츠"));
        items.add(new BoardItemData("테스트 제목2", "테스트 콘텐츠"));
        items.add(new BoardItemData("테스트 제목3", "테스트 콘텐츠"));
        items.add(new BoardItemData("테스트 제목4", "테스트 콘텐츠"));

        boardItemAdapter.notifyDataSetChanged();
    }
}

package com.amiri.faleHafez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    String x = "";
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button clickButton = (Button) findViewById(R.id.buttonFal);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRandomPoem();

            }
        });
    }
    public void getRandomPoem(){
        TextView textView = findViewById(R.id.textViewPoem);
        TextView txt2 = findViewById(R.id.textView2);


        ArrayList<String> poems = new ArrayList<>();
        poems.add("soso");
        poems.add("sdfdsfadfs");
        poems.add("kikieyrgdsjdf");
        Collections.shuffle(poems);


        for (String f: poems) {
            if (!f.equals(x)) {
                textView.setText(f);
                x = f;
            }else {
                Collections.shuffle(poems);
                textView.setText(f);
            }
        }
    }
}
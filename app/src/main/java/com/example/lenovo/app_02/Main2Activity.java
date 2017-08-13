package com.example.lenovo.app_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private EditText ex_second_message;
    private Button bt_second_back1;
    private Button bt_second_back2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ex_second_message = (EditText) findViewById(R.id.ex_second_message);
        bt_second_back1 = (Button) findViewById(R.id.bt_second_back1);
        bt_second_back2 = (Button) findViewById(R.id.bt_second_back2);
        bt_second_back1.setOnClickListener(this);
        bt_second_back2.setOnClickListener(this);

        Intent intent = getIntent();
        String string = intent.getStringExtra("message");
        ex_second_message.setText(string);


    }

    @Override
    public void onClick(View view) {
        if (view == bt_second_back1) {
            finish();
        } else if (view == bt_second_back2) {
            Intent data = new Intent();
            String string = ex_second_message.getText().toString();
            data.putExtra("result", string);
            setResult(2,data);
            finish();
        }
    }
}

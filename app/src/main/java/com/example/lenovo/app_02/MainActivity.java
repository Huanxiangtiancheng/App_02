package com.example.lenovo.app_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ex_first_message;
    private Button bt_first_start1;
    private Button bt_first_start2;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ex_first_message = (EditText) findViewById(R.id.et_first_message);
        bt_first_start1 = (Button) findViewById(R.id.bt_first_start1);
        bt_first_start2 = (Button) findViewById(R.id.bt_first_start2);
        bt_first_start1.setOnClickListener(this);
        bt_first_start2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == bt_first_start1) {
            Toast.makeText(this, "一般启动", 0).show();
            Intent intent = new Intent(this,Main2Activity.class);
            String string = ex_first_message.getText().toString();
            intent.putExtra("message",string );
            startActivity(intent);

        } else if (view == bt_first_start2) {
            Toast.makeText(this, "带回调启动", 0).show();
            Intent intent = new Intent(this, Main2Activity.class);
            String string = ex_first_message.getText().toString();
            intent.putExtra("message", string);
            startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            ex_first_message.setText(data.getStringExtra("result"));

        }
    }
}

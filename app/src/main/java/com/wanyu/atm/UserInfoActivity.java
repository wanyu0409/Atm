package com.wanyu.atm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserInfoActivity extends AppCompatActivity {

    private EditText edNickname;
    private EditText edPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        edNickname = (EditText) findViewById(R.id.nickname);
        edPhone = (EditText) findViewById(R.id.phone);
        String nickname = getSharedPreferences("info", MODE_PRIVATE).getString("NAME", "");
        String phone = getSharedPreferences("info", MODE_PRIVATE).getString("PHONE", "");
        edNickname.setText(nickname);
        edPhone.setText(phone);
    }
    public void back (View view){
        String nickname = edNickname.getText().toString();
        String phone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NAME", nickname);
        getIntent().putExtra("EXTRA_PHONE", phone);
        setResult(RESULT_OK, getIntent());
        finish();
    }
}

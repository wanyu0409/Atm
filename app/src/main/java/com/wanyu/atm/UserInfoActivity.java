package com.wanyu.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {

    private EditText edNickname;
    private EditText edPhone;
    private Spinner ages;
    private String TAG = UserInfoActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ages = (Spinner) findViewById(R.id.ages);
        ArrayList<String> data = new ArrayList<>();
        for (int i = 15; i <= 40; i++){
            data.add(i+"");
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, data);
        ages.setAdapter(adapter);

        /* String nickname = getSharedPreferences("info", MODE_PRIVATE).getString("NAME", "");
        String phone = getSharedPreferences("info", MODE_PRIVATE).getString("PHONE", "");
        edNickname.setText(nickname);
        edPhone.setText(phone);*/
    }
    public void info (View view){
        Log.d(TAG, "back: " + ages.getSelectedItem().toString());
        int age = Integer.parseInt(ages.getSelectedItem().toString());
        edNickname = (EditText) findViewById(R.id.nickname);
        edPhone = (EditText) findViewById(R.id.phone);
        String nickname = edNickname.getText().toString();
        String phone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NAME", nickname);
        getIntent().putExtra("EXTRA_PHONE", phone);
        setResult(RESULT_OK, getIntent());
        finish();
    }
}

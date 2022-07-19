package com.example.clientgetdatasharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnGetData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = getContentResolver().query(Uri.parse("content://com.example.sharedpreferencesassignment.db"),
                        null,
                        null,
                        null,
                        null);
                while (cursor.moveToNext()){
                    String userName = cursor.getString(cursor.getColumnIndexOrThrow("userName"));
                    String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
                    String address = cursor.getString(cursor.getColumnIndexOrThrow("address"));
                    String accountPayment = cursor.getString(cursor.getColumnIndexOrThrow("accountPayment"));
                    Data data = new Data(userName,email,address,accountPayment);
                    TextView txtResult = findViewById(R.id.txtResult);
                    txtResult.setText(data.toString());
                }

            }
        });
    }
}
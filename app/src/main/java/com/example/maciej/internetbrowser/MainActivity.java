package com.example.maciej.internetbrowser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    public static final String GET_URL = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_text);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecondActivity();

            }
        });
    }

    public void openSecondActivity() {
        String url = editText.getText().toString();

        if (!isValidUrlAddress(url)) {
            Toast.makeText(this, R.string.url_error, Toast.LENGTH_SHORT).show();
            return;


        }

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(GET_URL, url);
        startActivity(intent);


    }

    private boolean isValidUrlAddress(String url) {
        return !TextUtils.isEmpty(url) && (url.startsWith("http://") || (url.startsWith("https://")));
    }
}


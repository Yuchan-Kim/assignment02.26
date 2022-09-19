package com.example.assignment0226;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editEmail01, editEmail02;
    Button button;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail01 = findViewById(R.id.editTextTextEmailAddress);
        editEmail02 = findViewById(R.id.editTextTextEmailAddress2);
        result = (TextView) findViewById(R.id.resultgoeshere);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkValidity(editEmail01,editEmail02) == 0){
                    result.setText("Thank you");
                }else if (checkValidity(editEmail01,editEmail02) == 2){
                    result.setText("Doesn't match");
                }else{
                    result.setText("You need to put @ to make vit as valid email address");
                }

            }
        });
    }
    public int checkValidity (EditText email01, EditText email02) {
        String str1 = editEmail01.getText().toString();
        String str2 = editEmail02.getText().toString();
        int check = 0;
        if (str1.equals(str2)){
            if (str1.contains("@")){
                if(str2.contains("@")){
                    check = 0;
                }else {
                    check = 1;
                }
            }else {
                check = 1;
            }
        }else {
            check = 2;
        }
        return check;
    }
}
package mca.acharya.com.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText input1,input2;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View v){
        input1 = findViewById(R.id.editText1);
        input2 = findViewById(R.id.editText2);
        result = findViewById(R.id.result);
        int num1 = Integer.parseInt(input1.getText().toString());
        int num2 = Integer.parseInt(input2.getText().toString());
        result.setText(Integer.toString(num1+num2));
    }

    public void sub(View v){
        input1 = findViewById(R.id.editText1);
        input2 = findViewById(R.id.editText2);
        result = findViewById(R.id.result);
        int num1 = Integer.parseInt(input1.getText().toString());
        int num2 = Integer.parseInt(input2.getText().toString());
        result.setText(Integer.toString(num1-num2));
    }

    public void mul(View v){
        input1 = findViewById(R.id.editText1);
        input2 = findViewById(R.id.editText2);
        result = findViewById(R.id.result);
        int num1 = Integer.parseInt(input1.getText().toString());
        int num2 = Integer.parseInt(input2.getText().toString());
        result.setText(Integer.toString(num1*num2));
    }

    public void div(View v){
        input1 = findViewById(R.id.editText1);
        input2 = findViewById(R.id.editText2);
        result = findViewById(R.id.result);
        int num1 = Integer.parseInt(input1.getText().toString());
        int num2 = Integer.parseInt(input2.getText().toString());
        result.setText(Integer.toString(num1/num2));
    }
}

package mca.acharya.com.lab8;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    EditText filePath,fileContent;
    Button btnSave,btnRead;
    TextView resultView;

    private static final String FILE_NAME = "myfile.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filePath = (EditText) findViewById(R.id.editText1);
        fileContent = (EditText) findViewById(R.id.editText2);
        //Buttons
        btnSave = (Button) findViewById(R.id.btnSave);
        btnRead = (Button) findViewById(R.id.btnRead);
        //TextView for result
        resultView = (TextView) findViewById(R.id.resultView);
    }

    public void saveFile(View v){
        String text = fileContent.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());
            Toast.makeText(this, "File Saved", Toast.LENGTH_LONG).show();
            fos.close();
        } catch (Exception e) {

        }
    }

    public void load(View v) {
        FileInputStream fis = null;
        try {
            fis = openFileInput(FILE_NAME);
            Scanner sc = new Scanner(fis);
            // we just need to use \\Z as delimiter
            sc.useDelimiter("\\Z");
            resultView.setText(sc.next());
        } catch (Exception e) {

        }
    }
}

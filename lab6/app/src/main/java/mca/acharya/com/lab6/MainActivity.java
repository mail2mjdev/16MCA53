package mca.acharya.com.lab6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.button);
        btn2= (Button) findViewById(R.id.button2);
        img = (ImageView)findViewById(R.id.imageView);

        btn1.setOnClickListener(btn1Listner);
        btn2.setOnClickListener(btn2Listner);
    }

    private View.OnClickListener btn1Listner = new View.OnClickListener() {
        public void onClick(View v) {
            new Thread(new Runnable(){
                @Override
                public void run(){
                    img.post(new Runnable(){
                        public void run(){
                            img.setImageResource(R.drawable.img1);
                        }
                    });
                }
            }).start();
        }
    };
    private View.OnClickListener btn2Listner = new View.OnClickListener() {
        public void onClick(View v) {
            new Thread(new Runnable(){
                @Override
                public void run(){
                    img.post(new Runnable(){
                        public void run(){
                            img.setImageResource(R.drawable.img2);
                        }
                    });
                }
            }).start();
        }
    };
}



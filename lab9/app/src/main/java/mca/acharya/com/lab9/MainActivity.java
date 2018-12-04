package mca.acharya.com.lab9;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msg = (EditText) findViewById(R.id.textMsg);
    }
    public void showMessage(View v){

        Notification notification=new Notification.Builder(MainActivity.this)
                .setContentTitle("New Message!")
                .setContentText(msg.getText().toString())
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notification.flags |=Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0,notification);
    }
}

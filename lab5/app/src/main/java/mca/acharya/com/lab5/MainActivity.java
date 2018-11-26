package mca.acharya.com.lab5;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtId, txtName;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtId = (TextView) findViewById(R.id.editTextId);
        txtName = (TextView) findViewById(R.id.editTextName);

        db = openOrCreateDatabase("student_data",MODE_PRIVATE,null);
    }

    void addData(View v){
        String dataId = txtId.getText().toString();
        String dataName = txtName.getText().toString();
        db.execSQL("CREATE TABLE IF NOT EXISTS student(id INT,name VARCHAR);");
        try {
            db.execSQL("INSERT INTO student VALUES( ?, ? )", new String[]{dataId,dataName});
            showMessage("Insert Data","Success! Data Added");
        } catch (Exception ex){
            showMessage("Insert Data","Error Inserting Data");
        }

    }

    void viewData(View v){
        String searchByid = txtId.getText().toString();
        try{
            Cursor resultSet = db.rawQuery("Select * from student where id = ?"+searchByid,new String[]{searchByid});
            resultSet.moveToFirst();
            String idvalue = resultSet.getString(0);
            String namevalue = resultSet.getString(1);
            String resultString = "Id : "+idvalue + " \nName :"+namevalue;
            showMessage("View Result",resultString);
        } catch (Exception ex){
            showMessage("View Result","No such data");
        }

    }

    void deleteData(View v){
        String searchByid = txtId.getText().toString();
        try{

            db.delete("student","id=?", new String[]{searchByid});
            showMessage("Delete Result","Data Deleted");
        }
        catch (Exception ex){
            showMessage("Delete Result","No Such Data");
        }
    }
    void updateData(View v){
        String searchByid = txtId.getText().toString();
        String dataName = txtName.getText().toString();
        try{
            String strSQL = "UPDATE student SET name = '"+dataName+"' WHERE id = "+ searchByid;
            db.execSQL(strSQL);
            showMessage("Delete Result","Data Deleted");
        }
        catch (Exception ex){
            showMessage("Delete Result","No Such Data");
        }
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}

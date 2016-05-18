package com.example.abdul.ipl;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

public class MainActivity extends ActionBarActivity {

    private
    int RCBs,KKRs,MIs,GLs,SRHs;
    EditText RCBe;
    EditText MIe;
    EditText KKRe;
    EditText GLe;
    EditText SRHe;
    Button btn;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DBHelper(this);
        RCBe = (EditText) findViewById(R.id.rcbid);
        MIe = (EditText) findViewById(R.id.miid);
        KKRe = (EditText) findViewById(R.id.kkrid);
        GLe = (EditText) findViewById(R.id.glid);
        SRHe = (EditText) findViewById(R.id.srhid);
        btn = (Button) findViewById(R.id.button);
    }

    public void onClick1(View v){

        RCBs = Integer.valueOf (RCBe.getText().toString().trim());
        MIs = Integer.valueOf (MIe.getText().toString().trim());
        KKRs = Integer.valueOf (KKRe.getText().toString().trim());
        GLs = Integer.valueOf (GLe.getText().toString().trim());
        SRHs = Integer.valueOf (SRHe.getText().toString().trim());
        boolean isInserted=myDB.insertData(RCBs,MIs,KKRs,GLs,SRHs);
        if (isInserted){
            Toast.makeText(MainActivity.this,"DATA inserted",Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(MainActivity.this,"DATA not inserted",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, IplGraph.class);
        startActivity(intent);
    }
}

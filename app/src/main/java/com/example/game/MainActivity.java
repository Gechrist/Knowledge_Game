package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText edittext = findViewById(R.id.edtxt_name);
        final Button button = findViewById(R.id.btn_start);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= edittext.getText().toString();
             if ((name == null || name.isEmpty())){
                 final Dialog dialog = new Dialog(MainActivity.this);
                 dialog.setContentView(R.layout.dialog);

                 final TextView title = dialog.findViewById(R.id.dialog);
                 final Button btn_ok = dialog.findViewById(R.id.close_dialog);

                 btn_ok.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {

                         dialog.cancel();
                     }
                 });

              dialog.show();} else{Player player = new Player (name, 0);Intent intent = new Intent(MainActivity.this, GameActivity.class);
                 intent.putExtra("player", player);
                 startActivity(intent);}

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.top) {
           startActivity(new Intent(this, Top10Activity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}

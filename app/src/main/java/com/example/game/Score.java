package com.example.game;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;

public class Score extends AppCompatActivity {
    private SqlLiteHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        StatusBarUtil.setTransparent(this);

        Player player = getIntent().getParcelableExtra("player");
        TextView textView = findViewById(R.id.txtview_score);

        textView.setText(player.getName()+ ", το σκορ σου είναι \n" + player.getScore()+"/10");
        Questions_db db = new Questions_db(Score.this);
        db.open();
        SqlLiteHelper dbHelper = new SqlLiteHelper(this);
        dbHelper.insertscore(player.getName(), player.getScore());
        db.close();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
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
        if (id == R.id.main) {
            startActivity(new Intent(this, MainActivity.class));
        }
        if (id == R.id.restart) {
            Player player = getIntent().getParcelableExtra("player");
            player.setScore(0);
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("player", player);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
}

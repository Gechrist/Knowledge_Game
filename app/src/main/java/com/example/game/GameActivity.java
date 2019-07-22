package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{



    
    Player player = getIntent().getParcelableExtra("player");
   // Player player = new Player("dsdsds", 0);
    TextView txtview_question;
    TextView txtview_answer;
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;


    String[] id = {"10","1","2","3","4","5","6","7","8","9"};
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        this.txtview_question = findViewById(R.id.txtview_question);
        this.txtview_answer = findViewById(R.id.txtview_answer);
        this.buttonA = findViewById(R.id.btn_A);
        this.buttonB = findViewById(R.id.btn_B);
        this.buttonC = findViewById(R.id.btn_C);
        this.buttonD = findViewById(R.id.btn_D);
        Button[] btn = {buttonA, buttonB, buttonC, buttonD};
        shuffleArray(id);
        shuffleArrayB(btn);


        Questions question = new Questions();
        Questions_db db = new Questions_db(GameActivity.this);
        db.open();
        question = db.getQuestion(id[i]);
        db.close();
        this.txtview_question.setText(question.getQuestion());
        this.txtview_answer.setText(question.getCor_answer());
        btn[0].setText(question.getAnswer1());
        btn[0].setOnClickListener(this);
        btn[1].setText(question.getAnswer2());
        btn[1].setOnClickListener(this);
        btn[2].setText(question.getAnswer3());
        btn[2].setOnClickListener(this);
        btn[3].setText(question.getAnswer4());
        btn[3].setOnClickListener(this);


}
         public void populate(){
        Button[] btn = {buttonA, buttonB, buttonC, buttonD};
        shuffleArrayB(btn);
        Questions question = new Questions();
        Questions_db db = new Questions_db(GameActivity.this);
        db.open();
        question = db.getQuestion(id[i]);
        db.close();
        this.txtview_question.setText(question.getQuestion());
        this.txtview_answer.setText(question.getCor_answer());
        btn[0].setText(question.getAnswer1());
        btn[0].setOnClickListener(this);
        btn[0].setBackgroundResource(android.R.drawable.btn_default);
        btn[1].setText(question.getAnswer2());
        btn[1].setOnClickListener(this);
        btn[1].setBackgroundResource(android.R.drawable.btn_default);
        btn[2].setText(question.getAnswer3());
        btn[2].setOnClickListener(this);
        btn[2].setBackgroundResource(android.R.drawable.btn_default);
        btn[3].setText(question.getAnswer4());
        btn[3].setOnClickListener(this);
        btn[3].setBackgroundResource(android.R.drawable.btn_default);
    }

        static void shuffleArray(String[] id) {
        Random rnd = new Random();
        for (int i = id.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = id[index];
            id[index] = id[i];
            id[i] = a;
        }
    }

    static void shuffleArrayB(Button[] btn) {
        Random rnd = new Random();
        for (int i = btn.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Button a = btn[index];
            btn[index] = btn[i];
            btn[i] = a;
        }
    }

    @Override
    public void onClick(View view) {
        String answer = txtview_answer.getText().toString();
        String a = buttonA.getText().toString();
        String b = buttonB.getText().toString();
        String c = buttonC.getText().toString();
        String d = buttonD.getText().toString();
            switch(view.getId()){
                case R.id.btn_A: if(i == 9) {Intent intent = new Intent(this, Score.class); intent.putExtra("player", player); startActivity(intent);this.finish();} else if (a.equals(answer)) {buttonA.setBackgroundColor(Color.GREEN); player.setScore(player.getScore()+ 1);i = i + 1;populate();} else {buttonA.setBackgroundColor(Color.RED);i = i + 1;populate();} break;
                case R.id.btn_B: if(i == 9) {Intent intent = new Intent(this, Score.class); intent.putExtra("player", player); startActivity(intent);this.finish();} else if (b.equals(answer)) {buttonB.setBackgroundColor(Color.GREEN); player.setScore(player.getScore()+ 1);i = i + 1;populate();} else {buttonB.setBackgroundColor(Color.RED);i = i + 1;populate();} break;
                case R.id.btn_C: if(i == 9) {Intent intent = new Intent(this, Score.class); intent.putExtra("player", player); startActivity(intent);this.finish();} else if (c.equals(answer)) {buttonC.setBackgroundColor(Color.GREEN); player.setScore(player.getScore()+ 1);i = i + 1;populate();} else {buttonC.setBackgroundColor(Color.RED);i = i + 1;populate();} break;
                case R.id.btn_D: if(i == 9) {Intent intent = new Intent(this, Score.class); intent.putExtra("player", player); startActivity(intent);this.finish();} else if (d.equals(answer)) {buttonD.setBackgroundColor(Color.GREEN); player.setScore(player.getScore()+ 1);i = i + 1;populate();} else {buttonD.setBackgroundColor(Color.RED);i = i + 1;populate();} break;
            }

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
        if (id == R.id.restart) {
            startActivity(new Intent(this, MainActivity.class));
            this.finish();
        }


        return super.onOptionsItemSelected(item);
    }
}

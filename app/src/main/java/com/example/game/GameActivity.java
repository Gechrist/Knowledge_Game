package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;

import java.util.Random;


public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtview_question;
    TextView txtview_answer;
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;
    final Handler handler = new Handler();

    String[] id = {"10","1","2","3","4","5","6","7","8","9"};
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        StatusBarUtil.setTransparent(this);

        this.txtview_question = findViewById(R.id.txtview_question);
        this.txtview_answer = findViewById(R.id.txtview_answer);
        this.buttonA = findViewById(R.id.btn_A);
        this.buttonB = findViewById(R.id.btn_B);
        this.buttonC = findViewById(R.id.btn_C);
        this.buttonD = findViewById(R.id.btn_D);
        Button[] btn = {buttonA, buttonB, buttonC, buttonD};
        shuffleArray(id);

        populate();
}

         public void populate(){
        if (i == 10){return;}
        Button[] btn = {buttonA, buttonB, buttonC, buttonD};
        shuffleArray(btn);
        Questions question = new Questions();
        Questions_db db = new Questions_db(GameActivity.this);
        db.open();
        question = db.getQuestion(id[i]);
        db.close();
        this.txtview_question.setText(question.getQuestion());
        this.txtview_answer.setText(question.getCor_answer());
        btn[0].setText(question.getAnswer1());
        btn[0].setOnClickListener(this);
        btn[0].setBackgroundResource(R.color.button);
        btn[1].setText(question.getAnswer2());
        btn[1].setOnClickListener(this);
        btn[1].setBackgroundResource(R.color.button);
        btn[2].setText(question.getAnswer3());
        btn[2].setOnClickListener(this);
        btn[2].setBackgroundResource(R.color.button);
        btn[3].setText(question.getAnswer4());
        btn[3].setOnClickListener(this);
        btn[3].setBackgroundResource(R.color.button);
    }

        static void shuffleArray(Object[] id) {
        Random rnd = new Random();
        for (int i = id.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Object a = id[index];
            id[index] = id[i];
            id[i] = a;
        }
    }

    @Override
    public void onClick(View view) {
        Player player = getIntent().getParcelableExtra("player");
        Intent intent = new Intent(this, Score.class);
        intent.putExtra("player", player);
        String answer = txtview_answer.getText().toString();
        String a = buttonA.getText().toString();
        String b = buttonB.getText().toString();
        String c = buttonC.getText().toString();
        String d = buttonD.getText().toString();


            switch(view.getId()){
                case R.id.btn_A:  if (a.equals(answer)) {buttonA.setBackgroundColor(Color.GREEN); player.setScore(player.getScore()+ 1);i = i + 1;if(i == 10) {startActivity(intent); this.finish();}
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            populate();
                        }
                    }, 300);


                } else {buttonA.setBackgroundColor(Color.RED);i = i + 1;if(i == 10) {startActivity(intent); this.finish();}

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            populate();
                        }
                    }, 300);

                } break;
                case R.id.btn_B: if (b.equals(answer)) {buttonB.setBackgroundColor(Color.GREEN); player.setScore(player.getScore()+ 1);i = i + 1;if(i == 10) {startActivity(intent); this.finish();}handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        populate();
                    }
                }, 300);} else {buttonB.setBackgroundColor(Color.RED);i = i + 1;if(i == 10) {startActivity(intent); this.finish();}handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        populate();
                    }
                }, 300);}break;
                case R.id.btn_C: if (c.equals(answer)) {buttonC.setBackgroundColor(Color.GREEN); player.setScore(player.getScore()+ 1);i = i + 1;if(i == 10) {startActivity(intent); this.finish();}handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        populate();
                    }
                }, 300);} else {buttonC.setBackgroundColor(Color.RED);i = i + 1;if(i == 10) {startActivity(intent); this.finish();}handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        populate();
                    }
                }, 300);} break;
                case R.id.btn_D:  if (d.equals(answer)) {buttonD.setBackgroundColor(Color.GREEN); player.setScore(player.getScore()+ 1);i = i + 1;if(i == 10) {startActivity(intent); this.finish();}handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        populate();
                    }
                }, 300);} else {buttonD.setBackgroundColor(Color.RED);i = i + 1;if(i == 10) {startActivity(intent); this.finish();}handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        populate();
                    }
                }, 300);} break;
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
            this.finish();
        }
        if (id == R.id.main) {
            startActivity(new Intent(this, MainActivity.class));
            this.finish();
        }
        if (id == R.id.restart) {
            Player player = getIntent().getParcelableExtra("player");
            player.setScore(0);
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("player", player);
            startActivity(intent);
            this.finish();
        }


        return super.onOptionsItemSelected(item);
    }
}

package com.example.game;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;



import java.util.ArrayList;

public class Questions_db {

    private SQLiteDatabase database;
    private SqlLiteHelper dbHelper;

    private String[] allColumns = {SqlLiteHelper.COLUMN_ID, SqlLiteHelper.COLUMN_QUESTION, SqlLiteHelper.COLUMN_ANSWER1, SqlLiteHelper.COLUMN_ANSWER2,SqlLiteHelper.COLUMN_ANSWER3, SqlLiteHelper.COLUMN_ANSWER4, SqlLiteHelper.COLUMN_CORANSWER};

    public Questions_db(Context context){dbHelper = new SqlLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public ArrayList<Player> get10(){
        ArrayList<Player> players = new ArrayList<>();

     String[] allColumns = {SqlLiteHelper.SCORE_COLUMN_NAME, SqlLiteHelper.SCORE_COLUMN_SCORE};

        Cursor cursor = database.query(SqlLiteHelper.TABLE_SCORE, allColumns, null, null, null, null, SqlLiteHelper.SCORE_COLUMN_SCORE + " DESC","10");

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Player player = new Player();
            player.setName(cursor.getString(0));
            player.setScore(cursor.getInt(1));
            players.add(player);

            cursor.moveToNext();
        }

        return players;
    }

    public  Questions getQuestion(String id){
        Questions question = new Questions();

        Cursor cursor = database.query(SqlLiteHelper.TABLE_QUESTIONS, allColumns, "id=?", new String[]{id}, null, null, null);

        cursor.moveToFirst();
        question.setId(Integer.valueOf(id));
        question.setQuestion(cursor.getString(1));
        question.setAnswer1(cursor.getString(2));
        question.setAnswer2(cursor.getString(3));
        question.setAnswer3(cursor.getString(4));
        question.setAnswer4(cursor.getString(5));
        question.setCor_answer(cursor.getString(6));

        return question;
    }
}



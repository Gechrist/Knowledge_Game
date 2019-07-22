package com.example.game;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public class SqlLiteHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "gamequestions.db";
        private static final int DATABASE_VERSION = 1;

        public static final String TABLE_QUESTIONS = "questions";
        public static final String COLUMN_ID= "id";
        public static final String COLUMN_QUESTION= "question";
        public static final String COLUMN_ANSWER1= "answer1";
        public static final String COLUMN_ANSWER2= "answer2";
        public static final String COLUMN_ANSWER3= "answer3";
        public static final String COLUMN_ANSWER4= "answer4";
        public static final String COLUMN_CORANSWER= "cor_answer";
        public static final String TABLE_SCORE= "score";
        public static final String SCORE_COLUMN_ID= "id";
        public static final String SCORE_COLUMN_NAME= "name";
        public static final String SCORE_COLUMN_SCORE= "score";


        public SqlLiteHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {

            String sql = "CREATE TABLE "+TABLE_QUESTIONS+" ( " +
                    COLUMN_ID+" integer primary key autoincrement, "+
                    COLUMN_QUESTION+" text not null, "+
                    COLUMN_ANSWER1+" text not null,"+
                    COLUMN_ANSWER2+" text not null,"+
                    COLUMN_ANSWER3+" text not null,"+
                    COLUMN_ANSWER4+" text not null,"+
                    COLUMN_CORANSWER+" text not null)";
            db.execSQL(sql);

            ContentValues values = new ContentValues();
            values.put(COLUMN_QUESTION, "Ποια σημασία έχει λάβει η 'Νεφελοκοκκυγία' του Αριστοφάνη στην αγγλική γλώσσα;");
            values.put(COLUMN_ANSWER1, "Είναι ο ύπνος με τα μάτια ανοιχτά");
            values.put(COLUMN_ANSWER2, "Είναι η θραύση του γυαλιού με τη φωνή σου");
            values.put(COLUMN_ANSWER3, "Είναι η αναζήτηση σχημάτων στα σύννεφα");
            values.put(COLUMN_ANSWER4, "Είναι το κολύμπι σε παγωμένα νερά");
            values.put(COLUMN_CORANSWER, "Είναι η αναζήτηση σχημάτων στα σύννεφα");
            db.insert(TABLE_QUESTIONS, null, values);

            values = new ContentValues();
            values.put(COLUMN_QUESTION, "Ποιο έντομο δημιούργησε επιπλοκές σε έναν απ' τους πρώτους υπερυπολογιστές, εξ ου και ο όρος 'computer bug';");
            values.put(COLUMN_ANSWER1, "Μία μύγα");
            values.put(COLUMN_ANSWER2, "Μία κατσαρίδα");
            values.put(COLUMN_ANSWER3, "Ένα ιαπωνικό σκαθάρι");
            values.put(COLUMN_ANSWER4, "Ένας σκόρος");
            values.put(COLUMN_CORANSWER, "Ένας σκόρος");
            db.insert(TABLE_QUESTIONS, null, values);

            values = new ContentValues();
            values.put(COLUMN_QUESTION, "Ποιος από τους παρακάτω άνδρες δεν έχει κάποιο χημικό στοιχείο ονομασμένο προς τιμήν του;");
            values.put(COLUMN_ANSWER1, "Ο Albert Einstein");
            values.put(COLUMN_ANSWER2, "O Enrico Fermi");
            values.put(COLUMN_ANSWER3, "O Isaac Newton");
            values.put(COLUMN_ANSWER4, "O Niels Bohr");
            values.put(COLUMN_CORANSWER, "O Isaac Newton");
            db.insert(TABLE_QUESTIONS, null, values);

            values = new ContentValues();
            values.put(COLUMN_QUESTION, "To φινάλε της σειράς M*A*S*H* έχει το ρεκόρ μεγαλύτερης θεαματικότητας επεισοδίου στην Αμερική. Μετά από ποια κωμωδία προβλήθηκε;");
            values.put(COLUMN_ANSWER1, "Alice");
            values.put(COLUMN_ANSWER2, "Newhart");
            values.put(COLUMN_ANSWER3, "Private Benjamin");
            values.put(COLUMN_ANSWER4, "Square Pegs");
            values.put(COLUMN_CORANSWER, "Alice");
            db.insert(TABLE_QUESTIONS, null, values);

            values = new ContentValues();
            values.put(COLUMN_QUESTION, "Ποια περίκλειστη χώρα βρίσκεται εξ ολοκλήρου εντός άλλης χώρας;");
            values.put(COLUMN_ANSWER1, "Το Λεσότο");
            values.put(COLUMN_ANSWER2, "Η Μογγολία");
            values.put(COLUMN_ANSWER3, "Η Μπουρκίνα Φάσο");
            values.put(COLUMN_ANSWER4, "Το Λουξεμβούργο");
            values.put(COLUMN_CORANSWER, "Το Λεσότο");
            db.insert(TABLE_QUESTIONS, null, values);

            values = new ContentValues();
            values.put(COLUMN_QUESTION, "Αν φυτέψεις Quercus robur, τι θα φυτρώσει;");
            values.put(COLUMN_ANSWER1, "Λουλούδι");
            values.put(COLUMN_ANSWER2, "Δέντρο");
            values.put(COLUMN_ANSWER3, "Λαχανικά");
            values.put(COLUMN_ANSWER4, "Σιτηρά");
            values.put(COLUMN_CORANSWER, "Δέντρο");
            db.insert(TABLE_QUESTIONS, null, values);

            values = new ContentValues();
            values.put(COLUMN_QUESTION, "Ποιος μποξέρ έγινε διάσημος χτυπώντας το gong στην έναρξη των ταινιών του Arthur Rank;");
            values.put(COLUMN_ANSWER1, "O Freddie Mills");
            values.put(COLUMN_ANSWER2, "O Bombardier Billy Wells");
            values.put(COLUMN_ANSWER3, "O Terry Spinks");
            values.put(COLUMN_ANSWER4, "O Don Cockell");
            values.put(COLUMN_CORANSWER, "O Bombardier Billy Wells");
            db.insert(TABLE_QUESTIONS, null, values);

            values = new ContentValues();
            values.put(COLUMN_QUESTION, "Το αμερικανικό σύμβολο του Uncle Sam βασίζεται στον αληθινό Samuel Wilson. Ως τι δούλευε ο Wilson στον Πόλεμο του 1812;");
            values.put(COLUMN_ANSWER1, "Επιθεωρητής ποιότητας κρεάτων");
            values.put(COLUMN_ANSWER2, "Μηχανικός όπλων");
            values.put(COLUMN_ANSWER3, "Ιστορικός");
            values.put(COLUMN_ANSWER4, "Ταχυδρόμος");
            values.put(COLUMN_CORANSWER, "Επιθεωρητής ποιότητας κρεάτων");
            db.insert(TABLE_QUESTIONS, null, values);

            values = new ContentValues();
            values.put(COLUMN_QUESTION, "Ποιον χρησιμοποίησε ως μοντέλο ο Grant Wood για τον διάσημο πίνακά του 'American Gothic';");
            values.put(COLUMN_ANSWER1, "Έναν πλανόδιο πωλητή");
            values.put(COLUMN_ANSWER2, "Τον τοπικό σερίφη");
            values.put(COLUMN_ANSWER3, "Τον οδοντίατρό του");
            values.put(COLUMN_ANSWER4, "Τον χασάπη του");
            values.put(COLUMN_CORANSWER, "Τον οδοντίατρό του");
            db.insert(TABLE_QUESTIONS, null, values);

            values = new ContentValues();
            values.put(COLUMN_QUESTION, "Τι απεικονίζεται πάνω στο οδικό σήμα που ειδοποιεί για την ύπαρξη εστιατορίου;");
            values.put(COLUMN_ANSWER1, "Πιρούνι δίπλα σε μαχαίρι");
            values.put(COLUMN_ANSWER2, "Πιρούνι δίπλα σε κουτάλι");
            values.put(COLUMN_ANSWER3, "Πιρούνι-μαχαίρι χιαστί");
            values.put(COLUMN_ANSWER4, "Πιρούνι-κουτάλι χιαστί");
            values.put(COLUMN_CORANSWER, "Πιρούνι-κουτάλι χιαστί");
            db.insert(TABLE_QUESTIONS, null, values);

            String sql2 = "CREATE TABLE "+TABLE_SCORE+" ( " +
                    SCORE_COLUMN_ID+" integer primary key autoincrement, "+
                    SCORE_COLUMN_NAME+" text not null, "+
                    SCORE_COLUMN_SCORE+" text not null)";
            db.execSQL(sql2);

        }

       public void insertscore(String name, int score){


        ContentValues contentValues = new ContentValues();

        contentValues.put(SCORE_COLUMN_NAME, name);
        contentValues.put(SCORE_COLUMN_SCORE, score);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_SCORE, null, contentValues);}



        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        }
    }



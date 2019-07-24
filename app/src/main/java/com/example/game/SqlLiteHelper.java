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
            values.put(COLUMN_ANSWER1, "Ειναι ο υπνος με τα ματια ανοιχτα");
            values.put(COLUMN_ANSWER2, "Ειναι η θραυση του γυαλιού με τη φωνη σου");
            values.put(COLUMN_ANSWER3, "Ειναι η αναζητηση σχηματων στα συννεφα");
            values.put(COLUMN_ANSWER4, "Ειναι το κολυμπι σε παγωμενα νερα");
            values.put(COLUMN_CORANSWER, "Ειναι η αναζητηση σχηματων στα συννεφα");
            db.insert(TABLE_QUESTIONS, null, values);

            values = new ContentValues();
            values.put(COLUMN_QUESTION, "Ποιο έντομο δημιούργησε επιπλοκές σε έναν απ' τους πρώτους υπερυπολογιστές, εξ ου και ο όρος 'computer bug';");
            values.put(COLUMN_ANSWER1, "Μια μυγα");
            values.put(COLUMN_ANSWER2, "Μια κατσαριδα");
            values.put(COLUMN_ANSWER3, "Ενα ιαπωνικο σκαθαρι");
            values.put(COLUMN_ANSWER4, "Ενας σκορος");
            values.put(COLUMN_CORANSWER, "Ενας σκορος");
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
            values.put(COLUMN_ANSWER1, "Το Λεσοτο");
            values.put(COLUMN_ANSWER2, "Η Μογγολια");
            values.put(COLUMN_ANSWER3, "Η Μπουρκινα Φασο");
            values.put(COLUMN_ANSWER4, "Το Λουξεμβουργο");
            values.put(COLUMN_CORANSWER, "Το Λεσοτο");
            db.insert(TABLE_QUESTIONS, null, values);

            values = new ContentValues();
            values.put(COLUMN_QUESTION, "Αν φυτέψεις Quercus robur, τι θα φυτρώσει;");
            values.put(COLUMN_ANSWER1, "Λουλουδι");
            values.put(COLUMN_ANSWER2, "Δεντρο");
            values.put(COLUMN_ANSWER3, "Λαχανικα");
            values.put(COLUMN_ANSWER4, "Σιτηρα");
            values.put(COLUMN_CORANSWER, "Δεντρο");
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
            values.put(COLUMN_ANSWER1, "Επιθεωρητης ποιοτητας κρεατων");
            values.put(COLUMN_ANSWER2, "Μηχανικος οπλων");
            values.put(COLUMN_ANSWER3, "Ιστορικος");
            values.put(COLUMN_ANSWER4, "Ταχυδρομος");
            values.put(COLUMN_CORANSWER, "Επιθεωρητης ποιοτητας κρεατων");
            db.insert(TABLE_QUESTIONS, null, values);

            values = new ContentValues();
            values.put(COLUMN_QUESTION, "Ποιον χρησιμοποίησε ως μοντέλο ο Grant Wood για τον διάσημο πίνακά του 'American Gothic';");
            values.put(COLUMN_ANSWER1, "Εναν πλανοδιο πωλητη");
            values.put(COLUMN_ANSWER2, "Τον τοπικο σεριφη");
            values.put(COLUMN_ANSWER3, "Τον οδοντιατρο του");
            values.put(COLUMN_ANSWER4, "Τον χασαπη του");
            values.put(COLUMN_CORANSWER, "Τον οδοντιατρο του");
            db.insert(TABLE_QUESTIONS, null, values);

            values = new ContentValues();
            values.put(COLUMN_QUESTION, "Τι απεικονίζεται πάνω στο οδικό σήμα που ειδοποιεί για την ύπαρξη εστιατορίου;");
            values.put(COLUMN_ANSWER1, "Πιρουνι διπλα σε μαχαιρι");
            values.put(COLUMN_ANSWER2, "Πιρουνι διπλα σε κουταλι");
            values.put(COLUMN_ANSWER3, "Πιρουνι-μαχαιρι χιαστι");
            values.put(COLUMN_ANSWER4, "Πιρουνι-κουταλι χιαστι");
            values.put(COLUMN_CORANSWER, "Πιρουνι-κουταλι χιαστι");
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



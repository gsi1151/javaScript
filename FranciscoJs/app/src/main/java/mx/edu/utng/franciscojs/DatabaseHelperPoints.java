package mx.edu.utng.franciscojs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperPoints extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Answers.db";


    private static final String TABLE_NAME_POINTS = "Puntaje";
    private static final String COLUMN_POINTS_ID = "id";
    private static final String COLUMN_POINTS = "points";

    private static final String TABLE_NAME_LOCK = "Bloqueo";
    private static final String COLUMN_LOCK_ID = "id";
    private static final String COLUMN_LOCK = "lock";

    private static final String TABLE_NAME_TEME = "Temas";
    private static final String COLUMN_TEME_ID = "id";
    private static final String COLUMN_TEME = "teme";

    SQLiteDatabase db;

    private static final String TABLE_CREATE_TEME = "CREATE TABLE "+ TABLE_NAME_TEME +"(" +
            COLUMN_TEME_ID +" INTEGER PRIMARY KEY NOT NULL, "+
            COLUMN_TEME +" INTEGER NOT NULL"+");";

    private static final String TABLE_CREATE_CUATRO = "CREATE TABLE "+ TABLE_NAME_LOCK +"(" +
            COLUMN_LOCK_ID +" INTEGER PRIMARY KEY NOT NULL, "+
            COLUMN_LOCK +" INTEGER NOT NULL"+");";

    private static final String TABLE_CREATE_TRES = "CREATE TABLE "+ TABLE_NAME_POINTS +"(" +
            COLUMN_POINTS_ID +" INTEGER PRIMARY KEY NOT NULL, "+
            COLUMN_POINTS +" INTEGER NOT NULL"+");";


    public DatabaseHelperPoints(Context context){
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_TRES);
        db.execSQL(TABLE_CREATE_CUATRO);
        db.execSQL(TABLE_CREATE_TEME);

        db.execSQL("INSERT INTO " + TABLE_NAME_LOCK + " VALUES (1,1)");
        db.execSQL("INSERT INTO " + TABLE_NAME_TEME + " VALUES (1,1)");

        db.execSQL("INSERT INTO " + TABLE_NAME_POINTS + " VALUES (1,0)");
        db.execSQL("INSERT INTO " + TABLE_NAME_POINTS + " VALUES (2,0)");
        db.execSQL("INSERT INTO " + TABLE_NAME_POINTS + " VALUES (3,0)");
        db.execSQL("INSERT INTO " + TABLE_NAME_POINTS + " VALUES (4,0)");
        db.execSQL("INSERT INTO " + TABLE_NAME_POINTS + " VALUES (5,0)");
    }

    public  int  traerResult(int id){
        db = this.getReadableDatabase();
        String selectQuery =  "SELECT "+ COLUMN_POINTS +" FROM "+ TABLE_NAME_POINTS +" where id="+id;
        Cursor cursor = db.rawQuery(selectQuery, null);
        int score=0;
        if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        score = cursor.getInt(0);
                    } while (cursor.moveToNext());
                }
            }
        return score;
    }

    public  int  bloqueo (){
        db = this.getReadableDatabase();
        String selectQuery =  "SELECT "+ COLUMN_LOCK +" FROM "+ TABLE_NAME_LOCK ;
        Cursor cursor = db.rawQuery(selectQuery, null);
        int score=0;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    score = cursor.getInt(0);
                } while (cursor.moveToNext());
            }
        }
        return score;
    }

    public void actualizarQuiz(int re, int numQuiz){
        db = this.getWritableDatabase();
        String selectQuery =  "SELECT "+ COLUMN_POINTS +" FROM "+ TABLE_NAME_POINTS +" where id="+numQuiz;
        Cursor cursor = db.rawQuery(selectQuery, null);
        int score=0;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    score = cursor.getInt(0);
                    if(score<re){
                        //Actualizamos el registro en la base de datos
                        db.execSQL("UPDATE "+ TABLE_NAME_POINTS +" SET "+ COLUMN_POINTS +
                                " = "+re+" WHERE id = "+numQuiz);
                        db.close();
                    }
                } while (cursor.moveToNext());
            }
        }
    }

    public void actualizarBloqueo(int date){

        db = this.getWritableDatabase();
        String selectQuery =  "SELECT "+ COLUMN_LOCK +" FROM "+ TABLE_NAME_LOCK ;
        Cursor cursor = db.rawQuery(selectQuery, null);
        int score=0;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    score = cursor.getInt(0);
                    if(score<date){
                        //Actualizamos el registro en la base de datos
                        db.execSQL("UPDATE "+ TABLE_NAME_LOCK +" SET "+ COLUMN_LOCK +
                                " = "+date+" WHERE id = 1");
                        db.close();
                    }
                } while (cursor.moveToNext());
            }
        }
    }

    public  int  tema (){
        db = this.getReadableDatabase();
        String selectQuery =  "SELECT "+ COLUMN_TEME +" FROM "+ TABLE_NAME_TEME ;
        Cursor cursor = db.rawQuery(selectQuery, null);
        int score=0;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    score = cursor.getInt(0);
                } while (cursor.moveToNext());
            }
        }
        return score;
    }
    public void actualizarTema(int date){

        db = this.getWritableDatabase();
        //Actualizamos el registro en la base de datos
        db.execSQL("UPDATE "+ TABLE_NAME_TEME +" SET "+ COLUMN_TEME +
                " = "+date+" WHERE id = 1");
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS "+ TABLE_NAME_POINTS;
        String query1 = "DROP TABLE IF EXISTS "+ TABLE_NAME_LOCK;
        String query2 = "DROP TABLE IF EXISTS "+ TABLE_NAME_TEME;
        db.execSQL(query);
        db.execSQL(query1);
        db.execSQL(query2);
        if ( newVersion > oldVersion )
        {
            db.execSQL( "DROP TABLE IF EXISTS Eleccion" );
        }
        this.onCreate(db);
    }

    public int porsentajeCurso(){
        int q1 =traerResult(1);
        int q2 =traerResult(2);
        int q3 =traerResult(3);
        int q4 =traerResult(4);
        int q5 =traerResult(5);
        int suma;
        int porsentaje;
        suma= q1+q2+q3+q4+q5;
        porsentaje= suma/5;
        return porsentaje;
    }
}


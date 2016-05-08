package mx.edu.utng.franciscojs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Erika Cabrera on 29/02/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";

    private static final String TABLE_NAME_DOS = "answers";
    private static final String COLUMN_ANSWER_ID = "id";
    private static final String COLUMN_ANSWER = "answer";
    private static final String COLUMN_RESPONSE = "response";

    SQLiteDatabase db;

    private static final String TABLE_CREATE_DOS = "CREATE TABLE "+TABLE_NAME_DOS+"(" +
            COLUMN_ANSWER_ID+" INTEGER PRIMARY KEY NOT NULL, "+
            COLUMN_ANSWER+" TEXT NOT NULL, "+
            COLUMN_RESPONSE+" TEXT NOT NULL"+");";

    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null , " +
            "name text not null , email text not null , uname text not null , pass text not null);";

    public DatabaseHelper(Context context){
        super(context , DATABASE_NAME , null , DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE_DOS);
        this.db = db;

    }

    public void insertContact(Contact c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_PASS, c.getPass());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String uname){
        db = this.getReadableDatabase();

        String query= "select uname, pass from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if(a.equals(uname)){
                    b = cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return b;

    }

    public String searchResponse(String response){
        db = this.getReadableDatabase();
        String query= "select "+
                COLUMN_ANSWER+", "+
                COLUMN_RESPONSE+" from "+
                TABLE_NAME_DOS;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if(a.equals(response)){
                    b = cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return b;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }


    public  String  traerEmail(){
        db = this.getReadableDatabase();
        String email="";
        String selectQuery = "SELECT  email FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                //int id= re.setIdResult(cursor.getInt(0));
                email = contact.setEmail(cursor.getString(0));

                return email;
            } while (cursor.moveToNext());
        }
        return email;
    }
    public  String  traerNombre(){
        db = this.getReadableDatabase();
        String name="";
        String selectQuery = "SELECT name FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                //int id= re.setIdResult(cursor.getInt(0));
                name = contact.setEmail(cursor.getString(0));

                return name;
            } while (cursor.moveToNext());
        }
        return name;
    }
}

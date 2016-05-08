package mx.edu.utng.franciscojs.answers.practicas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.franciscojs.answers.Question;


public class QuizPracticas extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "juo";
	// tasks table name
	private static final String TABLE_QUEST = "quest";
	// tasks Table Columns names
	private static final String KEY_ID = "qid";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; // respuesta correcta
	private static final String KEY_OPTA = "opta"; // opcion a
	private static final String KEY_OPTB = "optb"; // opcion b
	private static final String KEY_OPTC = "optc"; // opcion c

	private SQLiteDatabase dbase;

	public QuizPracticas(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase = db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
				+ KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
		db.execSQL(sql);
		addQuestion();
		// db.close();
	}

	private void addQuestion() {
		Question q1 = new Question("¿Cuál es el resultado del siguiente código\n" +
				"<!DOCTYPE html>\n" +
				"<html>\n" +
				"<body>\n" +
				"\n" +
				"<h1>My First Web Page</h1>\n" +
				"<p>My first paragraph.</p>\n" +
				"\n" +
				"<script>\n" +
				"window.alert(5 + 6);\n" +
				"</script>\n" +
				"\n" +
				"</body>\n" +
				"</html><!DOCTYPE html>\n" +
				"<html>\n" +
				"<body>\n" +
				"\n" +
				"<h1>My First Web Page</h1>\n" +
				"<p>My first paragraph.</p>\n" +
				"\n" +
				"<script>\n" +
				"window.alert(5 + 6);\n" +
				"</script>\n" +
				"\n" +
				"</body>\n" +
				"</html>?",
				"8",
				"11", "Error",
				"11");
		this.addQuestion(q1);

		Question q2 = new Question("El siguiente código es correcto ¿Y cuál es el resultado?\n" +
				"\n" +
				"<html>\n" +
				"<body>\n" +
				"\n" +
				"<p>This example calls a function which performs a calculation, and returns the result:</p>\n" +
				"\n" +
				"<p id=\"demo\"></p>\n" +
				"\n" +
				"<script>\n" +
				"function myFunction(a, b) {\n" +
				"    return a * b;\n" +
				"}\n" +
				"document.getElementById(\"demo\").innerHTML = myFunction(4, 3);\n" +
				"</script>\n" +
				"\n" +
				"</body>\n" +
				"</html>",
				"Si es correcto y el resultado es 12",
				"Si es correcto y el resultado es 9", "Marcara error por que falta la etiqueta <!DOCTYPE html>",
				"Marcara error por que falta la etiqueta <!DOCTYPE html>");
		this.addQuestion(q2);

		Question q3 = new Question("Si oprimo el numero 4¿Cuál sera el resultado del siguiente código\n?" +
				"<!DOCTYPE html>\n" +
				"<html>\n" +
				"<body>\n" +
				"\n" +
				"<p id=\"demo\"></p>\n" +
				"\n" +
				"<script>\n" +
				"var day;\n" +
				"switch (new Date().getDay()) {\n" +
				"    case 0:\n" +
				"        day = \"Sunday\";\n" +
				"        break;\n" +
				"    case 1:\n" +
				"        day = \"Monday\";\n" +
				"        break;\n" +
				"    case 2:\n" +
				"        day = \"Tuesday\";\n" +
				"        break;\n" +
				"    case 3:\n" +
				"        day = \"Wednesday\";\n" +
				"        break;\n" +
				"    case 4:\n" +
				"        day = \"Thursday\";\n" +
				"        break;\n" +
				"    case 5:\n" +
				"        day = \"Friday\";\n" +
				"        break;\n" +
				"}\n" +
				"document.getElementById(\"demo\").innerHTML = \"Today is \" + day;\n" +
				"</script>\n" +
				"\n" +
				"</body>\n" +
				"</html>\n",
				"Friday",
				"Saturday", "Thursday",
				"Thursday");
		this.addQuestion(q3);


		Question q4 = new Question("¿Cuál es el resultado del siguiente código?\n" +
				"<!DOCTYPE html>\n" +
				"<html>\n" +
				"<body>\n" +
				"\n" +
				"<p id=\"demo\"></p>\n" +
				"\n" +
				"<script>\n" +
				"\n" +
				"var carName1 = \"Volvo XC60\";\n" +
				"var carName2 = 'Volvo XC60';\n" +
				"\n" +
				"document.getElementById(\"demo\").innerHTML =\n" +
				"carName1 + \"<br>\" + carName2; \n" +
				"\n" +
				"</script>\n" +
				"\n" +
				"</body>\n" +
				"</html>\n",
				"carName2",
				"Volovo XC60\n", "Volovo XC60" +
				"Volovo XC60",
				"Volovo XC60\n" +
						"Volovo XC60");
		this.addQuestion(q4);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		// Create tables again
		onCreate(db);
	}

	// Adding new question
	public void addQuestion(Question quest) {
		// SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());

		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);
	}

	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT * FROM " + TABLE_QUEST;
		dbase = this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setOPTC(cursor.getString(5));

				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}


}

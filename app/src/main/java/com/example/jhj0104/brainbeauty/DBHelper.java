package com.example.jhj0104.brainbeauty;

/**
 * Created by jhj0104 on 2016-11-15.
 */

public class DBHelper extends SQLiteOpenHelper {
// DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음

    public DBHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    // DB를 새로 생성할 때 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블 생성
        //db.execSQL("CREATE TABLE DO_LIST_DB (_id INTEGER PRIMARY KEY AUTOINCREMENT, DL_YEAR TEXT, DL_MONTH TEXT, DL_DAY TEXT, DL_TITLE TEXT, DL_CONTENT TEXT, DL_FLAG TEXT");
        db.execSQL("CREATE TABLE DO_LIST_DB (_id INTEGER PRIMARY KEY AUTOINCREMENT, DL_YMD TEXT, DL_TITLE TEXT, DL_CONTENT TEXT, DL_FLAG TEXT");
    }

    public void insert_DO_LIST_DB(String DL_YMD, String DL_TITLE, String DL_CONTENT, Boolean DL_FLAG) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO DO_LIST_DB VALUES(null, '" + DL_YMD + "','" + DL_TITLE + "','" + DL_CONTENT + "', '" + DL_FLAG + "');");
        db.close();
    }

    public void delete_DO_LIST_DB(String DL_YMD, String DL_TITLE) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM DO_LIST_DB WHERE DL_YMD=" + DL_YMD + "AND DL_TITLE=" + DL_TITLE + "';");
        db.close();
    }

    //update_DO_LIST_DB는 함수가 나뉘어 타이틀과 내용을 각각 수정하게 될 수도 있음.
    public void update_DO_LIST_DB(String DL_YMD, String DL_id, String DL_TITLE, String DL_CONTENT) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE DO_LIST_DB SET DL_TITLE=" + DL_TITLE + "AND DL_CONTENT" + DL_CONTENT + " WHERE DL_YMD='" + DL_YMD + "';");
        db.close();
    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

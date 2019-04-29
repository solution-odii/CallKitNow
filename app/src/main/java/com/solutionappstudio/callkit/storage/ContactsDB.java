package com.solutionappstudio.callkit.storage;

/**
 * Created by ODII on 12/29/2018.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import com.solutionappstudio.callkit.others.Contacts;


/**
 * Created by ODII on 11/20/2018.
 */

public class ContactsDB extends SQLiteOpenHelper{

    public ContactsDB(Context context) {
        super(context, "ContactsDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createContactsQuery="" +
                "CREATE table if not exists GroupContacts(" +
                "gcId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "contactsGroupId int not null," +
                "gcName text not null," +
                "gcNumber text not null" +
                ")" +
                "";
        db.execSQL(createContactsQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropGroupQuery="" +
                "DROP table if exists ContactsGroup" +
                "";
        String dropContactsQuery="" +
                "DROP table if exists GroupContacts" +
                "";
        db.execSQL(dropGroupQuery);
        db.execSQL(dropContactsQuery);
        onCreate(db);
    }

    public boolean addContact(Contacts c, String groupId ){
        SQLiteDatabase sdb = this.getWritableDatabase();
        try{
            ContentValues cv = new ContentValues();
            cv.put("contactsGroupId", "" + groupId);
            cv.put("gcName", "" + c.getName() );
            cv.put("gcNumber", "" + c.getNumber());
            long a =sdb.insert("GroupContacts", null, cv);
            sdb.close();
            return a>0;
        }catch (Exception e){
            return false;
        }
    }

    public ArrayList<Contacts> getContacts(String contactsGroupId){
        SQLiteDatabase sdb = this.getReadableDatabase();
        Cursor csr = sdb.rawQuery("SELECT * FROM GroupContacts WHERE contactsGroupId=? ORDER BY gcName ASC", new String[]{contactsGroupId});
        ArrayList<Contacts> contacts = new ArrayList<>();
        if(csr.moveToFirst()){
            do{
                String index = csr.getString(csr.getColumnIndex("gcId"));
                String name = csr.getString(csr.getColumnIndex("gcName"));
                String number = csr.getString(csr.getColumnIndex("gcNumber"));
                contacts.add(new Contacts(index, name, number));
            }while (csr.moveToNext());
        }
        sdb.close();
        return contacts;
    }

    public boolean deleteContact(String index){
        try{
            SQLiteDatabase sdb = this.getReadableDatabase();
            sdb.delete("GroupContacts", "gcId=?", new String[]{index});
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

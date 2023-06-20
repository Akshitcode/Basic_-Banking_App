package com.example.basicbankingapp.ModelForUserDataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.basicbankingapp.UsersActivity;

import java.util.ArrayList;

public class UsersDataBase extends SQLiteOpenHelper {



    private static final String DATABASE_NAME = "userDatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String USERS_TABLE = "Users";
    private static final String ACCOUNT_KEY = "accountId";
    private static final String NAME_KEY = "name";
    private static final String BALANCE_KEY = "balance";
    private static final String PHONE_KEY = "phoneNumber";

    public UsersDataBase (Context context) {

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String createDatabaseSQL = "create table " + USERS_TABLE +
                "(" +  NAME_KEY + " text" + ", " +
                ACCOUNT_KEY + " integer " + ", " +
                PHONE_KEY+ " integer" +"," +
                BALANCE_KEY + " real" + " )";
        db.execSQL(createDatabaseSQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if EXISTS " + USERS_TABLE);
        onCreate(db);
    }

    public void addUserToDatabase () {

        SQLiteDatabase database = getWritableDatabase();
        String addUserToDatabaseSQLCommand = "insert into " + USERS_TABLE + " values('Abhishek Singh','789654163653', '7827436340','45556.3')";

        database.execSQL(addUserToDatabaseSQLCommand);
        database.execSQL("insert into " + USERS_TABLE + " values('Anshul Uniyal','899417965461','8368127007','78000')");
        database.execSQL("insert into " + USERS_TABLE + " values('Pooja Sharma','614982635486','9910570435','52344.6')");
        database.execSQL("insert into " + USERS_TABLE + " values('Anjali Malik','426817867282','7678573345','982938.70')");
        database.execSQL("insert into " + USERS_TABLE + " values('Sameer Rajpu','72978216842','8367523881','27863.56')");
        database.execSQL("insert into " + USERS_TABLE + " values('Pranav Garg','286828287217','7934675442','62436')");
        database.execSQL("insert into " + USERS_TABLE + " values('Jitender Singh','656482816195','7022792245','65482.9')");
        database.execSQL("insert into " + USERS_TABLE + " values('Neetu Bansla','267461676463','7316829729','65189')");
        database.execSQL("insert into " + USERS_TABLE + " values('Vikrant Tyagi','248238642822','7668454014','52549.59')");
        database.execSQL("insert into " + USERS_TABLE + " values('Ritu Sharma','429862346138','9553946031','9421')");


        database.close();

    }

    public void modifyUserDatabase (String senderAccountID,String receiversAccountId, double sendersbal,double receiversbal) {
        SQLiteDatabase database = getWritableDatabase();
        String modifyUserSQLCommand = "update " + USERS_TABLE+
                " set " +BALANCE_KEY+ "= '"+sendersbal+  "'"
                + " where "+ ACCOUNT_KEY + " = " + senderAccountID;
        database.execSQL(modifyUserSQLCommand);
        database.close();
        SQLiteDatabase database1 = getWritableDatabase();
        String modifyUserSQLCommand2 = "update " + USERS_TABLE+
                " set " +BALANCE_KEY+ "= '"+receiversbal+  "'"
                + " where "+ ACCOUNT_KEY + " = " + receiversAccountId;
        database1.execSQL(modifyUserSQLCommand2);
        database1.close();
    }

    public ArrayList<UsersClass> returnAllUsersDetails () {
        SQLiteDatabase database = getWritableDatabase();
        String sqlQueryCommand = "Select * from "+ USERS_TABLE;
        Cursor cursor = database.rawQuery(sqlQueryCommand, null);

        ArrayList<UsersClass> usersClassObjects = new ArrayList<>();
        while (cursor.moveToNext()) {

             UsersClass currentUserClassObject = new UsersClass(
                    cursor.getString(0),
                    cursor.getString(1),
                     cursor.getString(2),
                     cursor.getDouble(3));
            usersClassObjects.add(currentUserClassObject);
        }
        database.close();
        return usersClassObjects;
    }


}

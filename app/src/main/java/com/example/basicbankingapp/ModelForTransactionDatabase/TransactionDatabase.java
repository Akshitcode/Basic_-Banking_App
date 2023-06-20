package com.example.basicbankingapp.ModelForTransactionDatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.basicbankingapp.ModelForUserDataBase.UsersClass;

import java.util.ArrayList;

public class TransactionDatabase  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "transcationDatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String TRANSACTION_TABLE = "transactionHistory";

    private static final String SENDER_NAME_KEY = "senderName";
    private static final String TRANSFERED_AMOUNT_KEY = "balance";
    private static final String RECEIVER_NAME_KEY = "receiverName";
    private static final String PAYMENT_STATUS_KEY = "paymentStatus";

    public TransactionDatabase (Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createDatabaseSQL = "create table " + TRANSACTION_TABLE +
                "(" +  SENDER_NAME_KEY + " text" + ", " +
                RECEIVER_NAME_KEY + " text " + ", " +
                TRANSFERED_AMOUNT_KEY+ " real" + "," +
                PAYMENT_STATUS_KEY+ " text"  +")";
        db.execSQL(createDatabaseSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if EXISTS " + TRANSACTION_TABLE);
        onCreate(db);
    }
    public void addUserToDatabase (String senderName,String receiversName, String transferedAmount, String payStatus) {

        SQLiteDatabase database = getWritableDatabase();
        String addHistoryToDatabaseSQLCommand = "insert into " + TRANSACTION_TABLE + " values(" +
                "'"+senderName+"','"+ receiversName+ "','"+transferedAmount+"','"+payStatus+"')";

        database.execSQL(addHistoryToDatabaseSQLCommand);
        database.close();
    }

    public ArrayList<TransactionClass> returnAllTransactionHistory () {
        SQLiteDatabase database = getWritableDatabase();
        String sqlQueryCommand = "Select * from "+ TRANSACTION_TABLE;
        Cursor cursor = database.rawQuery(sqlQueryCommand, null);

        ArrayList<TransactionClass> transactionClasses = new ArrayList<>();
        while (cursor.moveToNext()) {

            TransactionClass transactionClass = new TransactionClass(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getDouble(2),
                    cursor.getString(3));
            transactionClasses.add(transactionClass);
        }
        database.close();
        return transactionClasses;
    }


}

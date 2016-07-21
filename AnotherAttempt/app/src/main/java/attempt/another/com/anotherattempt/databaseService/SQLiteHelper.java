package attempt.another.com.anotherattempt.databaseService;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import attempt.another.com.anotherattempt.utils.Constants;

/**
 * Created by utsrivas on 7/21/2016.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context) {
        super(context, Constants.DatabaseName, null, Constants.DatabaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = createProductsDetailsQuery();
        try {
            db.execSQL(createTableQuery);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private String createProductsDetailsQuery()
    {
        return "CREATE TABLE " + Constants.ProductsDetailsTableName + " ( " +
                Constants.ProductsDetailsTableIdColumn + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constants.ProductsDetailsTableNameColumn + " VARCHAR(255), " +
                Constants.ProductsDetailsTableBarCode + "VARCHAR(255), " +
                Constants.ProductsDetailsTableCostPrice + "VARCHAR(255), " +
                Constants.ProductsDetailsTableNameSellingPrice + "VARCHAR(255), " +
                Constants.ProductsDetailsTableProductDetails + "VARCHAR(255));";
    }


}

package attempt.another.com.anotherattempt.databaseService;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import attempt.another.com.anotherattempt.databaseService.product.ProductItem;
import attempt.another.com.anotherattempt.product.IProduct;
import attempt.another.com.anotherattempt.product.Product;
import attempt.another.com.anotherattempt.utils.Constants;
import attempt.another.com.anotherattempt.utils.Message;
import attempt.another.com.anotherattempt.utils.Utilities;

/**
 * Created by utsrivas on 7/21/2016.
 */
public class DatabaseService implements IDatabaseService {

    private SQLiteDatabase mSqLiteDatabase = null;

    DatabaseService(Context context)
    {
        mContext = context;
        mSqlHelper = new SQLiteHelper(mContext);
    }

    @Override
    public void CreateDatabase() {
        mSqLiteDatabase = mSqlHelper.getWritableDatabase();
    }

    @Override
    public void UpdateDatabase() {

    }

    @Override
    public List<ProductItem> getAllProductsFromDatabase() {

        ArrayList<ProductItem> list = new ArrayList<>();
        Cursor cursor = mSqLiteDatabase.query(Constants.ProductsDetailsTableName, null, null, null, null, null, null);
        while (cursor.moveToNext())
        {
            ProductItem productItem = new ProductItem();
            productItem.productId = cursor.getString(1);
            productItem.productName = cursor.getString(2);
            productItem.productBarCodeNumber = cursor.getString(3);
            productItem.productCostPrice = cursor.getFloat(4);
            productItem.productSellingPrice = cursor.getFloat(5);
            productItem.productDetails = cursor.getString(6);
            list.add(productItem);
        }
        return list;
    }

    @Override
    public ProductItem getProductFromBarCode(String barcode) {
        Cursor cursor = mSqLiteDatabase.query(Constants.ProductsDetailsTableName, null,
                Constants.ProductsDetailsTableBarCode + " = '" + barcode +"'" , null, null, null, null);
        ProductItem productItem = new ProductItem();
        while (cursor.moveToNext())
        {
            productItem.productId = cursor.getString(1);
            productItem.productName = cursor.getString(2);
            productItem.productBarCodeNumber = cursor.getString(3);
            productItem.productCostPrice = cursor.getFloat(4);
            productItem.productSellingPrice = cursor.getFloat(5);
            productItem.productDetails = cursor.getString(6);
        }
        return productItem;
    }

    @Override
    public boolean insetProductInDatabase(IProduct product) {

        ProductItem productItem = Utilities.getProductItemFromProduct(product);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.ProductsDetailsTableNameColumn, productItem.productName);
        contentValues.put(Constants.ProductsDetailsTableBarCode, productItem.productBarCodeNumber);
        contentValues.put(Constants.ProductsDetailsTableCostPrice, productItem.productCostPrice);
        contentValues.put(Constants.ProductsDetailsTableNameSellingPrice, productItem.productSellingPrice);
        contentValues.put(Constants.ProductsDetailsTableProductDetails, productItem.productDetails);
        long id = mSqLiteDatabase.insert(Constants.ProductsDetailsTableName, null, contentValues);
        if(id < 0)
        {
            Message.message(mContext, "Not able to insert row in Database");
            return false;
        }
        return true;
    }

    private SQLiteHelper mSqlHelper;
    private Context mContext;
}

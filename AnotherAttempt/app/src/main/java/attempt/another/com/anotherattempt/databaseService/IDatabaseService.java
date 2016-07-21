package attempt.another.com.anotherattempt.databaseService;

import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

import attempt.another.com.anotherattempt.databaseService.product.ProductItem;
import attempt.another.com.anotherattempt.product.IProduct;
import attempt.another.com.anotherattempt.product.Product;

/**
 * Created by utsrivas on 7/21/2016.
 */
public interface IDatabaseService{

    public void CreateDatabase();

    public void UpdateDatabase();

    public List<ProductItem> getAllProductsFromDatabase();

    public ProductItem getProductFromBarCode(String barcode);

    public boolean insetProductInDatabase(IProduct product);
}

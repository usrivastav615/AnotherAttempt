package attempt.another.com.anotherattempt.productsService;

import android.content.Context;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.prefs.PreferenceChangeListener;

import attempt.another.com.anotherattempt.databaseService.DatabaseService;
import attempt.another.com.anotherattempt.databaseService.IDatabaseService;
import attempt.another.com.anotherattempt.databaseService.ProductItem;
import attempt.another.com.anotherattempt.product.IProduct;
import attempt.another.com.anotherattempt.product.Product;
import attempt.another.com.anotherattempt.utils.Utilities;

/**
 * Created by utsrivas on 7/21/2016.
 */
public class ProductsService implements IProductsService {

    public static IProductsService getIntance(Context context)
    {
        if(mProductsService == null)
            mProductsService = new ProductsService(context);
        return mProductsService;
    }

    private ProductsService(Context context)
    {
        mContext = context;
        mProducts = new HashMap<String, IProduct>();
    }

    @Override
    public IProduct getProductFromBarcode(String barcode) {
        IProduct product = mProducts.get(barcode);
        if(product == null)
        {
            IDatabaseService databaseService = DatabaseService.getInstance(mContext);
            ProductItem productItem = databaseService.getProductFromBarCode(barcode);
            product = Utilities.getProductFromProductItem(productItem);
        }
        return product;
    }


    @Override
    public Map<String, IProduct> getAllProductsFromBarCode() {
        if(mProducts.size() == 0)
        {
            IDatabaseService databaseService = DatabaseService.getInstance(mContext);
            List<ProductItem> productItemList = databaseService.getAllProductsFromDatabase();
            for (ProductItem productItem: productItemList) {
                Product product = Utilities.getProductFromProductItem(productItem);
                mProducts.put(product.getProductBarCodeNumber(), product);
            }
        }
        return mProducts;
    }

    @Override
    public IProduct getProductFromId(String id) {
        return null;
    }

    @Override
    public void insertProductInDatabase(IProduct product) {
        IDatabaseService databaseService = DatabaseService.getInstance(mContext);
        mProducts.put(product.getProductBarCodeNumber(), product);
        databaseService.insetProductInDatabase(product);
    }

    @Override
    public void updateProductInDatabase(IProduct product) {

    }

    private static IProductsService mProductsService = null;
    private Context mContext;
    private Map<String, IProduct> mProducts;
}

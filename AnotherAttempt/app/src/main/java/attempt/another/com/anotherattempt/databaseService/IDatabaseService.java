package attempt.another.com.anotherattempt.databaseService;

import java.util.List;

import attempt.another.com.anotherattempt.product.IProduct;

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

package attempt.another.com.anotherattempt.productsService;

import attempt.another.com.anotherattempt.product.IProduct;
import attempt.another.com.anotherattempt.product.Product;

/**
 * Created by utsrivas on 7/21/2016.
 */
public interface IProductsService {

    public IProduct getProductFromBarcode(String barcode);

    public IProduct getProductFromId(String id);

    public void insertProductInDatabase(IProduct product);

    public void updateProductInDatabase(IProduct product);

}

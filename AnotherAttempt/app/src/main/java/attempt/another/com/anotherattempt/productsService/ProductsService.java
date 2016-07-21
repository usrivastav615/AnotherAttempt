package attempt.another.com.anotherattempt.productsService;

import java.util.List;

import attempt.another.com.anotherattempt.product.IProduct;
import attempt.another.com.anotherattempt.product.Product;

/**
 * Created by utsrivas on 7/21/2016.
 */
public class ProductsService implements IProductsService {
    @Override
    public IProduct getProductFromBarcode(String barcode) {
        return null;
    }

    @Override
    public IProduct getProductFromId(String id) {
        return null;
    }

    @Override
    public void insertProductInDatabase(IProduct product) {

    }

    @Override
    public void updateProductInDatabase(IProduct product) {

    }

    private List<IProduct> productList;
}

package attempt.another.com.anotherattempt.utils;

import attempt.another.com.anotherattempt.databaseService.product.ProductItem;
import attempt.another.com.anotherattempt.product.IProduct;

/**
 * Created by utsrivas on 7/22/2016.
 */
public class Utilities {


    public static ProductItem getProductItemFromProduct(IProduct product)
    {
        ProductItem productItem = new ProductItem();
        productItem.productBarCodeNumber = product.getProductBarCodeNumber();
        productItem.productCostPrice = product.getProductCostPrice();
        productItem.productSellingPrice = product.getProductSellingPrice();
        productItem.productName = product.getProductName();
        productItem.productDetails = product.getProductDetails();
        return productItem;
    }
}

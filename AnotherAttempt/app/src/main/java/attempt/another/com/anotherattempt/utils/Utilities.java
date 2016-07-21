package attempt.another.com.anotherattempt.utils;

import attempt.another.com.anotherattempt.databaseService.ProductItem;
import attempt.another.com.anotherattempt.product.IProduct;
import attempt.another.com.anotherattempt.product.Product;

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

    public static Product getProductFromProductItem(ProductItem productItem)
    {
        Product product = new Product();
        product.setProductBarCodeNumber(productItem.productBarCodeNumber);
        product.setProductCostPrice(productItem.productCostPrice);
        product.setProductSellingPrice(productItem.productSellingPrice);
        product.setProductName(productItem.productName);
        product.setProductDetails(productItem.productDetails);
        return product;
    }
}

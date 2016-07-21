package attempt.another.com.anotherattempt.product;

/**
 * Created by utsrivas on 7/21/2016.
 */
public class Product implements IProduct {

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String getProductId() {
        return productId;
    }

    @Override
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String getProductBarCodeNumber() {
        return productBarCodeNumber;
    }

    @Override
    public void setProductBarCodeNumber(String productBarCodeNumber) {
        this.productBarCodeNumber = productBarCodeNumber;
    }

    @Override
    public float getProductCostPrice() {
        return productCostPrice;
    }

    @Override
    public void setProductCostPrice(float productCostPrice) {
        this.productCostPrice = productCostPrice;
    }

    @Override
    public float getProductSellingPrice() {
        return productSellingPrice;
    }

    @Override
    public void setProductSellingPrice(float productSellingPrice) {
        this.productSellingPrice = productSellingPrice;
    }

    @Override
    public String getProductDetails() {
        return null;
    }

    @Override
    public void setProductDetails(String productDetails) {

    }

    //private members

    private String productName = null;
    private String productId = null;
    private String productBarCodeNumber = null;
    private float productCostPrice = 0;
    private float productSellingPrice = 0;
}

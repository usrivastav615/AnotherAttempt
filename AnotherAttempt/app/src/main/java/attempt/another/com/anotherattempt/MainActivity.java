package attempt.another.com.anotherattempt;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import attempt.another.com.anotherattempt.databaseService.DatabaseService;
import attempt.another.com.anotherattempt.databaseService.IDatabaseService;
import attempt.another.com.anotherattempt.product.IProduct;
import attempt.another.com.anotherattempt.product.Product;
import attempt.another.com.anotherattempt.productsService.IProductsService;
import attempt.another.com.anotherattempt.productsService.ProductsService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setServices();
        setOnClickListeners();
    }


    private void setServices()
    {
        setDatabaseService();
        setProductsService();
    }

    private void setOnClickListeners()
    {
        Button insertProductButton = (Button)findViewById(R.id.insertPrdouctButton);
        insertProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleFunctionToinsertProductInDatabase();
            }
        });

        Button readProductDetailsByBarcodeButton = (Button)findViewById(R.id.readProductByBarcodeButton);
        readProductDetailsByBarcodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleFunctionToReadProductFromBarcodeFromDatabase("999");
            }
        });

        Button readAllProductDetailsButton = (Button)findViewById(R.id.readAllProductsButton);
        readAllProductDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleFunctionToReadAllProductsFromDatabase();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private void setDatabaseService()
    {
       IDatabaseService databaseService =  DatabaseService.getInstance(this);
       databaseService.CreateDatabase();
    }

    private void setProductsService()
    {
        IProductsService productsService = ProductsService.getIntance(this);
        productsService.getAllProductsFromBarCode();
    }

    //See this function to check how to insert product information in the database
    private void sampleFunctionToinsertProductInDatabase()
    {
        IProduct product = new Product();
        product.setProductBarCodeNumber("999");
        product.setProductCostPrice(100);
        product.setProductDetails("details");
        product.setProductId("1");
        product.setProductName("Product 1");
        product.setProductSellingPrice(200);
        IProductsService productsService = ProductsService.getIntance(this);
        productsService.insertProductInDatabase(product);
    }

    //See this function to check how to read a product from database
    private void sampleFunctionToReadProductFromBarcodeFromDatabase(String barcode)
    {
        IProductsService productsService = ProductsService.getIntance(this);
        productsService.getProductFromBarcode(barcode);
    }

    //See this function to check how to read all products from the database
    private void sampleFunctionToReadAllProductsFromDatabase()
    {
        IProductsService productsService = ProductsService.getIntance(this);
        productsService.getAllProductsFromBarCode();
    }
}

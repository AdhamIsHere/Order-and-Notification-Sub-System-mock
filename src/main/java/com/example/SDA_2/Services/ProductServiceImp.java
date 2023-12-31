package com.example.SDA_2.Services;

import com.example.SDA_2.Data.ProductsDatabase;
import com.example.SDA_2.Models.Product.Product;
import com.example.SDA_2.Models.Product.ProductHelper;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ProductServiceImp implements ProductService {
    private ProductsDatabase productsDatabase = ProductsDatabase.GetProductInstance();
    @Override
    public boolean addProduct(Product p, int q) {
      return productsDatabase.addProduct(p,q);
    }

    @Override
    public boolean removeProduct(Product p, int q) {
       return productsDatabase.removeProduct(p,q);
    }

    @Override
    public HashMap<Product, Integer> getAllProducts() {
        return productsDatabase.getAll();
    }

    @Override
    public ProductHelper getProduct(String s) {
        ProductHelper ph= productsDatabase.getProduct(s);
        return ph;
    }
}

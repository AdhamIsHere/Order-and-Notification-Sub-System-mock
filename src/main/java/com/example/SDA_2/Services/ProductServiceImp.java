package com.example.SDA_2.Services;

import com.example.SDA_2.Data.ProductsDatabase;
import com.example.SDA_2.Models.Product.Product;
import com.example.SDA_2.Models.Product.ProductHelper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {
    @Override
    public boolean addProduct(Product p, int q) {
      return ProductsDatabase.addProduct(p,q);
    }

    @Override
    public boolean removeProduct(Product p, int q) {
       return ProductsDatabase.removeProduct(p,q);
    }

    @Override
    public ProductHelper getProduct(String s) {
        ProductHelper ph= ProductsDatabase.getProduct(s);
        return ph;
    }
}

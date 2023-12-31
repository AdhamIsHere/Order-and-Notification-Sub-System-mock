package com.example.SDA_2.Services;

import com.example.SDA_2.Models.Product.Product;
import com.example.SDA_2.Models.Product.ProductHelper;

import java.util.HashMap;

public interface ProductService {
    public boolean addProduct(Product p,int q);
    public boolean removeProduct(Product p ,int q);
    public ProductHelper getProduct(String s);
    public HashMap<Product,Integer> getAllProducts();
}

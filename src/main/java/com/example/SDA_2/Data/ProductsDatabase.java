package com.example.SDA_2.Data;

import com.example.SDA_2.Models.Customer;
import com.example.SDA_2.Models.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ProductsDatabase {
    public static ArrayList<Product> products = new ArrayList<>(Arrays.asList(
            new Product("1234","Caseoh","fadl","good",500),
            new Product("1345","Case123oh","fa1dl","goo3d",5010)
        ));
    public static HashMap<String,Integer> categoryCount = new HashMap<>();
}

package com.example.SDA_2.Controller;

import com.example.SDA_2.Data.ProductsDatabase;
import com.example.SDA_2.Models.Product.Product;
import com.example.SDA_2.Models.Product.ProductHelper;
import com.example.SDA_2.Models.Response;
import com.example.SDA_2.Services.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImp productServiceImp;

    @PostMapping("/add")
    public Response addProduct(@RequestBody ProductHelper ph) {
        Response res = new Response();
        Product p = ph.getProduct();
        int q = ph.getQuantity();
        res.setStatus(productServiceImp.addProduct(p, q));
        if (res.isStatus()) {
            res.setMessage("Product add Successfully");
        }else{
            res.setMessage("Couldn't add Product");
        }
        return res;
    }

    @GetMapping("/get/{serial}")
    public ProductHelper getProduct (@PathVariable("serial") String serial){
        return productServiceImp.getProduct(serial);
    }
    @GetMapping("/getAll")
    public HashMap<Product,Integer> getAllProducts(){
        return productServiceImp.getAllProducts();
    }

}
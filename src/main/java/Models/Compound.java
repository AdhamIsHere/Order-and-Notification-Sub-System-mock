package Models;

import org.springframework.context.annotation.ScopeMetadata;

import java.util.ArrayList;
import java.util.HashMap;

public class Compound extends Order {

    ArrayList<ArrayList<Product>> Product_list;
    ArrayList<Customer> Customer_list;

    Compound() {
        Product_list = new ArrayList<>();
        Product_list.forEach((i) -> i = new ArrayList<>());
        Customer_list = new ArrayList<>();
    }

    @Override
    public void calcTotal() {



        for (int i = 0; i < Product_list.size(); i++) {
            Total = 0;
            System.out.println("the customer number " + i + 1);
            ArrayList<Product> x = Product_list.get(i);
            for (int j = 0; j < x.size(); j++) {

                Total += x.get(j).price;

            }
            System.out.println("the total for the customer "+i+1+" "+Total );
        }


    }

    @Override
    public void printOrder() {


        for (int i = 0; i < Product_list.size(); i++) {
            System.out.println("the customer number " + i + 1);
            ArrayList<Product> x = Product_list.get(i);
            for (int j = 0; j < x.size(); j++) {
                System.out.println("name " + x.get(j).name + " " + x.get(j).vendor + " " + x.get(j).category + " " + x.get(j).serialNumber + " " + x.get(j).vendor);
            }
        }


    }


    public void addProduct(ArrayList<Customer> C_list, ArrayList<ArrayList<Product>> P_list) {

        Product_list.addAll(P_list);
        Customer_list.addAll(C_list);

    }
}

package Models;

import java.util.ArrayList;

public abstract class Order {
    float Total = 0;
    public abstract void calcTotal();
    public abstract void printOrder();


}

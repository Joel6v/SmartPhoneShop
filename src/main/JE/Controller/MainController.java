package Controller;

import Model.*;
import Repository.Repository;

public class MainController {
    //This sequence must be the same. Same as when loading the collection
    public static Controller<Address> address;
    public static Controller<Smartphone> smartphone;
    public static Controller<Customer> customer;
    public static Controller<OrderPosition> orderPosition;
    public static Controller<Order> order;
}

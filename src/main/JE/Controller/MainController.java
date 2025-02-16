package Controller;

import Model.*;
import Repository.*;

public class MainController {
    //This sequence must be like this because the collections must load in this sequence.
    public static Controller<Address> address;
    public static Controller<Smartphone> smartphone;
    public static Controller<Customer> customer;
    public static Controller<OrderPosition> orderPosition;
    public static Controller<Order> order;

    public static void setInstanceAll(){
        address = new Controller<Address>(new AddressRepository());
        smartphone = new Controller<Smartphone>(new SmartphoneRepository());
        customer = new Controller<Customer>(new CustomerRepository());
        orderPosition = new Controller<OrderPosition>(new OrderPositionRepository());
        order = new Controller<Order>(new OrderRepository());
    }

    public static void saveAll(){
        address.save();
        smartphone.save();
        customer.save();
        orderPosition.save();
        order.save();
    }
}

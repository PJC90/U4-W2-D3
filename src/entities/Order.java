package entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {
    private Long id;
    private String status;
    private LocalDate overDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    public Order(String status, LocalDate overDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.status = status;
        this.overDate = overDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
        Random rm = new Random();
        this.id = (long) rm.nextInt(1,100000);
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOverDate() {
        return overDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }
}

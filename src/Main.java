import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Z-Flip","Smartphone",750.5));
        products.add(new Product("I-Phone","Smartphone",1150.5));
        products.add(new Product("Felpa","Boys", 50.2));
        products.add(new Product("Biberon", "Baby", 21.5));
        products.add(new Product("Culla", "Baby", 81.5));
        products.add(new Product("Il nuovo Java","Book",12.5));
        products.add(new Product("Seneca", "Book",12.4));
        products.add(new Product("Homo-Deus", "Book",19.7));

        List<Order> carrello = new ArrayList<>();
        carrello.add(new Order("ok", LocalDate.of(2022,2,15),LocalDate.of(2022,5,15),products,new Customer("Filippo",2)));
        carrello.add(new Order("ok", LocalDate.of(2022,2,15),LocalDate.of(2022,5,15),products,new Customer("Gigi",3)));

        products.forEach(product -> System.out.print(product.getName() + ", "));
        System.out.println();
        System.out.println("*****   Prezzi maggiori di 100€   ******");
        products.stream().filter(prize -> prize.getPrice() > 100).forEach(product -> System.out.println(product.getName()));
        System.out.println("********   Catogoria Baby  ************");
//        products.stream().filter(product -> "Baby".equals(product.getCategory())).forEach(product -> System.out.println(product.getName()));
        List<String> baby = products.stream().filter(product -> "Baby".equals(product.getCategory())).map(product -> product.getName()).toList();
        baby.forEach(bab -> System.out.println(bab));
        System.out.println("*****  Catogoria Boys 10% discount  *****");

        List<String> boys = products.stream().filter(product -> "Boys".equals(product.getCategory()))
                .map(product -> (product.getName() + " " + (product.getPrice() - product.getPrice()*0.10))).toList();
        //        boys.forEach(boy -> System.out.println(boy));
        boys.forEach(System.out::println);

        System.out.println("************  Carrello  **************");
        carrello.forEach(car -> System.out.println(car.getCustomer().getName()));

    }
}
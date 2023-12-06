import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        Product iPhone = new Product("iPhone","Smartphone", 1500);
        Product Samsung = new Product("Samsung","Smartphone", 1500);
        List<Product> magazzino = new ArrayList<>(Arrays.asList(iPhone,Samsung));
        */
        List<Product> products = new ArrayList<>();
        products.add(new Product("Z-Flip","Smartphone",750.5));
        products.add(new Product("I-Phone","Smartphone",1150.5));
        products.add(new Product("Felpa","Boys", 50.2));
        products.add(new Product("Biberon", "Baby", 21.5));
        products.add(new Product("Culla", "Baby", 81.5));
        products.add(new Product("Il nuovo Java","Book",12.5));
        products.add(new Product("Seneca", "Book",120.4));
        products.add(new Product("Homo-Deus", "Book",19.7));

//        List<Order> carrello = new ArrayList<>(); //****Prova1****
//        carrello.add(new Order("ok", LocalDate.of(2022,2,15),LocalDate.of(2022,5,15),products,new Customer("Filippo",2)));
//        carrello.add(new Order("ok", LocalDate.of(2022,2,15),LocalDate.of(2022,5,15),products,new Customer("Gigi",3)));
        Customer Aldo = new Customer("Aldo Baglio",1);
        Customer Giacomo = new Customer("Giacomo Poretti",2);
        Customer Giovanni = new Customer("Giovanni Storti",3);
        Customer Filippo = new Customer("Filippo Inzaghi",2);

        Order aldoOrder = new Order(Aldo);
        Order giacomoOrder = new Order(Giacomo);
        Order giovanniOrder = new Order(Giovanni);
        Order filippoOrder = new Order(Filippo);
        Order filippoOrder2 = new Order(Filippo);

        aldoOrder.addProduct(products.get(0));
        aldoOrder.addProduct(products.get(1));
        giacomoOrder.addProduct(products.get(2));
        giacomoOrder.addProduct(products.get(3));
        giovanniOrder.addProduct(products.get(4));
        giovanniOrder.addProduct(products.get(5));
        filippoOrder.addProduct(products.get(6));
        filippoOrder2.addProduct(products.get(7));
//
        List<Order> orderList = new ArrayList<>(Arrays.asList(aldoOrder, giovanniOrder, giovanniOrder, filippoOrder2, filippoOrder));
//        List<Order> orderList = Arrays.asList(aldoOrder, giovanniOrder, giovanniOrder, filippoOrder2, filippoOrder); è UGUALE


        for (Order order : orderList) {
            System.out.println(order.getCustomer().getName());
        }
        System.out.println("******     Libri > 100     ***********");
        List<Product> book100 = products.stream().filter(product -> product.getCategory().equals("Book") && product.getPrice() > 100).toList();
        book100.forEach(b-> System.out.println(b.getName() + " " + b.getPrice() + " €"));
        System.out.println("******     ordini Baby     ***********");
        List<Order> babyOrder = orderList.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("Baby"))).toList();
        for(Order order : babyOrder){
            System.out.println(order.getProducts()); //da sistemare
        }
        System.out.println("***************************************");
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
                .map(product -> (product.getName() + " " + (product.getPrice()*0.90))).toList();
        //        boys.forEach(boy -> System.out.println(boy));
        boys.forEach(System.out::println);

        System.out.println("************  Carrello  **************");
//        carrello.forEach(car -> System.out.println(car.getCustomer().getName()));     //****Prova1****

    }
}
package com.database.examples;

import com.database.models.Product;
import com.database.repositories.ProductRepository;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MapperExample {

    public static ProductRepository pr = new ProductRepository();

    public static void main(String[] args) throws SQLException {
        System.out.println("Welcome to THD Hands-on Mapper example");

        // We call our products list first
        List<Product> products = pr.findAllProducts();

        // From here we can use the list as many times and ways we can

        System.out.println("");

        // Find max stock item - STREAM MAX
        Product p1 = products.stream().max(Comparator.comparingInt(Product::getAmount)).get();
        System.out.println("Max stock item is: " + p1.getName());

        // Find min stock item - STREAM LAMBDA
        Product p2 = products.stream()
                .min((x, y) -> x.getAmount() - y.getAmount())
                .get();
        System.out.println("Min stock item is: " + p2.getName());

        // Find max price item - STREAM COLLECTOR
        Product p3 = products.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)))
                .get();
        System.out.println("Max price item is: " + p3.getName());

        // Find min price item - STREAM REDUCE
        Product p4 = products.stream()
                .reduce((a, b) -> a.getPrice() < b.getPrice() ? a : b)
                .get();
        System.out.println("Min price item is: " + p4.getName());

        System.out.println("");

        //Print them all - STREAM FOR EACH
        products.stream().forEach(e -> {
            System.out.println("I-" + e.getId() + " " + e.getName() + " $" + e.getPrice() + " - Available " + e.getAmount());
        });

        System.out.println("");

        // Filter with provider 1 - STREAM FILTER
        products.stream().filter(e -> e.getProviderId() == 3).forEach(e -> {
            System.out.println("I-" + e.getId() + " " + e.getName() + " $" + e.getPrice() + " - Available " + e.getAmount());
        });

        System.out.println("");

        // Apply sort by price - STREAM SORTED
        products.stream().sorted(Comparator.comparingDouble(Product::getPrice)).forEach(e -> {
            System.out.println("I-" + e.getId() + " " + e.getName() + " $" + e.getPrice() + " - Available " + e.getAmount());
        });

        System.out.println("");

        // Apply discount on price - STREAM MAP
        Arrays.asList(p1, p2, p3, p4).stream().map(e -> "I-" + e.getId() + " $" + e.getPrice() + "-> $" + (e.getPrice() * 0.80)).forEach(System.out::println);
    }

}

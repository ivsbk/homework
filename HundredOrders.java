package Tasks;

import Address.Address;
import Orders.Order;
import Products.Apple;
import Products.Orange;
import Products.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class HundredOrders {
    public static void main(String[] args) throws IOException {
        String country, city, street, color;
        int house, floor, apartment, weight, price;
        int numberOfEntries =100;
        boolean withBones;

        String[] countries = {"Antegria", "Arstotzka", "Impor", "Kolechia", "Obristan", "Republia"};
        String[] cities = {"Smallton", "Hugeton", "Shorton", "Longton", "Deepton", "Plainton"};
        String[] streets = {"Second st.", "Third st.", "Park st.", "Lane st.", "Lake st.", "Main st."};
        String[] colors = {"red", "yellow", "pink", "green", "orange"};

        List <Order> orders = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        Random random = new Random();

        for (int i = 1; i < numberOfEntries+1; i++) {

            country = countries[random.nextInt(countries.length)];
            city = cities[random.nextInt(cities.length)];
            street = streets[random.nextInt(cities.length)];
            color = colors[random.nextInt(colors.length)];

            house = random.nextInt(100) + 1;
            floor = random.nextInt(20) + 1;
            apartment = random.nextInt(100) + 1;
            weight = random.nextInt(75) + 25;
            price = random.nextInt(20) + 10;
            withBones = random.nextBoolean();

            Apple apple = new Apple(price, "apple", weight, color);
            Orange orange = new Orange(price, "orange", weight, withBones);
            Address address = new Address(country, city, street, house, floor, apartment);

            List<Product> products = new ArrayList<>();
            products.add(apple);
            products.add(orange);

            Order order = new Order(products, address);
            orders.add(order);

        }

        FileWriter fileWriter = new FileWriter("src/100rders.json");
        mapper.writeValue(fileWriter, orders);

        FileReader fileReader = new FileReader("src/100rders.json");
        mapper.readValue(fileReader, List.class);
        orders.forEach(System.out::println);

    }
}

package Tasks;

import Address.Address;
import Orders.Order;
import Products.Apple;
import Products.Orange;
import Products.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class HundredOrders {
    public static void main(String[] args) throws IOException {
        String country, city, street, color;
        int house, floor, apartment, weight, price;
        boolean withBones;

        String[] countries = {"Antegria", "Arstotzka", "Impor", "Kolechia", "Obristan", "Republia"};
        String[] cities = {"Smallton", "Hugeton", "Shorton", "Longton", "Deepton", "Plainton"};
        String[] streets = {"Second st.", "Third st.", "Park st.", "Lane st.", "Lake st.", "Main st."};
        String[] colors = {"red", "yellow", "pink", "green", "orange"};


        for ( int i = 1; i<101; i++) {
            HashMap<String, FileWriter> writers = new HashMap<>();
                        ObjectMapper mapper = new ObjectMapper();
            Random random = new Random();

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

            FileWriter fileWriter = new FileWriter("src/100rders.json", true);
            fileWriter.write(System.getProperty( "line.separator" ));
            writers.put("order", fileWriter);
            mapper.writeValue(writers.get("order"), order);


    }

       /* FileReader fileReader =new FileReader("src/100rders.json");   //reads the file
        BufferedReader bufferedReader=new BufferedReader(fileReader);  //creates a buffering character input stream
        StringBuffer stringBuffer =new StringBuffer();    //constructs a string buffer with no characters
        String line;

        List <Order> orders = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        while((line=bufferedReader.readLine())!=null)
        {
            stringBuffer.append(line);
            stringBuffer.append("\n");
            Order order = mapper.readValue(stringBuffer.toString(), Order.class);
            orders.add(order);
            stringBuffer.delete(0, stringBuffer.length());


        }
        fileReader.close();

        */
    }


}

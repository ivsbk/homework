package Tasks;

import Orders.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadHundredOrders {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("src/100rders.json");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;

        List<Order> orders = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        while ((line = bufferedReader.readLine()) != null) {

            Order order = mapper.readValue(line, Order.class);
            orders.add(order);

        }
        fileReader.close();
        orders.forEach(System.out::println);
    }
}
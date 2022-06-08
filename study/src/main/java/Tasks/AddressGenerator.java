package Tasks;

import Address.Address;
import Orders.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddressGenerator {
    public static void main(String[] args) throws IOException {
        String country, city, street;
        int house, floor, apartment;

            String[] countries = {"Antegria", "Arstotzka", "Impor", "Kolechia", "Obristan", "Republia"};
            String[] cities = {"Smallton", "Hugeton", "Shorton", "Longton", "Deepton", "Plainton"};
            String[] streets = {"Second st.", "Third st.", "Park st.", "Lane st.", "Lake st.", "Main st."};

            Random random = new Random();
            country = countries[random.nextInt(countries.length)];
            city = cities[random.nextInt(cities.length)];
            street = streets[random.nextInt(cities.length)];

            house = random.nextInt(100) + 1;
            floor = random.nextInt(20) + 1;
            apartment = random.nextInt(100) + 1;

            ObjectMapper mapper = new ObjectMapper();
            Address address = new Address(country, city, street, house, floor, apartment);
            List<Address> addresses = new ArrayList<>();
            addresses.add(address);
            FileWriter fileWriter = new FileWriter("src/address.json");
            mapper.writeValue(fileWriter, address);
            FileReader fileReader = new FileReader("src/address.json");
            address = mapper.readValue(fileReader, Address.class);
            System.out.println(address.toString());
        }

}
package Tasks;

import Entities.Address;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Task2Address {
    public static void main(String[] args) throws IOException {

            String[] countries = {"Antegria", "Arstotzka", "Impor", "Kolechia", "Obristan", "Republia"};
            String[] cities = {"Smallton", "Hugeton", "Shorton", "Longton", "Deepton", "Plainton"};
            String[] streets = {"Second st.", "Third st.", "Park st.", "Lane st.", "Lake st.", "Main st."};

            Random random = new Random();
            ObjectMapper mapper = new XmlMapper();

            String country = countries[random.nextInt(countries.length)];
            String city = cities[random.nextInt(cities.length)];
            String street = streets[random.nextInt(cities.length)];

            final int houseBoundary = 100;
            final int floorBoundary = 20;
            final int apartmentBoundary = 100;

            int house = random.nextInt(houseBoundary) + 1;
            int floor = random.nextInt(floorBoundary) + 1;
            int apartment = random.nextInt(apartmentBoundary) + 1;

            Address address = new Address(country, city, street, house, floor, apartment);

            FileWriter fileWriter = new FileWriter("src/address.xml");
            mapper.writeValue(fileWriter, address);
            FileReader fileReader = new FileReader("src/address.xml");
            address = mapper.readValue(fileReader, Address.class);
            System.out.println(address.toString());
        }

}
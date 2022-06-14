package Entities;

import Interfaces.AddressCreation;
import java.util.Random;

public class Address implements AddressCreation {
    public Address() {
    }

        public String country, city, street;
        public int house, floor, apartment;

    @Override
    public Address makeAddress() {
        String[] countries = {"Antegria", "Arstotzka", "Impor", "Kolechia", "Obristan", "Republia"};
        String[] cities = {"Smallton", "Hugeton", "Shorton", "Longton", "Deepton", "Plainton"};
        String[] streets = {"Second st.", "Third st.", "Park st.", "Lane st.", "Lake st.", "Main st."};

        Random random = new Random();

        country = countries[random.nextInt(countries.length)];
        city = cities[random.nextInt(cities.length)];
        street = streets[random.nextInt(cities.length)];

        final int houseBoundary = 100;
        final int floorBoundary = 20;
        final int apartmentBoundary = 100;

        house = random.nextInt(houseBoundary) + 1;
        floor = random.nextInt(floorBoundary) + 1;
        apartment = random.nextInt(apartmentBoundary) + 1;

        return new Address(country, city, street, house, floor, apartment);

    }

    @Override
    public String toString() {
        return "Address{" +
                "country=" + country +
                ", city=" + city +
                ", street=" + street +
                ", house=" + house +
                ", floor=" + floor +
                ", apartment=" + apartment +
                '}';
    }

    public Address(String country, String city, String street, int house, int floor, int apartment) {

            this.country = country;
            this.city = city;
            this.street = street;
            this.house = house;
            this.floor = floor;
            this.apartment = apartment;
        }
}


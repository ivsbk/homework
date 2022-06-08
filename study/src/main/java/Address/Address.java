package Address;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;


@JsonAutoDetect
public class Address implements Serializable {
    public Address() {
    }

        public String country, city, street;
        public int house, floor, apartment;

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


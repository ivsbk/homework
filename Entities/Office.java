package Entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class Office {
    public Office(){}

    @Override
    public String toString() {
        return "Office{" +
                "workers=" + workers +
                ", address=" + address +
                '}';
    }

    public Office (Address address, List<Worker> workers){
        this.address = address;
        this.workers = workers;
    }

    @JacksonXmlElementWrapper(useWrapping = true, localName = "staff")
    @JacksonXmlProperty(localName = "worker")
    public List<Worker> workers;
    public Address address;
}

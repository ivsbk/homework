package Tasks;

import Entities.Address;
import Entities.Office;
import Entities.Worker;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Task3Office {
    public static void main(String[] args) throws IOException {

        final int officesNum = 100;
        final int workersNum = 10;

        ObjectMapper mapper = new XmlMapper();

        List<Office> offices = new ArrayList<>();

        for (int i = 1; i < officesNum + 1; i++){

            Address address = new Address();
            address.makeAddress();
            List<Worker> workers = new ArrayList<>();

            for (int j = 1; j < workersNum + 1; j++){
                Worker worker = new Worker();
                worker.makeWorker();
                workers.add(worker);
            }

            Office office = new Office(address, workers);
            offices.add(office);
        }

        FileWriter fileWriter = new FileWriter("src/offices.xml");
        mapper.writeValue(fileWriter, offices);

        FileReader fileReader = new FileReader("src/offices.xml");
        offices = mapper.readValue(fileReader, new TypeReference<List<Office>>(){});
        offices.forEach(System.out::println);
    }
}

package Tasks;

import Entities.Worker;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Task1Worker {
    public static void main(String[] args) throws IOException {

        Random random = new Random();
        ObjectMapper mapper = new XmlMapper();

        String[] names = {"Ivan", "Petr", "Luka", "Simeon", "Mark", "Nikolay"};
        String[] surnames = {"Ivanov", "Petrov", "Lukin", "Semenov", "Markov", "Nikolaev"};
        String[] patronymics = {"Ivanovich", "Petrovich", "Lukich", "Semenovich", "Markovich", "Nikolaevich"};

        int randomNameNum = random.nextInt(names.length);
        int randomSurnameNum = random.nextInt(surnames.length);
        int randomPatronymicNum = random.nextInt(patronymics.length);

        int num = 1;

        String surname = surnames[randomSurnameNum];
        String name = names[randomNameNum];
        String patronymic = patronymics[randomPatronymicNum];

        final int minValue = 18;

        final int ageBoundary = 50;
        int age = minValue + random.nextInt(ageBoundary);

        final int expBoundary = age - 18;
        int exp = random.nextInt(expBoundary);

        final int wageBoundary = 200;
        int wage = (minValue + random.nextInt(wageBoundary)) * 1000;

       Worker worker = new Worker(num, surname, name, patronymic, age, exp, wage);

        FileWriter fileWriter = new FileWriter("src/worker.xml");
        mapper.writeValue(fileWriter, worker);
        FileReader fileReader = new FileReader("src/worker.xml");
        worker = mapper.readValue(fileReader, Worker.class);
        System.out.println(worker.toString());

    }
}
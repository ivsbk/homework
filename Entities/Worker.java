package Entities;

import Interfaces.WorkerCreation;
import java.util.Random;

public class Worker implements WorkerCreation {
    public Worker() {}

        public String surname;
        public String name;
        public String patronymic;
        public int age;
        public int exp;
        public int wage;
        public static int num = 1;
        public int id;


    @Override
    public Worker makeWorker(){
        Random random = new Random();

        String[] names = {"Ivan", "Petr", "Luka", "Simeon", "Mark", "Nikolay"};
        String[] surnames = {"Ivanov", "Petrov", "Lukin", "Semenov", "Markov", "Nikolaev"};
        String[] patronymics = {"Ivanovich", "Petrovich", "Lukich", "Semenovich", "Markovich", "Nikolaevich"};

        int randomNameNum = random.nextInt(names.length);
        int randomSurnameNum = random.nextInt(surnames.length);
        int randomPatronymicNum = random.nextInt(patronymics.length);

        id = num++;
        surname = surnames[randomSurnameNum];
        name = names[randomNameNum];
        patronymic = patronymics[randomPatronymicNum];

        final int minValue = 18;

        final int ageBoundary = 50;
        age = minValue + random.nextInt(ageBoundary);

        int expBoundary = 20;
        exp = random.nextInt(expBoundary);

        final int wageBoundary = 150;
        wage = (minValue + random.nextInt(wageBoundary)) * 1000;

        return new Worker(id, surname, name, patronymic, age, exp, wage);
    }

        @Override
        public String toString() {
            return "Worker{" +
                    "id=" + id +
                    ", surname='" + surname + '\'' +
                    ", name='" + name + '\'' +
                    ", patronymic='" + patronymic + '\'' +
                    ", age=" + age +
                    ", exp=" + exp +
                    ", wage=" + wage +
                    '}';
        }

        public Worker(int id, String surname, String name, String patronymic, int age, int exp, int wage) {
            this.surname = surname;
            this.name = name;
            this.patronymic = patronymic;
            this.age = age;
            this.exp = exp;
            this.wage = wage;
            this.id = id;

        }


}

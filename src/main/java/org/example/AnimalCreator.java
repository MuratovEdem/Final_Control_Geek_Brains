package org.example;

import org.example.animals.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalCreator {
    private static List<String> allAnimalsToCreate = new ArrayList<>(Arrays.asList("Собака", "Кошка", "Хомяк", "Лошадь", "Верблюд", "Осел"));

    public static Animal create(int typeNumber, String name, List<String> commands) {
        Animal animal = new Donkey(name, commands);

        switch (allAnimalsToCreate.get(typeNumber)) {
            case "Собака":
                animal = new Dog(name, commands);
                break;
            case "Кошка":
                animal = new Cat(name, commands);
                break;
            case "Хомяк":
                animal = new Hamster(name, commands);
                break;
            case "Лошадь":
                animal = new Horse(name, commands);
                break;
            case "Верблюд":
                animal = new Camel(name, commands);
                break;
            case "Осел":
                animal = new Donkey(name, commands);
                break;
        }

        return animal;
    }


    public static List<String> getAllAnimalsToCreate() {
        return new ArrayList<>(allAnimalsToCreate);
    }
}

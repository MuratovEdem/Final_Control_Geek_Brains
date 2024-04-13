package org.example;

import org.example.animals.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Animal> animals = new ArrayList<>();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        final int commandAddAnimal = 1;
        final int commandShowListAnimalCommands = 2;
        final int commandAddCommand = 3;
        final int commandExit = 4;

        boolean isWorking = true;

        while (isWorking) {
            System.out.println("""
                    Выведите команду:
                    1. Завести новое животное
                    2. Список команд животного
                    3. Добавить новую команду
                    4. Выход""");

            int userCommand = scanner.nextInt();

            switch (userCommand) {
                case (commandAddAnimal):
                    createAndAddAnimal();
                    break;
                case (commandShowListAnimalCommands):
                    showAnimalCommands();
                    break;
                case (commandAddCommand):
                    addCommandToAnimal();
                    break;
                case (commandExit):
                    isWorking = false;
                    break;
            }

        }
    }

    private void createAndAddAnimal() {
        Scanner scanner = new Scanner(System.in);

        try (Counter counter = new Counter()) {
            System.out.println("Введите номер животного, которое хотите завести");

            List<String> allAnimalsToCreate = AnimalCreator.getAllAnimalsToCreate();

            for (int i = 0; i < allAnimalsToCreate.size(); i++) {
                System.out.println(i + " " + allAnimalsToCreate.get(i));
            }

            int animalType = scanner.nextInt();

            if (animalType < 0 || animalType >= allAnimalsToCreate.size()) {
                System.out.println("Такого номера нет");
                return;
            }

            System.out.println("Введите кличку животного");
            String animalName = scanner.next();

            System.out.println("Введите, через запятую, команды, которые может выполнять животное");
            List<String> animalCommands = Arrays.stream(scanner.next().split(",")).toList();

            animals.add(AnimalCreator.create(animalType, animalName, animalCommands));

            counter.increment();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void showAnimalCommands() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите животное");

        for (int i = 0; i < animals.size(); i++) {
            System.out.println(i + ". " + animals.get(i) + " " + animals.get(i).getName());
        }

        int userChoice = scanner.nextInt();

        for (String command: animals.get(userChoice).getCommands()) {
            System.out.println(command);
        }
    }

    private void addCommandToAnimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите животное");

        for (int i = 0; i < animals.size(); i++) {
            System.out.println(i + ". " + animals.get(i) + " " + animals.get(i).getName());
        }

        int userChoice = scanner.nextInt();

        System.out.println("Введите команду");

        String newCommand = scanner.nextLine();

        animals.get(userChoice).addCommand(newCommand);
    }
}

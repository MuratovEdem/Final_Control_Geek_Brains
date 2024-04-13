package org.example.animals;

import java.util.List;

public class Donkey extends PackAnimal {
    public Donkey(String name, List<String> command) {
        super(name, command);
    }

    @Override
    public String toString() {
        return "Осел";
    }
}

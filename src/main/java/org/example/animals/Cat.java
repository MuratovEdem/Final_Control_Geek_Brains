package org.example.animals;

import java.util.List;

public class Cat extends Pet {
    public Cat(String name, List<String> command) {
        super(name, command);
    }

    @Override
    public String toString() {
        return "Кот";
    }
}

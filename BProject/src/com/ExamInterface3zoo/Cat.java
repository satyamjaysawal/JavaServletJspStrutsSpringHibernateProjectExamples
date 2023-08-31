package com.ExamInterface3zoo;

public class Cat implements Animal {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says Meow!");
    }
}

package com.ExamInterface3zoo;
public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.addAnimal(new Dog("Buddy"));
        zoo.addAnimal(new Cat("Whiskers"));

        zoo.makeAllSounds();
    }
}
package com.mystudy.algorithm.interview.stack;

public class PetEnterQueue {
    private Pet pet;
    private long count;
    PetEnterQueue(Pet pet, long count){
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getEnterPetType(){
        return this.pet.getType();
    }
}
class Pet{
    private String type;
    Pet(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Dog extends Pet{

    Dog(String type) {
        super("dog");
    }
}

class Cat extends Pet{

    Cat(String type) {
        super("cat");
    }
}

package com.mystudy.algorithm.interview.stack;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    DogCatQueue() {
        this.dogQ = new LinkedList<>();
        this.catQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        } else if (pet.getType().equals("cat")) {
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("err, not dog or cat");
        }
    }

    public Pet pollAll() {
        if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                return this.dogQ.poll().getPet();
            } else {
                return this.catQ.poll().getPet();
            }
        } else if (!this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("err, queue is empty!");
        }
    }

    public Dog pollDog(){
        if (!this.dogQ.isEmpty()){
            return (Dog) this.dogQ.poll().getPet();
        }else {
            throw new RuntimeException("Dog queue is empty!");
        }
    }

    public Cat pollCat(){
        if (!this.catQ.isEmpty()){
            return (Cat) this.catQ.poll().getPet();
        }else {
            throw new RuntimeException("Cat queue is empty!");
        }
    }

    public static void main(String[] args) {
        Pet pet1 = new Dog("wangcai");
        Pet pet2 = new Cat("amao");
        DogCatQueue dogCatQueue = new DogCatQueue();
        dogCatQueue.add(pet1);
        dogCatQueue.add(pet2);
        System.out.println(dogCatQueue.dogQ.peek().getPet().getType());
        System.out.println(dogCatQueue.catQ.peek().getPet().getType());
    }
}

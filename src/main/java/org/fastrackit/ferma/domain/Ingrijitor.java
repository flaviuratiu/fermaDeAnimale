package org.fastrackit.ferma.domain;

/**
 * @author ttritean
 * @since 4/8/2019
 */
public class Ingrijitor {


    private Farm farm;

    public Ingrijitor(Farm farm) {
        this.farm = farm;
    }

    public void addAnimal(Animal animal) {

//        farm.getAnimals().add(animal);
        farm.addAnimal(animal);
    }

    public void putAllAnimalsToSleep() {
       for(Animal a: farm.getAnimals()) {
           a.sleep(8);
       }
    }

    public void feedAllAnimals(String aliment) {
        for(Animal a: farm.getAnimals()) {
            a.eat(aliment);
        }
    }
}

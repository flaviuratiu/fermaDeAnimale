package org.fastrackit.ferma.domain;

import org.fastrackit.ferma.exception.ValidationException;

/**
 * @author ttritean
 * @since 4/8/2019
 */
public class Animal {

    private String name;

    private String porecla;


    public Animal() {
    }

    public Animal(String name, String porecla) throws ValidationException{
        if(name == null || name.equals("") ||name.contains("5") ) {
            throw new ValidationException("The name for " +
                    "the animal is invalid");
        }
        this.name = name;
        this.porecla = porecla;
    }

    public void eat(String aliment){
        System.out.println("Animalul " + name+
                " a mancat " + aliment);
    }


    public void sleep(int hoursOfSleep) {
        System.out.println("Animalul "+ name +
                " doarme "+ hoursOfSleep +" ore.");
    }
}

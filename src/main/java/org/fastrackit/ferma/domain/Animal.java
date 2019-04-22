package org.fastrackit.ferma.domain;

import org.fastrackit.ferma.exception.ValidationException;

/**
 * @author ttritean
 * @since 4/8/2019
 */
public class Animal {

    private String name;

    private String porecla;

    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPorecla() {
        return porecla;
    }

    public void setPorecla(String porecla) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("name='").append(name).append('\'');
        sb.append(", porecla='").append(porecla).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

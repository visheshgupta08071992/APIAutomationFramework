package com.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

    private FakerUtils(){}

    private static final Faker faker = new Faker();

    //Methods here has default access modifier i.e protected so that no one can access the given methods
    //outside the package
    static int getNumber(int startvalue,int endvalue){
        return faker.number().numberBetween(startvalue,endvalue);
    }

    static String getFirstName(){
        return faker.name().firstName();
    }

    static String getLastName(){
        return faker.name().lastName();
    }

    static String getEmail(){
        return faker.internet().emailAddress();
    }
}

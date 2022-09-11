package com.utils;

//Making the class final as does not want anyone to override it
public final class RandomUtils {

    //business layer --> all business level changes
    //Does not want anyone to create its object
    private RandomUtils(){}

    public static int getId(){
       return FakerUtils.getNumber(1,100000);
    }

    public static String getFirstName(){
        return FakerUtils.getFirstName();
    }

    public static String getLastName(){
        return FakerUtils.getLastName();
    }

    public static String getEmail(){
        return FakerUtils.getEmail();
    }
}

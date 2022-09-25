package com.constants;

import lombok.Getter;

public final  class FrameworkConstants {

    //For static fields we need to add Lombok Getter at field level. Class level getter does not add
    //getter for static fields

    private static @Getter String requestFolderPath=".//src//test//resources//jsons//";
    private static @Getter String responseFolderPath=".//output//";
    private static @Getter String propertyFilePath=".//src//test//resources//config.properties";
    private static @Getter String responseSchemaPath=".//src//test//resources//schemas//";

}

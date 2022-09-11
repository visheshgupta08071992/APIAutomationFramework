package com.pojo;

/*
*
* {
        "id":{{$randomInt}},
        "first_name": "{{$randomFirstName}}",
        "last_name": "{{$randomLastName}}",
        "email": "{{$randomEmail}}",
        "jobs":["Tester","Trainer"],
        "favFoods":{
            "breakfast":"idly",
            "lunch":"rice",
            "dinner":["Chapati","Milk"]
        }
}
*
*
* */


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Employee {

    private  int id;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> jobs;
    FavFoods favFoods;

    public Employee(){}

}

package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FavFoods {
    private String breakfast;
    private String lunch;
    private List<String> dinner;

    public FavFoods(){};

}

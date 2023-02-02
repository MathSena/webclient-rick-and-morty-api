package com.mathsena.webclientrickandmortyapi.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CharactererResponse {

    private String id;
    private String name;
    private String status;
    private String species;
    private String image;
    private List<String> episodes;


}
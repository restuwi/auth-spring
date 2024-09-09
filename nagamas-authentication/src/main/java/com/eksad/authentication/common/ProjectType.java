package com.eksad.authentication.common;

import java.util.Arrays;

/**
 *
 * @author amy
 */
public enum ProjectType {
    
    CQRS("CQRS"),
    CRUD("CRUD");

    private String name;

    ProjectType(String name) {
        this.name = name;
    }

    public ProjectType findEnum(String name){
        return Arrays.stream(values())
                .filter(data -> data.name.equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}

package com.jackson.utils.core.examples;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is an example for how jackson de-serialization (actually java) conceptually does not differentiate between
 * a field value being absent or a field value set as default value.
 * e.g. name (String) can be absent or set as 'null' in json string but jackson/java will always have value as null in
 * both cases.
 */
public class AbsentFieldInDeSerialization {

    @JsonProperty
    private String name;

    @JsonProperty
    private int age;

    public String getName() {
        return name;
    }

    public AbsentFieldInDeSerialization setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public AbsentFieldInDeSerialization setAge(int age) {
        this.age = age;
        return this;
    }
}

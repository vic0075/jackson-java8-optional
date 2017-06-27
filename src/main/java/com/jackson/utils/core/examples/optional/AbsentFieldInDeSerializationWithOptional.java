package com.jackson.utils.core.examples.optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

/**
 * This class is an example for how jackson de-serialization (actually java) conceptually does not differentiate between
 * a field value being absent or a field value set as default value and how it can be solved using java8 Optional
 * e.g. name (String) can be absent or set as 'null' in json string but jackson/java will always have value as null in
 * both cases. but when we use optional we can set it as 'absent'
 */
public class AbsentFieldInDeSerializationWithOptional {

    @JsonProperty
    private Optional<String> name = Optional.empty();

    @JsonProperty
    private Optional<Integer> age = Optional.empty();

    //note: Jackson Absent is exclude value with null as it is impossible to know (due to java behavior)
    // whether the value is null (absent) or set as null
    //in case you want value null in the output json you can use custom mixin with condition as isPresent().
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Optional<String> getName() {
        return name;
    }

    public AbsentFieldInDeSerializationWithOptional setName(Optional<String> name) {
        this.name = name;
        return this;
    }

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Optional<Integer> getAge() {
        return age;
    }

    public AbsentFieldInDeSerializationWithOptional setAge(Optional<Integer> age) {
        this.age = age;
        return this;
    }
}

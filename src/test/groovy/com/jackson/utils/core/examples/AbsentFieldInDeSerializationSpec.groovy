package com.jackson.utils.core.examples

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification
import spock.lang.Unroll

class AbsentFieldInDeSerializationSpec extends Specification {

    private ObjectMapper mapper

    void setup() {
        mapper = new ObjectMapper()
    }

    @Unroll
    void "test Deserialization: #description"() {
        when:
        AbsentFieldInDeSerialization obj = mapper.convertValue(mapper.readTree(value), AbsentFieldInDeSerialization.class)

        then:
        obj.name == name
        obj.age == age

        where:
        description                                                                                                     | value                                      | name            | age
        "when name and age are absent: age and name are set as default, null and 0 respectively"                        | "{}"                                       | null            | 0
        "when name is set as null and age is set as 0: age and name are set as null and 0 respectively"                 | "{\"name\":null, \"age\":0}"               | null            | 0
        "when name is set as non-null and age is set as non-0: age and name are set as non-null and non-0 respectively" | "{\"name\":\"Frank Serpico\", \"age\":30}" | "Frank Serpico" | 30
    }

}

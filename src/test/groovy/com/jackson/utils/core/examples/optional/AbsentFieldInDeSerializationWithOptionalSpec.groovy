package com.jackson.utils.core.examples.optional

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import spock.lang.Specification
import spock.lang.Unroll

class AbsentFieldInDeSerializationWithOptionalSpec extends Specification {

    private ObjectMapper mapper

    void setup() {
        mapper = new ObjectMapper()
        mapper.registerModule(new Jdk8Module())
    }

    @Unroll
    void "test Deserialization: #description"() {
        when:
        AbsentFieldInDeSerializationWithOptional obj = mapper.convertValue(mapper.readTree(value), AbsentFieldInDeSerializationWithOptional.class)

        then:
        obj.name == name
        obj.age == age

        and: "De-Serialization"
        mapper.writeValueAsString(obj) == json

        where:
        description                                                                                                     | value                                      | name                         | age              | json
        "when name and age are absent: age and name are set as default, null and 0 respectively"                        | "{}"                                       | Optional.empty()             | Optional.empty() | "{}"
        "when name is set as null and age is set as 0: age and name are set as null and 0 respectively"                 | "{\"name\":null, \"age\":0}"               | Optional.ofNullable(null)    | Optional.of(0)   | "{\"age\":0}"
        "when name is set as non-null and age is set as non-0: age and name are set as non-null and non-0 respectively" | "{\"name\":\"Frank Serpico\", \"age\":30}" | Optional.of("Frank Serpico") | Optional.of(30)  | "{\"name\":\"Frank Serpico\",\"age\":30}"
    }

}

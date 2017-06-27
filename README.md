# Java8 Optional in Jackson De-Serialization

This is an example project. The main purpose is to provide examples about how to use java8 optional in Jackson Serialization/De-Serialization.

### Use Case

* It is not possible in jackson-core (default datatype) to know whether a field has been set or not, e.g.

`{"name":null}` and `{}` if binded to a class having field `String name` will set it as null and we wouldn't know if 
that is a default value or set deliberately by user.

##Solution(s):
There could be multiple solutions such as using mixins, using your own de-serializers etc.

The important part is it is always setter (or constructor) that gets called when De-Serializing json into Object
so you can have a additional boolean field such as `isValueSet` to know if it is set by user or not.

But All above stated solutions have one major problem that is it's a developer's nightmare to maintain all things all its own. 

Jackson has additional data type for java8 that facilitates using Optional as fields and you wouldn't have to do anything on your own.


##Testing:
Spock framework is used for testing.


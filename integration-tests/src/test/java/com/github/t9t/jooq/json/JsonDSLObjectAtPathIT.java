package com.github.t9t.jooq.json;

import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static com.github.t9t.jooq.json.JsonDSL.objectAtPath;

public class JsonDSLObjectAtPathIT extends AbstractJsonDSLTest {
    @Parameterized.Parameters(name = "{1}_{0}")
    public static List<Object[]> params() {
        return generateParams("objectAtPath", Arrays.asList(
                test("oneLevel").selecting(objectAtPath(json, "str")).expectJson("\"Hello, json world!\""),
                test("obj").selecting(objectAtPath(json, "obj")).expectJson(toNode("{\"i\": 5521, \"b\": true}")),
                test("deepVarargs").selecting(objectAtPath(json, "arr", "0", "d")).expectJson("4408"),
                test("deepCollection").selecting(objectAtPath(json, Arrays.asList("arr", "0", "d"))).expectJson("4408"),
                test("notExistingPath").selecting(objectAtPath(json, "not", "existing", "path")).expectNull()
        ));
    }
}

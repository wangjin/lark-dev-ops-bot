package com.eqy.devopsbot;

import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jin Wang
 * @version 1.0
 * @since 2022-06-10 14:44
 */
public class TipsAndTricksTests {

    private static final String APP_NAME = "";

    @Test
    void contextLoads() throws Exception {
        List<String> stringList = List.of("a", "b", "c");
        List<String> filteredList = stringList.stream()
                .filter(o -> o.equals("c"))
                .collect(Collectors.toList());
        stringList.forEach(System.out::println);
    }

    @Test
    void postFixTests() throws Exception {
        // sout
        System.out.println("Hello World");
        // var
        String hello = "Hello World";
    }
}

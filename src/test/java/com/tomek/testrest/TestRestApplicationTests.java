package com.tomek.testrest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TestRestApplicationTests {

    @Test
    void contextLoads() {

    }

    @DisplayName("Test name")
    @Test
    void simpleTest() {
        int result = 2 +3;

        assertEquals(5, result);
        //org.assertj.core.api.Assertions.assertThat(Arrays.asList("", "")).isNotEmpty();

    }

    @DisplayName("Test name")
    @Test
    void givenWhenThen() {
        int result = 2 +3;

        assertEquals(5, result);
        //org.assertj.core.api.Assertions.assertThat(Arrays.asList("", "")).isNotEmpty();

    }

}

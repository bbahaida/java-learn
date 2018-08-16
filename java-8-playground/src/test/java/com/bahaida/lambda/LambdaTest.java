package com.bahaida.lambda;

import org.junit.Test;

import static org.junit.Assert.*;

public class LambdaTest {

    @Test
    public void testFunctionalInterface() {
        // arrange
        LambdaPG lambdaPG = new LambdaPG();
        String entry = "Brahim";
        String expected = "Hello Brahim";
        // act
        String actual = lambdaPG.sayHello(entry);
        // assert

        assertEquals(expected, actual);
    }

    @Test
    public void testSayHelloReturnNullIfEmpty() {
        // arrange
        LambdaPG lambdaPG = new LambdaPG();
        String entry = "";
        // act
        String actual = lambdaPG.sayHello(entry);
        // assert

        assertEquals(null, actual);
    }



}
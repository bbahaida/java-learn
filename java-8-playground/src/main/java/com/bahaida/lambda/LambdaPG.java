package com.bahaida.lambda;

import java.util.function.Predicate;

public class LambdaPG {
    public String sayHello(String s) {
        Predicate<String> predicate = (str) -> str.length()>0;
        LambdaFunctional functional = (str) -> {
            if (predicate.test(str))
                return "Hello "+str;
            return null;
        };
        return functional.sayHello(s);
    }
}

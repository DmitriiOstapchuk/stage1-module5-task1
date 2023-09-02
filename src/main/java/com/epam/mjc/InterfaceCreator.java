package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            boolean result = true;
            for (String string : x) {
                if (!Character.isUpperCase(string.charAt(0))) {
                    result = false;
                }
            }
            return result;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> y = new ArrayList<>();
            for (Integer number : x) {
                if (number % 2 == 0)
                    y.add(number);
            }
            x.addAll(y);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();
            for (String string : values) {
                if (string.endsWith(".")) {
                    if(Character.isUpperCase(string.charAt(0))) {
                        String[] words = string.split(" ");
                        if (words.length > 3) {
                            result.add(string);
                        }
                    }
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String string : x) {
                map.put(string, string.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x, y) -> {
            List<Integer> resultList = new ArrayList<>();
            for (Integer number : x) {
                resultList.add(number);
            }
            for (Integer number : y) {
                resultList.add(number);
            }
            return resultList;
        };
    }
}

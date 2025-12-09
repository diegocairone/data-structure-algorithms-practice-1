package com.cairone.dsa.sets;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class FirstUnrepeatedCharInString {

    private FirstUnrepeatedCharInString() {
    }

    public static int findUnrepeated(String value) {
        char[] chars = value.toCharArray();
        Map<Character, Integer> frequency = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char charAt = chars[i];
            frequency.put(charAt, frequency.getOrDefault(charAt, 0) + 1);
        }
        char repeatedChar = '0';
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == 1) {
                repeatedChar = entry.getKey();
                break;
            }
        }
        return value.indexOf(repeatedChar);
    }

    public static int findRepeated(String value) {
        char[] chars = value.toCharArray();
        Set<Character> unrepeatedChars = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            char charAt = chars[i];
            if (unrepeatedChars.contains(charAt)) {
                return i;
            }
            unrepeatedChars.add(charAt);
        }
        return -1;
    }
}

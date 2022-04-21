package com.example.ebshop.service.generateId;

import java.util.Random;

public class GenerateRandomId {

    public static String generate() {
        String generatedString;
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();
            generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        return generatedString;
    }
}

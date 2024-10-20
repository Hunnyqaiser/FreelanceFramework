package com.Helper;

import java.util.List;
import java.util.Random;

public class RandomDataGenerator {

    // Method to generate a random email
    public static String generateRandomEmail(int length)
    {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder email = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            email.append(characters.charAt(random.nextInt(characters.length())));
        }

        // Append a domain to the random string
        email.append("@example.com");

        return email.toString();
    }

    // Method to generate a random password
    public static String generateRandomPassword(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_+=<>?";
        StringBuilder password = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }

        return password.toString();
    }
    
    
    public static <T> T getRandomElementFromList(List<T> elements) {
        if (elements == null || elements.isEmpty()) {
            throw new IllegalArgumentException("The list cannot be null or empty");
        }
        
        // Create a Random object
        Random random = new Random();
        
        // Select a random index from the list
        int randomIndex = random.nextInt(elements.size());
        
        // Return the element at the random index
        return elements.get(randomIndex);
    }

}

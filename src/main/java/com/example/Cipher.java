package com.example;

import java.util.Scanner;

public class Cipher {
    public void encryptFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть мову (ua/en): ");
        String language = scanner.nextLine().toLowerCase();
        System.out.print("Введіть ключ (0-32 для ua, 0-25 для en): ");
        int key = scanner.nextInt();
        scanner.nextLine();

        if (language.equals("ua") && key < 0 || key > 32) {
            System.out.println("Невірний ключ для української мови!");
            return;
        } else if (language.equals("en") && key < 0 || key > 25) {
            System.out.println("Невірний ключ для англійської мови!");
            return;
        }

        FileHandler fileHandler = new FileHandler();
        String content = fileHandler.readFile();
        String encrypted = encrypt(content, language, key);
        fileHandler.saveFile(encrypted);
        System.out.println("Файл шифровано!");
    }

    public void decryptFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть мову (ua/en): ");
        String language = scanner.nextLine().toLowerCase();
        System.out.print("Введіть ключ (0-32 для ua, 0-25 для en): ");
        int key = scanner.nextInt();
        scanner.nextLine();

        if (language.equals("ua") && key < 0 || key > 32) {
            System.out.println("Невірний ключ для української мови!");
            return;
        } else if (language.equals("en") && key < 0 || key > 25) {
            System.out.println("Невірний ключ для англійської мови!");
            return;
        }

        FileHandler fileHandler = new FileHandler();
        String content = fileHandler.readFile();
        String decrypted = decrypt(content, language, key);
        fileHandler.saveFile(decrypted);
        System.out.println("Файл розшифровано!");
    }

    private String encrypt(String text, String language, int key) {
        StringBuilder encrypted = new StringBuilder();
        String alphabet = language.equals("ua") ? "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя" : "abcdefghijklmnopqrstuvwxyz";
        int size = alphabet.length();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = alphabet.indexOf(Character.toLowerCase(c));

            if (index != -1) {
                int shifted = (index + key) % size;
                char encryptedChar = alphabet.charAt(shifted);
                encrypted.append(language.equals("ua") && Character.isUpperCase(c) ? Character.toUpperCase(encryptedChar) : encryptedChar);
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    private String decrypt(String text, String language, int key) {
        StringBuilder decrypted = new StringBuilder();
        String alphabet = language.equals("ua") ? "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя" : "abcdefghijklmnopqrstuvwxyz";
        int size = alphabet.length();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = alphabet.indexOf(Character.toLowerCase(c));

            if (index != -1) {
                int shifted = (index + size - (key % size)) % size;
                char decryptedChar = alphabet.charAt(shifted);
                decrypted.append(language.equals("ua") && Character.isUpperCase(c) ? Character.toUpperCase(decryptedChar) : decryptedChar);
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }
}
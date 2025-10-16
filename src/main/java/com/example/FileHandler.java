package com.example;

import java.util.Scanner;
import java.io.*;

public class FileHandler {
    private static final String FILE_PATH = "./data.txt";

    public void createFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть вміст файлу: ");
        String content = scanner.nextLine();
        saveFile(content);
        System.out.println("Файл створено!");
    }

    public void openFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("=== Вміст файлу ===");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("=== Кінець файлу ===");
        } catch (IOException e) {
            System.out.println("Помилка відкриття файлу!");
        }
    }

    public void saveFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Помилка збереження файлу!");
        }
    }

    public void saveFile(String content, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, append))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Помилка збереження файлу!");
        }
    }

    public String readFile() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("
");
            }
        } catch (IOException e) {
            System.out.println("Помилка читання файлу!");
        }
        return content.toString();
    }

    public void printFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("=== Вміст файлу ===");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("=== Кінець файлу ===");
        } catch (IOException e) {
            System.out.println("Помилка друку файлу!");
        }
    }
}
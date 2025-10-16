package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler();
        Cipher cipher = new Cipher();
        DeveloperInfo devInfo = new DeveloperInfo();

        boolean running = true;
        while (running) {
            System.out.println("
=== Шифрувальник Цезаря ===");
            System.out.println("1. Створити файл");
            System.out.println("2. Відкрити файл");
            System.out.println("3. Зберегти файл");
            System.out.println("4. Друкувати файл");
            System.out.println("5. Шифрувати файл");
            System.out.println("6. Розшифрувати файл");
            System.out.println("7. Вивести інформацію про розробника");
            System.out.println("8. Вихід");

            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: fileHandler.createFile(); break;
                case 2: fileHandler.openFile(); break;
                case 3: fileHandler.saveFile(); break;
                case 4: fileHandler.printFile(); break;
                case 5: cipher.encryptFile(); break;
                case 6: cipher.decryptFile(); break;
                case 7: devInfo.showInfo(); break;
                case 8: running = false; break;
                default: System.out.println("Невірний вибір!");
            }
        }
        scanner.close();
    }
}
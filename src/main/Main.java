package main;

import priorityqueue.*;

public class Main {
    public static void main(String[] args) {
        // Создание очереди с приоритетами на 10 элементов
        PriorityQueue queue = new PriorityQueue(10);

        // Заполнение очереди значениями от 10 до 1
        System.out.println("=== Инициализация очереди ===");
        for (int i = 10; i >= 1; i--) {
            queue.insert(new Priority(i));
        }
        queue.print();

        // Удаление элементов с минимальными приоритетами
        System.out.println("\n=== Удаление элементов с минимальными приоритетами ===");
        for (int i = 0; i < 3; i++) {
            int minValue = queue.deleteMin();
            System.out.println(">> Удален элемент с минимальным приоритетом: " + minValue);
            queue.print();
        }

        System.out.println("\n=== Работа завершена ===");
    }
}

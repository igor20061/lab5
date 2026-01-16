package lab5.zad6;

import java.util.*;

public class QueueReversePrinter {

    // Метод для печати элементов очереди в обратном порядке с использованием стека
    public static void printReverse(Queue<Integer> L) {
        if (L.isEmpty()) {
            System.out.println("Очередь пуста!");
            return;
        }

        // Создаем стек для временного хранения элементов
        Stack<Integer> stack = new Stack<>();

        System.out.print("Элементы очереди в обратном порядке: ");

        // 1. Извлекаем все элементы из очереди и помещаем в стек
        while (!L.isEmpty()) {
            stack.push(L.poll());
        }

        // 2. Извлекаем элементы из стека (они будут в обратном порядке)
        while (!stack.isEmpty()) {
            int element = stack.pop();
            System.out.print(element + " ");
            // Можно также вернуть элементы обратно в очередь, если нужно сохранить ее
            // L.add(element);
        }
    }
}

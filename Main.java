package lab5;
import lab5.zad1.Drob;
import lab5.zad2.Cat;
import lab5.zad2.CountingCat;
import lab5.zad2.Funs;
import lab5.zad3.ListTask9;
import lab5.zad4.AdmissionProcessor;
import lab5.zad5.ConsonantFinder;
import lab5.zad6.QueueReversePrinter;
import lab5.zad7_1.Point;
import lab5.zad7_1.PolyLine;

import java.util.*;
import java.io.IOException;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        while (true) {
            System.out.println("\n======================================");
            System.out.println("МЕНЮ ВЫБОРА ЗАДАНИЙ");
            System.out.println("======================================");
            System.out.println("1. Задание 1 - Дробь");
            System.out.println("2. Задание 2 - Кот");
            System.out.println("3. Задание 3 - Симметрическая разность");
            System.out.println("4. Задание 4 - Обработка абитуриентов");
            System.out.println("5. Задание 5 - Поиск согласных");
            System.out.println("6. Задание 6 - Обратная очередь");
            System.out.println("7. Задание 7.1 - Ломаная линия");
            System.out.println("0. Выход");
            System.out.println("======================================");
            System.out.print("Выберите задание (0-7): ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // очистка буфера
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите число от 0 до 7!");
                scanner.nextLine(); // очистка неверного ввода
                continue;
            }

            switch (choice) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 6:
                    task6();
                    break;
                case 7:
                    task7();
                    break;
                case 0:
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }

            System.out.print("\nНажмите Enter для продолжения...");
            scanner.nextLine();
        }
    }

    private static void task1() {
        System.out.println("\n======================================");
        System.out.println("ЗАДАНИЕ 1. Дробь");
        System.out.println("======================================");

        Drob drob = new Drob(3, 4);
        System.out.println("Создана дробь: " + drob.toString());
        System.out.println("Вещественное значение: " + drob.toFloat());

        drob.setNumerator(-7);
        System.out.println("\nИзменили числитель: " + drob.toString());
        System.out.println("Новое вещественное значение: " + drob.toFloat());
    }

    private static void task2() {
        System.out.println("\n======================================");
        System.out.println("ЗАДАНИЕ 2. Кот");
        System.out.println("======================================");

        // Создаём кота (оригинальный класс, который нельзя изменять)
        Cat originalCat = new Cat("Барсик");

        // Создаём обёртку для подсчёта мяуканий
        CountingCat countingCat = new CountingCat(originalCat);

        System.out.println("Создан кот: " + originalCat);
        System.out.println("Начинаем мяукать...\n");

        // Передаём обёртку в метод (метод думает, что это обычный Meowable)
        Funs.meowsCare(countingCat);

        // После окончания работы метода выводим количество мяуканий
        System.out.println("\nКот мяукал " + countingCat.getMeowCount() + " раз");
    }

    private static void task3() {
        System.out.println("\n======================================");
        System.out.println("ЗАДАНИЕ 3. Симметрическая разность");
        System.out.println("======================================");

        List<Integer> l1 = List.of(1, 2, 3, 4);
        List<Integer> l2 = List.of(3, 4, 5);

        System.out.println("Список 1: " + l1);
        System.out.println("Список 2: " + l2);
        System.out.println("Симметрическая разность: " + ListTask9.symmetricDiff(l1, l2));
    }

    private static void task4() {
        System.out.println("\n======================================");
        System.out.println("ЗАДАНИЕ 4. Обработка абитуриентов");
        System.out.println("======================================");

        String filename = "input.txt"; // Имя файла с данными

        // Создаем обработчик
        AdmissionProcessor processor = new AdmissionProcessor();

        try {
            // Читаем данные из файла
            processor.readFromFile(filename);

            // Выводим полные результаты
            processor.printResults();

            // Или можно вывести просто список (по заданию)
            // processor.printFailedApplicantsSimple();

        } catch (IOException e) {
            System.out.println("Ошибка при обработке файла: " + e.getMessage());
            System.out.println("\nУбедитесь, что файл 'input.txt' существует и содержит данные в формате:");
            System.out.println("N (количество абитуриентов)");
            System.out.println("Фамилия1 Имя1 балл1 балл2");
            System.out.println("Фамилия2 Имя2 балл1 балл2");
            System.out.println("...");
        }
    }

    private static void task5() {
        System.out.println("\n======================================");
        System.out.println("ЗАДАНИЕ 5. Поиск согласных");
        System.out.println("======================================");

        try {
            // Получаем результат
            List<String> consonants = ConsonantFinder.find("text.txt");

            // Выводим
            if (consonants.isEmpty()) {
                System.out.println("Нет таких согласных");
            } else {
                System.out.println("Звонкие согласные, которые входят более чем в одно слово:");
                for (String c : consonants) {
                    System.out.print(c + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private static void task6() {
        System.out.println("\n======================================");
        System.out.println("ЗАДАНИЕ 6. Обратная очередь");
        System.out.println("======================================");

        // Создаем и заполняем непустую очередь
        Queue<Integer> L = new LinkedList<>();
        L.add(1);
        L.add(2);
        L.add(3);
        L.add(4);
        L.add(5);

        System.out.println("Исходная очередь: " + L);

        // Вызываем метод для печати в обратном порядке
        QueueReversePrinter.printReverse(L);
    }

    private static void task7() {
        System.out.println("\n======================================");
        System.out.println("ЗАДАНИЕ 7.1. Ломаная линия");
        System.out.println("======================================");

        // Создаем набор объектов Point
        List<Point> points = Arrays.asList(
                new Point(2, 3),
                new Point(1, -5),
                new Point(5, 2),
                new Point(2, 3), // Дубликат
                new Point(3, -1),
                new Point(1, -5), // Дубликат
                new Point(4, 7),
                new Point(5, 2)  // Дубликат
        );

        System.out.println("Исходные точки:");
        points.forEach(p -> System.out.print(p + " "));
        System.out.println("\n");

        // Создаем ломаную с помощью стрима
        PolyLine polyline = createPolyline(points);

        System.out.println("Результат - ломаная линия:");
        System.out.println(polyline);
    }

    public static PolyLine createPolyline(List<Point> points) {
        Point[] resultPoints = points.stream()
                // Убираем точки с одинаковыми координатами (дубликаты)
                .distinct()
                // Сортируем по X
                .sorted(Comparator.comparingDouble(Point::getX))
                // Отрицательные Y делаем положительными
                .map(p -> {
                    double newY = p.getY() < 0 ? -p.getY() : p.getY();
                    return new Point(p.getX(), newY);
                })
                // Преобразуем в массив
                .toArray(Point[]::new);

        return new PolyLine(resultPoints);
    }
}
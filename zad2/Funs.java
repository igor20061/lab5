package lab5.zad2;

// Funs.java

import java.util.Collection;

public class Funs {
    /**
     * Метод, который принимает набор объектов, способных мяукать,
     * и вызывает мяуканье у каждого из них
     */
    public static void meowsCare(Meowable m) {
        // Вместо коллекции в данном случае метод принимает одного Meowable
        // и вызывает meow() несколько раз (например, 5 раз, как в примере)
        for (int i = 0; i < 5; i++) {
            m.meow();
        }
    }

    /**
     * Альтернативная версия метода, принимающая коллекцию мяукающих объектов
     */
    public static void meowsCare(Collection<Meowable> meowables) {
        for (Meowable m : meowables) {
            m.meow();
        }
    }
}

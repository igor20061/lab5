package lab5.zad2;

// CountingCat.java
public class CountingCat implements Meowable {
    private Cat cat;
    private int meowCount;

    public CountingCat(Cat cat) {
        this.cat = cat;
        this.meowCount = 0;
    }

    @Override
    public void meow() {
        cat.meow();  // делегируем вызов оригинальному коту
        meowCount++; // увеличиваем счётчик
    }

    public int getMeowCount() {
        return meowCount;
    }

    public void resetMeowCount() {
        meowCount = 0;
    }
}

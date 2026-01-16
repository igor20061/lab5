package lab5.zad1;

public class Drob implements DrobInterface {
    private int numerator;      // Числитель
    private int denominator;    // Знаменатель
    private Double cachedValue; // Кеш для вещественного значения

    public Drob(int numerator, int denominator) throws IllegalArgumentException {
        if (denominator <= 0) throw new IllegalArgumentException("Знаменатель не может быть равен нулю или отрицательным");
        this.numerator = numerator;
        this.denominator = denominator;
        this.cachedValue = null; // Изначально кеша нет
    }

    // Строковое представление дроби
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Возвращает вещественное значение дроби с кешированием
    @Override
    public double toFloat() {
        if (cachedValue == null) {
            cachedValue = ((double) numerator) / denominator;
        }
        return cachedValue;
    }

    // Установка числителя (очищает кеш)
    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        cachedValue = null; // После изменения числителя сбрасываем кеш
    }

    // Установка знаменателя (очищает кеш)
    @Override
    public void setDenominator(int denominator) throws IllegalArgumentException {
        if (denominator <= 0) throw new IllegalArgumentException("Знаменатель не может быть равен нулю или отрицательным");
        this.denominator = denominator;
        cachedValue = null; // После изменения знаменателя сбрасываем кеш
    }

    // Геттеры для полей
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Проверка равенства дробей
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Drob)) return false;
        Drob other = (Drob) obj;
        // Приводим обе дроби к нормальной форме перед сравнением
        int[] normThis = normalize();
        int[] normOther = other.normalize();
        return normThis[0] == normOther[0] && normThis[1] == normOther[1];
    }

    // Приведение дроби к минимальной нормальной форме
    private int[] normalize() {
        int gcd = Math.abs(gcd(this.numerator, this.denominator));
        return new int[]{this.numerator / gcd, this.denominator / gcd};
    }

    // Алгоритм Евклида для нахождения НОД
    private static int gcd(int a, int b) {
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Хэш-код для поддержки коллекции HashSet и др.
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numerator;
        result = prime * result + denominator;
        return result;
    }
}

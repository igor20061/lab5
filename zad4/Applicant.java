package lab5.zad4;

public class Applicant {
    private String surname;
    private String name;
    private int score1;
    private int score2;

    public Applicant(String surname, String name, int score1, int score2) {
        this.surname = surname;
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
    }

    public String getFullName() {
        return surname + " " + name;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public boolean isAdmitted() {
        return score1 >= 30 && score2 >= 30;
    }

    public boolean isFailed() {
        return !isAdmitted();
    }

    @Override
    public String toString() {
        return String.format("%s %s (баллы: %d и %d)",
                surname, name, score1, score2);
    }
}

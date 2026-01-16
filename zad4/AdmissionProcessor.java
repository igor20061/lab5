package lab5.zad4;

import java.io.*;
import java.util.*;

public class AdmissionProcessor {
    private Map<String, Applicant> applicants;
    private List<Applicant> failedApplicants;

    public AdmissionProcessor() {
        applicants = new HashMap<>();
        failedApplicants = new ArrayList<>();
    }

    public void readFromFile(String filename) throws IOException {
        applicants.clear();
        failedApplicants.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException("Файл пустой");
            }

            int n = Integer.parseInt(line.trim());

            for (int i = 0; i < n; i++) {
                line = br.readLine();
                if (line == null) {
                    System.out.println("Внимание: в файле меньше строк, чем указано в N");
                    break;
                }

                processApplicantLine(line);
            }

            analyzeResults();

        } catch (NumberFormatException e) {
            throw new IOException("Ошибка формата данных в файле", e);
        }
    }

    private void processApplicantLine(String line) {
        line = line.trim();
        if (line.isEmpty()) return;

        String[] parts = line.split("\\s+");

        if (parts.length < 4) {
            System.out.println("Пропущена некорректная строка: " + line);
            return;
        }

        try {
            String surname = parts[0];
            String name = parts[1];
            int score1 = Integer.parseInt(parts[2]);
            int score2 = Integer.parseInt(parts[3]);

            // Проверка диапазона баллов
            if (score1 < 0 || score1 > 100 || score2 < 0 || score2 > 100) {
                System.out.println("Пропущен абитуриент с некорректными баллами: " +
                        surname + " " + name);
                return;
            }

            Applicant applicant = new Applicant(surname, name, score1, score2);
            String fullName = applicant.getFullName();

            // Проверка на дубликаты
            if (applicants.containsKey(fullName)) {
                System.out.println("Обнаружен дубликат: " + fullName + " - используется последняя запись");
            }

            applicants.put(fullName, applicant);

        } catch (NumberFormatException e) {
            System.out.println("Пропущена строка с некорректными числами: " + line);
        }
    }

    private void analyzeResults() {
        for (Applicant applicant : applicants.values()) {
            if (applicant.isFailed()) {
                failedApplicants.add(applicant);
            }
        }
    }

    public Map<String, Applicant> getApplicants() {
        return Collections.unmodifiableMap(applicants);
    }

    public List<Applicant> getFailedApplicants() {
        return Collections.unmodifiableList(failedApplicants);
    }

    public int getTotalApplicants() {
        return applicants.size();
    }

    public int getAdmittedCount() {
        return applicants.size() - failedApplicants.size();
    }

    public int getFailedCount() {
        return failedApplicants.size();
    }

    public void printResults() {
        System.out.println("=".repeat(50));
        System.out.println("РЕЗУЛЬТАТЫ ПРЕДВАРИТЕЛЬНОГО ТЕСТИРОВАНИЯ");
        System.out.println("=".repeat(50));
        System.out.printf("Всего абитуриентов: %d%n", getTotalApplicants());
        System.out.printf("Допущено к экзаменам: %d%n", getAdmittedCount());
        System.out.printf("Не допущено: %d%n", getFailedCount());

        if (failedApplicants.isEmpty()) {
            System.out.println("\nВсе абитуриенты допущены к сдаче экзаменов!");
        } else {
            System.out.println("\nАбитуриенты, НЕ допущенные к сдаче экзаменов:");
            System.out.println("-".repeat(50));

            // Сортировка по фамилии и имени
            failedApplicants.sort(Comparator
                    .comparing(Applicant::getSurname)
                    .thenComparing(Applicant::getName));

            for (Applicant applicant : failedApplicants) {
                System.out.println(applicant);
            }
        }
    }

    public void printFailedApplicantsSimple() {
        if (failedApplicants.isEmpty()) {
            System.out.println("Все абитуриенты допущены к экзаменам");
            return;
        }

        System.out.println("Абитуриенты, не допущенные к сдаче экзаменов:");
        for (Applicant applicant : failedApplicants) {
            System.out.println(applicant.getFullName());
        }
    }
}

package two;
import java.util.Random;
import java.util.Scanner;


public class MindNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1;

        System.out.println("Выберите уровень сложности:");
        System.out.println("1 - Легкая (8 попыток)");
        System.out.println("2 - Средняя (5 попыток)");
        System.out.println("3 - Сложная (3 попытки)");
        System.out.print("Ваш выбор: ");

        int maxAttempts = 0;

        if (scanner.hasNextInt()) {
            int difficulty = scanner.nextInt();
            if (difficulty == 1) {
                maxAttempts = 8;
            } else if (difficulty == 2) {
                maxAttempts = 5;
            } else if (difficulty == 3) {
                maxAttempts = 3;
            } else {
                System.out.println("Неверный выбор сложности. Завершение программы.");
                scanner.close();
                return;
            }
        } else {
            System.out.println("Ошибка ввода. Завершение программы.");
            scanner.close();
            return;
        }

        System.out.println("\nЯ загадал число от 1 до 100. Попробуйте угадать!");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Попытка " + attempt + " из " + maxAttempts + ". Введите число: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Пожалуйста, введите целое число!");
                scanner.next();
                attempt--;
                continue;
            }

            int guess = scanner.nextInt();

            if (guess < 1 || guess > 100) {
                System.out.println("Предполагаемое число вне диапазона чисел (1-100).");
                continue;
            }

            if (guess < secretNumber) {
                System.out.println("Мое число больше");
            } else if (guess > secretNumber) {
                System.out.println("Мое число меньше");
            } else {
                System.out.println("Вы угадали! Количество попыток: " + attempt);
                scanner.close();
                return;
            }
        }

        System.out.println("Ваши попытки закончились! Вы проиграли!");
        System.out.println("Загаданное число было: " + secretNumber);
        scanner.close();
    }
}


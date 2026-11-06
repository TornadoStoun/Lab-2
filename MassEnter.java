package two;
import java.util.Arrays;
import java.util.Scanner;


public class MassEnter {
    public static void main(String[] args) {
        int[] numbers = {10, 25, 30, 45, 50};

        System.out.println("Текущий массив: " + Arrays.toString(numbers));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите действие:");
        System.out.println("1 - Добавить элемент");
        System.out.println("2 - Удалить элемент");
        System.out.print("Ваш выбор: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Неверный выбор, Введите 1 или 2");
            return;
        }

        int choice = scanner.nextInt();

        if (choice != 1 && choice != 2) {
            System.out.println("Неверный выбор, Введите 1 или 2");
            return;
        }

        if (choice == 1) {
            System.out.print("Введите целое число для добавления: ");
            int newElement = scanner.nextInt();

            int[] newArray = new int[numbers.length + 1];

            for (int i = 0; i < numbers.length; i++) {
                newArray[i] = numbers[i];
            }
            newArray[newArray.length - 1] = newElement;

            numbers = newArray;

        } else {
            System.out.print("Введите индекс элемента для удаления (от 0 до " + (numbers.length - 1) + "): ");
            int indexToRemove = scanner.nextInt();

            if (indexToRemove < 0 || indexToRemove >= numbers.length) {
                System.out.println("Ошибка, индекс выходит за границы массива");
                return;
            }

            int[] newArray = new int[numbers.length - 1];

            for (int i = 0, j = 0; i < numbers.length; i++) {
                if (i == indexToRemove) {
                    continue;
                }
                newArray[j++] = numbers[i];
            }

            numbers = newArray;
        }

        System.out.println("Обновленный массив: " + Arrays.toString(numbers));
        scanner.close();
    }
}


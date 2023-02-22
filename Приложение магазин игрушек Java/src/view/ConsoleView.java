package view;

import model.Toy;
import java.util.List;
import java.util.Scanner;

public class ConsoleView implements View {
    Scanner scn;
    public ConsoleView(){
        scn = new Scanner(System.in);
    }

    @Override
    public void getShowToys(List<Toy> toys) {
        System.out.println("Все добавленные игрушки: ");
        for (Toy t: toys) {
            System.out.println(t);
        }
    }

    @Override
    public void getShowResult(Toy toy, int count) {
        System.out.printf("Результат жеребьёвки #%d: " + toy + "\n", count+1);
    }

    @Override
    public int getToyId() {
        System.out.println("Введите идентификатор игрушки, которую хотите удалить: ");
        while (!scn.hasNextInt()) {
            System.out.println("Ошибка ввода! Введите целое число:");
            scn.next();
        }
        int number = scn.nextInt();
        return number;
    }

    @Override
    public void toyAdd(){
        System.out.println("\nИгрушка добавлена");
    }

    @Override
    public void toyDelete(){
        System.out.println("\n Игрушка удалена");
    }

    @Override
    public String getToyName() {
        String str;
        System.out.print("Введите название игрушки: \n");
        do {
            str = scn.nextLine();
        } while (str.isEmpty());
        return str;
    }

    @Override
    public int getToyWeight() {
        int number;
        do {
            System.out.println("Вес(частота выпадения) игрушки от 1 до 10: ");
            while (!scn.hasNextInt()) {
                System.out.println("Ошибка! Нужно ввести целое число.");
                scn.next();
            }
            number = scn.nextInt();
        } while (number < 1 || number > 10);
        return number;
        }

    @Override
    public void saveResult() {
        System.out.println("\nРезульаты сохранены в файл");
    }

    @Override
    public int countPutResult() {
        int number;
        do {
            System.out.println("Сколько раз произвести жеребёвку: ");
            while (!scn.hasNextInt()) {
                System.out.println("Ошибка! Нужно ввести целое число.");
                scn.next();
            }
            number = scn.nextInt();
        } while (number < 1 || number > 10);
        return number;
//        System.out.println("Сколько раз произвести жеребёвку: ");
//        return Integer.parseInt(scn.nextLine());
    }

    public void notFoundToy(){
        System.out.println("В магазине с этим идентификатором игрушек нет");
    }

    @Override
    public String choice() {
        System.out.println("""

                     1 - Показать все игрушки в магазине
                     2 - Добавить игрушку
                     3 - Удалить игрушку
                     4 - Провести жеребьёвку
                     q - Выход
                     
                    Ваш выбор: \s""");
        return scn.nextLine();
    }

    @Override
    public void hello() {
        System.out.println("Вас приветствует магазин игрушек, у нас вы сможете\n" +
                "добавить игрушку в корзину, удалить игрушку, и провести среди выбранных\n" +
                "игрушек жеребьевку!");
    }

    @Override
    public void bye() {
        System.out.println("Пока!");
    }
}

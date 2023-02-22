package view;

import presenter.Presenter;

public class Program {
    public static void buttnoclick(){
        Presenter presenter = new Presenter();
        ConsoleView c = new ConsoleView();

        String userSelect;
        c.hello();
        while (true){
            userSelect = c.choice();
            if (userSelect.equals("q")){
                c.bye();
                return;
            }
            try {
                switch (userSelect) {
                    case "1" -> presenter.showAll();
                    case "2" -> presenter.addToy();
                    case "3" -> presenter.deleteToy();
                    case "4" -> presenter.getRoll();
                    default -> System.out.println("\n Команда не найдена!");
                }
            } catch (Exception ex) {
                System.out.println("Error. " + ex.getMessage());
            }
        }
    }
}

package menu.print_options;

import menu.MenuOption;
import menu.main.BackToGeneral;

import java.util.LinkedHashMap;
import java.util.Map;


public class PrintMenu {
    private Map<Integer, MenuOption> print_menu_option;

    public PrintMenu() {
        print_menu_option = new LinkedHashMap<>();
        print_menu_option.put(1, new PrintGeneral("Загальний список"));
        print_menu_option.put(2, new PrintDetailed("Детальний список"));
        print_menu_option.put(3, new BackToGeneral("Повернутися у головне меню"));
    }

    public void execute(int command) {
        print_menu_option.getOrDefault(command, () -> System.out.println("wrong command! try again!"))
                .execute();
    }

    public void printOptions() {
        System.out.print("""
                ---------------------------------------------------
                Виберіть дію:
                1 - Загальний список
                2 - Детальний список
                3 - Повернутися у головне меню
                ---------------------------------------------------
                💁‍: """);
    }
}
package menu.fill_options;

import menu.MenuOption;
import menu.main.BackToGeneral;

import java.util.LinkedHashMap;
import java.util.Map;

public class FillTypeMenu {
    private Map<Integer, MenuOption> fill_menu_option;

    public FillTypeMenu(){
        fill_menu_option = new LinkedHashMap<>();
        fill_menu_option.put(1,new FillByHand("Завантажити вручну"));
        fill_menu_option.put(2,new FillRandFull("Завантажити випадковим чином до всього об'єму"));
        fill_menu_option.put(3,new FillRandByPrice("Завантажити випадковим чином на певну суму"));
        fill_menu_option.put(4,new BackToGeneral("Повернутися у головне меню"));
    }

    public void execute (int command){
        fill_menu_option.getOrDefault(command, ()-> System.out.println("wrong command! try again!"))
                .execute();
    }
    public void printOptions(){
        System.out.print("""
                ---------------------------------------------------
                Виберіть дію:
                1 - Завантажити вручну
                2 - Завантажити випадковим чином до всього об'єму
                3 - Завантажити випадковим чином на певну суму
                4 - Повернутися у головне меню
                ---------------------------------------------------
                💁‍: """);
    }
}

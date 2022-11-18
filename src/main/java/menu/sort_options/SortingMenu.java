package menu.sort_options;

import menu.MenuOptionVan;
import menu.main.BackToGeneral;
import van.Van;

import java.util.LinkedHashMap;
import java.util.Map;

public class SortingMenu {
    private Map<Integer, MenuOptionVan> sort_menu_option;
  public SortingMenu() {
      sort_menu_option = new LinkedHashMap<>();
      sort_menu_option.put(1, new SortASC("Відсортувати вміст за зростанням ціни (грн/кг)"));
      sort_menu_option.put(2, new SortDEC("Відсортувати вміст за спаданням ціни (грн/кг)"));
      sort_menu_option.put(3, new BackToGeneral("Повернутися у головне меню"));
  }
    public void execute (int command, Van van){
        sort_menu_option.getOrDefault(command, (v)-> System.out.println("wrong command! try again!"))
                .execute(van);
    }
    public void printOptions(){
        System.out.print("""
                ---------------------------------------------------
                Виберіть дію:
                1 - Відсортувати вміст за зростанням ціни (грн/кг)
                2 - Відсортувати вміст за спаданням ціни (грн/кг)
                3 - Повернутися у головне меню
                ---------------------------------------------------
                💁‍: """);
    }
}

package menu.main;

import menu.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class GeneralMenu {
    private Map<Integer, MenuOption> menu_option;
    public GeneralMenu(){
        menu_option = new LinkedHashMap<>();
        menu_option.put(1,new PrintOption("Вивести список фургонів"));
        menu_option.put(2,new FillOption("Завантажити новий фургон"));
        menu_option.put(3, new SortOption("Відсортувати вміст фургону"));
        menu_option.put(4, new FindOption("Знайти товар у фургоні"));
        menu_option.put(5, new DeleteOption("Видалити фургон"));
        menu_option.put(6,new ExitOption("Вихід з програми"));
    }
    public void execute (int command){
        menu_option.getOrDefault(command, ()-> System.out.println("wrong command! try again!"))
                .execute();
    }
    public void printOptions(){
        System.out.print("""
                ---------------------------------------------------
                Виберіть дію:
                1 - Вивести список фургонів
                2 - Завантажити новий фургон
                3 - Відсортувати вміст фургону
                4 - Знайти товар у фургоні за якістю
                5 - Видалити фургон
                6 - Вихід з програми
                ---------------------------------------------------
                💁‍: """);
    }
}

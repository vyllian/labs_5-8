package menu.delete_options;

import menu.MenuOption;
import menu.main.BackToGeneral;

import java.util.LinkedHashMap;
import java.util.Map;

public class DeleteMenu {

        private Map<Integer, MenuOption> delete_menu_option;

        public DeleteMenu(){
            delete_menu_option = new LinkedHashMap<>();
            delete_menu_option.put(1,new DeleteByID("Видалити фургон за ID"));
            delete_menu_option.put(2,new DeleteByFullness("Видалити фургони за заповненістю"));
            delete_menu_option.put(3,new BackToGeneral("Повернутися у головне меню"));
        }

        public void execute (int command){
            delete_menu_option.getOrDefault(command, ()-> System.out.println("wrong command! try again!"))
                    .execute();
        }
        public void printOptions(){
            System.out.print("""
                ---------------------------------------------------
                Виберіть дію:
                1 - Видалити фургон за ID
                2 - Видалити фургони за заповненістю
                3 - Повернутися у головне меню
                ---------------------------------------------------
                💁‍: """);
        }
}

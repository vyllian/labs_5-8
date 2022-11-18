package menu.print_options;

import database.Van_db;
import menu.MenuOption;
import van.Van;
import java.util.ArrayList;
import static functional.PrintMethods.printVanList;

public class PrintGeneral implements MenuOption {
    private final String name;
    public PrintGeneral(String name){
        this.name= name;
    }
    @Override
    public void execute() {
        Van_db van_db = new Van_db();
        ArrayList<Van> van_list = van_db.getAll();
        if (van_list.size()==0) {
            System.out.println("Список порожній, завантажте спершу фургон ^_^\n");
            return;
        }
        printVanList(van_list,"general");
    }
}

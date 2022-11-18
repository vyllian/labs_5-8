package menu.main;

import database.Van_db;
import menu.MenuOption;
import menu.sort_options.SortingMenu;
import van.Van;
import java.util.ArrayList;
import static functional.Input.*;
import static functional.PrintMethods.printVanList;

public class SortOption implements MenuOption {
    private final String name;
    public SortOption(String name){
        this.name= name;
    }
    @Override
    public void execute() {
        Van_db van_db=new Van_db();
        ArrayList<Van> van_list = van_db.getAll();
        printVanList(van_list,"general");
        System.out.print("Введіть id фургона для сортування: ");
        Van van = van_db.get(getVanId());
        SortingMenu sort = new SortingMenu();
        sort.printOptions();
        sort.execute(getInt(),van);
    }
}

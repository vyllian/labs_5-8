package menu.main;

import database.Van_db;
import menu.MenuOption;
import van.Van;
import java.util.ArrayList;
import static functional.Input.getVanId;
import static functional.PrintMethods.*;


public class FindOption implements MenuOption {

    private final String name;
    public FindOption(String name){
        this.name= name;
    }
    @Override
    public void execute() {
        Van_db van_db=new Van_db();
        ArrayList<Van> van_list = van_db.getAll();
        printVanList(van_list,"general");
        System.out.print("Виберіть фургон для пошуку: ");
        int id = getVanId();
        printCoffee(van_db.get(id).findCoffee());
    }
}

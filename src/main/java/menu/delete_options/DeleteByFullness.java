package menu.delete_options;

import database.Van_db;
import menu.MenuOption;
import static functional.Input.getInt0_Limit;
import static functional.PrintMethods.printVanList;

public class DeleteByFullness implements MenuOption {
    private String name;
    DeleteByFullness(String name){
        this.name=name;
    }

    @Override
    public void execute() {
        Van_db van_db = new Van_db();
        printVanList(van_db.getAll(),"general");
        System.out.print("Введіть % заповненості: ");
        van_db.deleteByFullness(getInt0_Limit(101));
        printVanList(van_db.getAll(),"general");
    }
}

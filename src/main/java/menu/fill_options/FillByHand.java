package menu.fill_options;

import database.Van_db;
import menu.MenuOption;
import van.Van;
import static functional.PrintMethods.printVanInfo;
import static van.Van.addVan;

public class FillByHand implements MenuOption {
    private String name;
    FillByHand(String name){
        this.name=name;
    }

    @Override
    public void execute() {
        Van van = addVan();
        Van_db van_db = new Van_db();
        van.fillByHand();
        van_db.insertVanWGoods(van);
        van.setId(van_db.getID(van));
        printVanInfo(van,"detailed");

    }
}

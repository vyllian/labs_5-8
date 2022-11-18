package menu.fill_options;

import database.Van_db;
import menu.MenuOption;
import van.Van;
import static functional.PrintMethods.printVanInfo;
import static van.Van.addVan;

public class FillRandFull implements MenuOption {
    private String name;
    FillRandFull(String name){
        this.name=name;
    }

    @Override
    public void execute() {
        Van_db van_db = new Van_db();
        Van van = addVan();
        van.fillRand("volume", 0);
        van_db.insertVanWGoods(van);
        van.setId(van_db.getID(van));
        printVanInfo(van,"detailed");

    }
}

package menu.sort_options;

import menu.MenuOptionVan;
import van.Van;
import static functional.PrintMethods.*;

public class SortASC implements MenuOptionVan {
    private String name;
    SortASC(String name){
        this.name=name;
    }

    @Override
    public void execute(Van van) {
        van.sorting("ASC");
        System.out.println("\nВідсортований вміст фургону:");
        printVanInfo(van,"goods");
    }
}

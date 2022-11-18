package menu.sort_options;

import menu.MenuOptionVan;
import van.Van;
import static functional.PrintMethods.*;

public class SortDEC implements MenuOptionVan {
    private String name;
    SortDEC(String name){
        this.name=name;
    }

    @Override
    public void execute(Van van) {
        van.sorting("DEC");
        System.out.println("\nВідсортований вміст фургону:");
        printVanInfo(van,"goods");
    }
}

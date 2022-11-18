package menu.main;

import menu.MenuOption;
import menu.MenuOptionVan;
import van.Van;
import static functional.Input.getInt;

public class BackToGeneral implements MenuOption , MenuOptionVan {
    private final String name;
    public BackToGeneral(String name){
        this.name= name;
    }
    @Override
    public void execute() {
        GeneralMenu menu = new GeneralMenu();
        menu.printOptions();
        menu.execute(getInt());
    }

    @Override
    public void execute(Van van) {
        this.execute();
    }
}

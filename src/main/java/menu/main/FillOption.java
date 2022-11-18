package menu.main;

import menu.MenuOption;
import menu.fill_options.FillTypeMenu;
import static functional.Input.getInt;

public class FillOption implements MenuOption {

    private final String name;
    public FillOption(String name){
        this.name= name;
    }
    @Override
    public void execute() {
        FillTypeMenu fill_menu = new FillTypeMenu();
        fill_menu.printOptions();
        fill_menu.execute(getInt());
    }
}

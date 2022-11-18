package menu.main;

import menu.MenuOption;
import menu.print_options.PrintMenu;
import static functional.Input.getInt;

public class PrintOption implements MenuOption {
    private final String name;
    public PrintOption(String name){
        this.name= name;
    }

    @Override
    public void execute() {
        PrintMenu print_menu = new PrintMenu();
        print_menu.printOptions();
        print_menu.execute(getInt());
    }
}

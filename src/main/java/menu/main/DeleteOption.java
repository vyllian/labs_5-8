package menu.main;

import menu.MenuOption;
import menu.delete_options.DeleteMenu;
import static functional.Input.getInt;

public class DeleteOption implements MenuOption {
    private final String name;
    public DeleteOption(String name){
        this.name= name;
    }
    @Override
    public void execute() {
        DeleteMenu delete_menu = new DeleteMenu();
        delete_menu.printOptions();
        delete_menu.execute(getInt());
    }
}

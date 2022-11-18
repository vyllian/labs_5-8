package menu.delete_options;

import database.Van_db;
import menu.MenuOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static functional.Input.getVanId;
import static functional.PrintMethods.printVanList;


public class DeleteByID implements MenuOption {
    private String name;
    DeleteByID(String name){
        this.name=name;
    }
    public static Logger logger = LogManager.getLogger(DeleteByID.class.getName());
    @Override
    public void execute() {
        Van_db van_db = new Van_db();
        printVanList(van_db.getAll(),"general");
        System.out.print("Введіть id фургону для видалення: ");
        van_db.delete(getVanId());
        printVanList(van_db.getAll(),"general");
    }

}

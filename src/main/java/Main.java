
import database.Van_db;
import menu.main.GeneralMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static functional.Input.*;

public class Main {
    public static Logger logger = LogManager.getLogger(Van_db.class.getName());
   public static void main(String[] args) {
       GeneralMenu menu = new GeneralMenu();
       logger.info("Запуск програми!");
       while(true){
            menu.printOptions();
            menu.execute(getInt());
       }
   }


}

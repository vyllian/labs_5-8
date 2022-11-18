package menu.main;

import database.Van_db;
import menu.MenuOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExitOption implements MenuOption {
    public static Logger logger = LogManager.getLogger(Van_db.class.getName());
    private final String name;
    public ExitOption(String name){
        this.name= name;
    }
    @Override
    public void execute() {
        logger.info("Кінець роботи, бувайте!");
        System.out.println("Бувайте! Гарного дня:)");
        System.exit(0);
    }
}

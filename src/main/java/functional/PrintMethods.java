package functional;

import coffee.Coffee;
import van.Van;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class PrintMethods {
    public static Logger logger = LogManager.getLogger(PrintMethods.class.getName());
    public static void printHat(){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("№   |        Фургон         | Заповненість (%) | Завантаженість (кг) | Вартість кави (грн)");
        System.out.println("------------------------------------------------------------------------------------------");
    }
    public static void printVanList(ArrayList<Van> van_list,String mode){
        logger.info("Виводимо список фургонів...");
        if (van_list==null){
            System.out.println("(список фургонів порожній)"); return;
        }
        System.out.println();
        for (int i = 0; i < van_list.size(); i++) {
            if (i==0 && mode.equals("general"))
                printHat();
            printVanInfo(van_list.get(i),mode);
            if (i != van_list.size() - 1 || mode.equals("general"))
                System.out.println("..........................................................................................");
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println();
    }
    public static void printVanInfo(Van van, String mode){
        logger.info("Виводимо інформацію про фургон {}.", van.getId());
        if (mode.equals("detailed"))
            printHat();
        if(!mode.equals("goods"))
            System.out.printf("%d | %21s |%10d%8s|%5s%5.0f/%-5d%5s|%13d\n", van.getId(), van.getVan_type().getName(),
                van.getFullness(), " ", " ", van.getGoods_weight(),van.getVan_type().getMax_weight(), " ", van.getGoods_price());
        if(mode.equals("detailed")||mode.equals("goods"))
            van.printGoods();

    }
    public static void printCoffee(ArrayList<Coffee> coffee_list){
        if (coffee_list.isEmpty()){
            logger.info("Не знайшли таку каву у фургоні(");
            System.out.println("Кави із заданими параметрами немає.");
            return;
        }
        logger.info("Виводимо список знайденої кави.");
        for(Coffee coffee: coffee_list)
            System.out.println(coffee);
    }
}


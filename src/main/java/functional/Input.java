package functional;

import database.Van_db;
import java.util.Scanner;


public class Input {
    static Scanner scan = new Scanner(System.in);

    public static int getInt (){
        while(true) {
            try {
                String value = scan.nextLine();
                int num = Integer.parseInt(value);
                if (num>0)
                    return num;
            } catch (NumberFormatException nfe) {
                System.out.print("Ой, щось не так... Спробуйте знову: ");
            }
        }
    }
    public static int getInt0_Limit (int limit){
        while(true) {
            try {
                int num = getInt();
                if (num > 0 && num < limit)
                    return num;
                else System.out.print("Ой, щось не так... Спробуйте знову: ");
            } catch (NumberFormatException nfe) {
                System.out.print("Ой, щось не так... Спробуйте знову: ");
            }
        }
    }

    public static Input_coffee_format getCoffeeLine(){
        Input_coffee_format values = new Input_coffee_format();
        while(true) {
            String line = scan.nextLine();
            String[] numbers = line.split(" ");
            if (numbers.length<4) {
                System.out.print("Ой, щось не так... Спробуйте знову: : ");
                continue;
            }
            try {
                values.setBrandCode(Integer.parseInt(numbers[0]));
                values.setTypeCode(Integer.parseInt(numbers[1]));
                values.setPackCode(Integer.parseInt(numbers[2]));
                values.setQualityCode(Integer.parseInt(numbers[3]));
            }catch (NumberFormatException nfe){
                System.out.print("Ой, щось не так... Спробуйте знову: : ");
                continue;
            }
            if (values.isCorrect()) break;
            System.out.print("Ой, щось не так... Спробуйте знову: : ");
        }
        return values;
    }
    public static boolean getYesNo(){
        String yes = "так", no = "ні";
        while (true) {
            String line = scan.nextLine();
            if (line.equalsIgnoreCase(yes)) return true;
            if (line.equalsIgnoreCase(no)) return false;
            System.out.print("Ой, щось не так... Введіть так або ні: ");
        }

    }
    public static int[] getQualityvalues(){
        String[] parts;
        int[] num;
        while(true){
            try {
                String line = scan.nextLine();
                parts= line.split("-");
                int size = parts.length == 1 ? 1 : Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]) + 1;
                num = new int[size];
                for (int i = 0; i < size; i++) {
                    if (i==0)
                        num[i] = Integer.parseInt(parts[i]);
                    else
                        num[i]=num[i-1]+1;
                }
                break;
            }catch(NumberFormatException er){
                System.out.print("Ой, щось не так... Спробуйте знову: ");
            }
        }
        return num;
    }

    public static int getVanId(){
        Van_db van_db=new Van_db();
        while(true) {
            try {
                String value = scan.nextLine();
                int id = Integer.parseInt(value);
                if (van_db.isVanExistById(id))
                    return id;
                else
                    System.out.print("Такого фургону не існує, введіть ще раз: ");
            } catch (NumberFormatException nfe) {
                System.out.print("Ой, щось не так... Спробуйте знову: ");
            }
        }
    }
}

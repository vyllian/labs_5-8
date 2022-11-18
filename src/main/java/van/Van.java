package van;

import coffee.Coffee;
import coffee.Coffee_block;
import functional.*;
import sorting.*;
import java.util.ArrayList;
import java.util.Random;
import static coffee.Coffee.randCoffee;
import static coffee.Coffee_block.createBlock;
import static coffee.Coffee_block_Volume.*;
import static functional.Input.*;
import static van.Van_type.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Van {
    public static Logger logger = LogManager.getLogger(Van.class.getName());
    private Van_type van_type;
    private int id=0; // id in database tables
    private int fullness=0;
    private double goods_weight=0;
    private double goods_volume=0;
    private int goods_price=0;
    private ArrayList<Blocks_amount> goods; // list of coffee blocks in the van

    /**
     * constructor
     * @param type type (1 of 3 available)
     */
    public Van(Van_type type) {
        this.van_type = type;
        this.goods = new ArrayList<>();
    }

    // getters
    public Van_type getVan_type() {
        return van_type;
    }
    public int getId() {
        return id;
    }
    public int getFullness() {
        return fullness;
    }
    public double getGoods_weight() {
        return goods_weight;
    }
    public int getGoods_price() {
        return goods_price;
    }

    public double getGoods_volume() {
        return goods_volume;
    }

    public ArrayList<Blocks_amount> getGoods() {
        return goods;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setGoods_weight(double goods_weight) {
        this.goods_weight += goods_weight;
    }
    public void setGoods_volume(double goods_volume) {
        this.goods_volume += goods_volume;
    }
    public void setGoods_price(int goods_price) {
        this.goods_price += goods_price;
    }

    public void setGoods(ArrayList<Blocks_amount> goods) {
        this.goods = goods;
    }

    public void setFullness(int fullness) {
        this.fullness = fullness;
    }

    /**
     * defines fullness of main.java.van in %
     * @return percent of fullness
     */
    public int determine_fullness() {
        return (int) (this.goods_volume / this.van_type.getVolume() * 100);
    }

    /**
     * defines if main.java.van is full by volume
     * @param block last added main.java.coffee block
     * @return true if full, false - otherwise
     */
    public boolean isFull_by_volume(Coffee_block block) {
        if (this.fullness >= 100){
            this.removeBlock(block);
            return true;
        }
        return false;
    }

    /**
     * defines if goods weight is smaller than max available
     * @param block last added main.java.coffee block
     * @return true if can't add more blocks, false - otherwise
     */
    public boolean isFull_by_weight(Coffee_block block) {
        if (this.goods_weight == this.van_type.getMax_weight())
            return true;
        if (this.goods_weight > this.van_type.getMax_weight()){
            this.removeBlock(block);
            return this.van_type.getMax_weight() - this.goods_weight < 200;
        }
        return false;
    }

    /**
     * defines if goods price is smaller than given
     * @param price given max price of goods
     * @param block last added main.java.coffee block
     * @return true if can't add more blocks, false - otherwise
     */
    public boolean ifFull_by_price(int price, Coffee_block block) {
        if (this.goods_price == price)
            return true;
        if (this.goods_price > price){
            this.removeBlock(block);
            return  price - this.goods_price < 60000;
        }
        return false;
    }

    /**
     * defines how much volume left in main.java.van
     * @return available volume
     */
    public double volumeLeft(){
        return this.van_type.getVolume()-this.goods_volume;
    }
    /**
     * removes block from main.java.van and edits its parameters
     * @param block block to remove
     */
    public void removeBlock(Coffee_block block){
        this.setGoods_volume(-block.getBlock_Volume().getCoffee_block_Volume());
        this.setGoods_weight(-block.getBlock_weight());
        this.setGoods_price(-block.getBlock_price());
        this.fullness = this.determine_fullness();
        int i = isExist(block);
        if (this.goods.get(i).getAmount()==1)
            this.goods.remove(i);
        else this.goods.get(i).decreaseAmount();
    }

    /**
     * sorts goods in main.java.van by grm=n/kg
     * @param order order to sort by
     */
    public void sorting(String order) {
        if (order.equals("ASC")) {
            this.goods.sort(new SortingASC());
            logger.info("Вміст фургону {} відсортовано за зростанням ціни/кг.",this.getId());
        }else if (order.equals("DEC")) {
            this.goods.sort(new SortingDEC());
            logger.info("Вміст фургону {} відсортовано за спаданням ціни/кг.",this.getId());
        }
    }
    /**
     * adds main.java.coffee block to array of goods and edits vans parameters
     * @param block block to add
     */
    public void addParametersOfCoffeeBlock (Coffee_block block){
        Blocks_amount blocks_amount =new Blocks_amount(block);
        int i=this.isExist(block);
        if (i>=0)
            this.goods.get(i).increaseAmount();
        else this.goods.add(blocks_amount);
        this.setGoods_volume(block.getBlock_Volume().getCoffee_block_Volume());
        this.fullness = this.determine_fullness();
        this.setGoods_weight(block.getBlock_weight());
        this.setGoods_price(block.getBlock_price());
    }

    /**
     * checks if there already is such main.java.coffee block in the main.java.van
     * @param block block to check
     * @return index of block in the list or - if not found
     */
    public int isExist(Coffee_block block){
        for(int i = 0;i<this.goods.size();i++){
            if (block.isEqual(this.goods.get(i).getBlock()))
                return i;
        }
        return -1;}


    public static Van addVan() {
        printVanType();
        Van_type van_type;
        while (true) {
            int codetype = getInt();
            van_type = getType(codetype);
            if (van_type != null)
                break;
            System.out.print("Введіть ще раз: ");
        }
        return new Van(van_type);
    }

    /**
     * manual goods array filling with coffee blocks
     */
    public void fillByHand() {
        logger.info("Завантяження нового фургона вручну.");
        int blockSizeAccess = 3;
        do {
            Coffee_block block= createBlock(blockSizeAccess);
            this.addParametersOfCoffeeBlock(block);
            if (this.isFull_by_volume(block)|| this.isFull_by_weight(block)){
                System.out.print("Фургон заповнений");
                break;
            }
            if (this.volumeLeft() < LARGE_BLOCK.getCoffee_block_Volume() && this.volumeLeft()>= MEDIUM_BLOCK.getCoffee_block_Volume())
                blockSizeAccess = 2;
            else if (this.volumeLeft()< MEDIUM_BLOCK.getCoffee_block_Volume())
                blockSizeAccess=1;
            System.out.print("Ще один блок? так/ні: ");
        }while (getYesNo());
    }

    /**
     * random vans goods array filling with main.java.coffee blocks
     * @param By type of filling ( either by price or by volume)
     * @param price max goods price if filling by price, any number if by volume
     */
    public void fillRand(String By, int price) {
        logger.info("Завантаження нового фургона автоматично");
        Random rand = new Random();
        int max = 3;
        while (true) {
            Coffee coffee = randCoffee();
            Coffee_block block = new Coffee_block(getCoffee_block_Volume(rand.nextInt(max) + 1), coffee);
            this.addParametersOfCoffeeBlock(block);
            if (By.equals("price")) {
                if (this.ifFull_by_price(price, block)) break;
            }
            if (this.isFull_by_volume(block)||this.isFull_by_weight(block)) break;
            if (this.volumeLeft() < LARGE_BLOCK.getCoffee_block_Volume() && this.volumeLeft()>= MEDIUM_BLOCK.getCoffee_block_Volume())
                max = 2;
            if (this.volumeLeft()< MEDIUM_BLOCK.getCoffee_block_Volume())
                max=1;
        }
    }

    /**
     * findscoffee by quality range in main.java.van
     * @return array of found main.java.coffee objects
     */
    public ArrayList<Coffee> findCoffee(){
        System.out.print("""
                        Введіть значення/діапазон якості кави: (формат: 1/1-4)
                        1 - AA (краща)
                        2 - AB (гарна)
                        3 - BA (середня)
                        4 - BB (низька)
                        💁:""");
        int[] range = getQualityvalues();
        ArrayList<Coffee> coffeeByQuality = new ArrayList<>();
        logger.info("Пошук кави у фургоні {} за якістю.",this.getId());
        for (Blocks_amount good : this.goods) {
            for (int k : range)
                if (good.getBlock().getCoffee().getQuality().getQuality_id() == k)
                    coffeeByQuality.add(good.getBlock().getCoffee());
        }
        return coffeeByQuality;
    }


    public void printGoods(){
        if (this.goods.isEmpty()){
            System.out.println("Фургон порожній...");
            return;
        }
       System.out.println("Вміст:");
       for (Blocks_amount block : this.goods) {
           System.out.printf("%s - %d\n", block.getBlock(), block.getAmount());
       }
   }
}

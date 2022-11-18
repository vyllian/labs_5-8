package coffee;

import static coffee.Coffee.print_coffee_options;
import static coffee.Coffee_block_Volume.getCoffee_block_Volume;
import static coffee.Coffee_block_Volume.printCoffee_block_Volume;
import static functional.Input.*;
import functional.Input_coffee_format;

public class Coffee_block {
    private final Coffee_block_Volume block_volume;
    private Coffee coffee;
    private final int block_price;
    private final double block_weight;

    public Coffee_block(Coffee_block_Volume volume, Coffee coffee){
        this.coffee = coffee;
        this.block_volume = volume;
        int packs_number = (int) (this.block_volume.block_volume / coffee.getPacking_type().volume);
        this.block_price = packs_number *coffee.getPrice();
        this.block_weight = packs_number * coffee.getPacking_type().weight;

    }
    public Coffee_block_Volume getBlock_Volume() {
        return block_volume;
    }
    public Coffee getCoffee() {
        return coffee;
    }
    public double getBlock_weight() {
        return block_weight;
    }
    public int getBlock_price() {
        return block_price;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    /**
     * compares 2 blocks
     * @param another block to compare with
     * @return true if equal, else - false
     */
    public boolean isEqual(Coffee_block another){
        if (this.block_volume != another.getBlock_Volume())
            return false;
        return this.coffee.isEqual(another.getCoffee());
    }

    /**
     * creates main.java.coffee block
     * @param blockAvailableSize defines which type of block volume is available
     * @return created block
     */
    public static Coffee_block createBlock(int blockAvailableSize){
        print_coffee_options();
        Input_coffee_format values = getCoffeeLine();
        Coffee coffee = new Coffee(values.getBrandCode(), values.getTypeCode(), values.getPackCode(),values.getQualityCode());
        if (blockAvailableSize == 1)
            System.out.println("малий блок (єдиний доступний за об'ємом)");
        else printCoffee_block_Volume(blockAvailableSize);
        Coffee_block_Volume volume;
        int codetype;
        while (true) {
            if (blockAvailableSize == 1)
                codetype = 1;
            else codetype = getInt0_Limit(blockAvailableSize+1);
            volume = getCoffee_block_Volume(codetype);
            if (volume != null)
                break;
            System.out.print("Упс! Введіть знову: ");
        }
        Coffee_block block = new Coffee_block(volume,coffee);
        return block;
    }

    @Override
    public String toString() {
        return  block_volume.title + " блок { " + coffee +'}' ;
    }
}
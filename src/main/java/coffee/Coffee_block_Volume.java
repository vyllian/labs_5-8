package coffee;

public enum Coffee_block_Volume {
    SMALL_BLOCK(1,1, "малий"),
    MEDIUM_BLOCK(2,1.5,"середній"),
    LARGE_BLOCK(3,2,"великий");
    final int typecode;
    final double block_volume;
    final String title;
    Coffee_block_Volume(int typecode,double block_volume, String title){
        this.typecode = typecode;
        this.block_volume=block_volume;
        this.title=title;
    }
    public double getCoffee_block_Volume() {
        return block_volume;
    }

   /*  public String getTitle() {
        return title;
    }*/

    public int getVol_id() {
        return typecode;
    }

    public static Coffee_block_Volume getCoffee_block_Volume(int typecode) {
        for (Coffee_block_Volume vol : Coffee_block_Volume.values() ){
            if (vol.typecode == typecode)
                return vol;
        }
        return null;
    }
    public static void printCoffee_block_Volume(int available){
        if (available==3)
            System.out.print("""
                ---------------------------------------------------
                Виберіть розмір блоку:
                1 - малий (1 м^3)
                2 - середній (1.5 м^3)
                3 - великий (2 м^3)
                💁‍:""");
        else
            System.out.print("""
                ---------------------------------------------------
                Виберіть розмір блоку:
                1 - малий (1 м^3)
                2 - середній (1.5 м^3)
                💁‍:""");

    }
}

package functional;

public class Input_coffee_format {
    private int brandCode;
    private int typeCode;
    private int packCode;
    private int qualityCode;
    public Input_coffee_format(){};
    public Input_coffee_format(int brandCode, int typeCode, int packCode, int qualityCode) {
        this.brandCode = brandCode;
        this.typeCode = typeCode;
        this.packCode = packCode;
        this.qualityCode = qualityCode;
    }

    public int getBrandCode() {
        return brandCode;
    }
    public int getTypeCode() {
        return typeCode;
    }
    public int getPackCode() {
        return packCode;
    }

    public int getQualityCode() {
        return qualityCode;
    }

    public void setQualityCode(int qualityCode) {
        this.qualityCode = qualityCode;
    }

    public void setBrandCode(int brandCode) {
        this.brandCode = brandCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public void setPackCode(int packCode) {
        this.packCode = packCode;
    }

    public boolean isCorrect(){
        if (this.brandCode < 1 || this.brandCode > 3) return false;
        if (this.typeCode < 1 || this.typeCode > 4) return false;
        if (this.qualityCode <1 || this.qualityCode >4) return false;
        return this.packCode >= 1 && this.packCode <= 3;
    }
}

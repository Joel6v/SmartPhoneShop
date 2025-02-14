package Model.Enum;

public enum Brand {
    APPLE ("Apple"),
    SAMSUNG ("Samsung"),
    HUAWEI ("Huawei"),
    ASUS ("Asus"),
    XIAOMI ("Xiaomi"),
    NOTHING ("Nothing"),
    GOOGLE ("Google LLC"),
    MICROSOFT ("Microsoft");

    private final String fullName;

    Brand(String fullName){
        this.fullName = fullName;
    }

    public static Brand convertString(String str){
        for(Brand brand : Brand.values()){
            if(brand.fullName.equals(str)){
                return brand;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return fullName;
    }
}

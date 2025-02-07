package Model;

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

    @Override
    public String toString(){
        return fullName;
    }
}

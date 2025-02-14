package Model.Enum;

public enum Os {
    IOS ("iOS"),
    ANDROID ("Android");

    private final String fullName;

    Os(String fullName){
        this.fullName = fullName;
    }

    public static Os convertString(String str){
        for(Os os : Os.values()){
            if(os.fullName.equals(str)){
                return os;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return fullName;
    }
}

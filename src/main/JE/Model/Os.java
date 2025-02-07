package Model;

public enum Os {
    IOS ("iOS"),
    ANDROID ("Android");

    private final String fullName;

    Os(String fullName){
        this.fullName = fullName;
    }

    @Override
    public String toString(){
        return fullName;
    }
}

package Model;

public enum MobileStandard {
    G2 ("2 G"),
    G2_5 ("2.5 G"),
    G2_75 ("2.75 G"),
    G3 ("3 G"),
    G3_5 ("3.5 G"),
    G3_9 ("3.9 G"),
    G4 ("4 G"),
    G4_5 ("4.5 G"),
    G5 ("5 G");

    public final String fullName;

    MobileStandard(String fullName){
        this.fullName = fullName;
    }

    @Override
    public String toString(){
        return fullName;
    }
}

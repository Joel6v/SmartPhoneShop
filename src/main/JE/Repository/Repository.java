package Repository;

import java.util.ArrayList;

public abstract class Repository<ModelType> {
    public static String dbName = "smartphone_shop";
    public abstract void save(ArrayList<ModelType> models);
    public abstract ArrayList<ModelType> load();
}

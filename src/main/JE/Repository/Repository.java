package Repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Objects;

import Model.Model;

public class Repository<ModelType extends Model> {
    private final String dbName = "smartphoneshop";
    private String collectionName;

    public Repository(String collectionName) {
        this.collectionName = collectionName;
        createCollection();
    }

    public ArrayList<ModelType> load() {
        MongoCollection<Document> collection = getDatabase().getCollection(collectionName);
        return (ArrayList<ModelType>) collection;
    }

    private void createCollection() {
        MongoDatabase db = getDatabase();

        for (String str : db.listCollectionNames()) {
            if (str.equals(collectionName)) {
                return;
            }
        }
        getDatabase().createCollection(collectionName);
    }

    public void save(ArrayList<ModelType> elements) {
        ArrayList<Document> docs = new ArrayList<>();
        for (ModelType element : elements) {
            Document doc = new Document("", );
        }
        getDatabase().getCollection(collectionName).insertMany(elements);
    }

    private MongoDatabase getDatabase(){
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        MongoCredential credential;
        credential = MongoCredential.createCredential("joel", dbName,
                "helloWorld123".toCharArray());

        return mongoClient.getDatabase(dbName);
    }
}

package Repository;

import Model.Smartphone;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class SmartphoneRepository extends Repository<Smartphone>{
    private final String collectionName = "smartphone";

    public SmartphoneRepository() {
        createCollection();
    }

    public ArrayList<Smartphone> load() {
        ArrayList<Smartphone> smartphones = new ArrayList<>();
        MongoCollection<Document> docs = getDatabase().getCollection(collectionName);
        for (Document document : docs.find()) {
            smartphones.add(new Smartphone(document));
        }
        return smartphones;
    }

    private void createCollection() {
        MongoDatabase db = getDatabase();
        if (!db.listCollectionNames().into(new ArrayList<>()).contains(collectionName)) {
            db.createCollection(collectionName);
        }
    }

    public void save(ArrayList<Smartphone> smartphones) {
        ArrayList<Document> docs = new ArrayList<>();
        for (Smartphone smartphone : smartphones) {
            docs.add(smartphone.toDocument());
        }
        if(!docs.isEmpty()) {
            getDatabase().getCollection(collectionName).insertMany(docs);
        }
    }

    private MongoDatabase getDatabase() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoCredential credential = MongoCredential.createCredential("joel", dbName, "helloWorld123".toCharArray());
        return mongoClient.getDatabase(dbName);
    }
}
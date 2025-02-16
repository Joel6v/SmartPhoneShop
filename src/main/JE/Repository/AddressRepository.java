package Repository;

import Model.Address;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class AddressRepository extends Repository<Address> {
    private final String collectionName = "address";

    public AddressRepository() {
        createCollection();
    }

    public ArrayList<Address> load() {
        ArrayList<Address> addresses = new ArrayList<>();
        MongoCollection<Document> docs = getDatabase().getCollection(collectionName);
        for (Document document : docs.find()) {
            addresses.add(new Address(document));
        }
        return addresses;
    }

    private void createCollection() {
        MongoDatabase db = getDatabase();
        if (!db.listCollectionNames().into(new ArrayList<>()).contains(collectionName)) {
            db.createCollection(collectionName);
        }
    }

    public void save(ArrayList<Address> addresses) {
        ArrayList<Document> docs = new ArrayList<>();
        for (Address address : addresses) {
            docs.add(address.toDocument());
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



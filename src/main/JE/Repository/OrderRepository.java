package Repository;

import Model.Order;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class OrderRepository extends Repository<Order>{
    private final String collectionName = "order";

    public OrderRepository() {
        createCollection();
    }

    public ArrayList<Order> load() {
        ArrayList<Order> orders = new ArrayList<>();
        MongoCollection<Document> docs = getDatabase().getCollection(collectionName);
        for (Document document : docs.find()) {
            orders.add(new Order(document));
        }
        return orders;
    }

    private void createCollection() {
        MongoDatabase db = getDatabase();
        if (!db.listCollectionNames().into(new ArrayList<>()).contains(collectionName)) {
            db.createCollection(collectionName);
        }
    }

    public void save(ArrayList<Order> orders) {
        ArrayList<Document> docs = new ArrayList<>();
        for (Order order : orders) {
            docs.add(order.toDocument());
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


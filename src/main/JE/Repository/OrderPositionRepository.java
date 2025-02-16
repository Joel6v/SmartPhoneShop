package Repository;

import Model.OrderPosition;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class OrderPositionRepository extends Repository<OrderPosition> {
    private final String collectionName = "order_position";

    public OrderPositionRepository() {
        createCollection();
    }

    public ArrayList<OrderPosition> load() {
        ArrayList<OrderPosition> orderPositions = new ArrayList<>();
        MongoCollection<Document> docs = getDatabase().getCollection(collectionName);
        for (Document document : docs.find()) {
            orderPositions.add(new OrderPosition(document));
        }
        return orderPositions;
    }

    private void createCollection() {
        MongoDatabase db = getDatabase();
        if (!db.listCollectionNames().into(new ArrayList<>()).contains(collectionName)) {
            db.createCollection(collectionName);
        }
    }

    public void save(ArrayList<OrderPosition> orderPositions) {
        ArrayList<Document> docs = new ArrayList<>();
        for (OrderPosition orderPosition : orderPositions) {
            docs.add(orderPosition.toDocument());
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


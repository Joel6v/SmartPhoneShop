package Repository;

import Model.Customer;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class CustomerRepository extends Repository<Customer>{
    private final String collectionName = "customer";

    public CustomerRepository() {
        createCollection();
    }

    public ArrayList<Customer> load() {
        ArrayList<Customer> customers = new ArrayList<>();
        MongoCollection<Document> docs = getDatabase().getCollection(collectionName);
        for(Document document : docs.find()) {
            customers.add(new Customer(document));
        }
        return customers;
    }

    private void createCollection() {
        MongoDatabase db = getDatabase();
        if (!db.listCollectionNames().into(new ArrayList<>()).contains(collectionName)) {
            db.createCollection(collectionName);
        }
    }

    public void save(ArrayList<Customer> customers) {
        ArrayList<Document> docs = new ArrayList<>();
        for (Customer customer : customers) {
            docs.add(customer.toDocument());
        }
        if(!docs.isEmpty()) {
            getDatabase().getCollection(collectionName).insertMany(docs);
        }
    }

    private MongoDatabase getDatabase(){
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        MongoCredential credential;
        credential = MongoCredential.createCredential("joel", dbName,
                "helloWorld123".toCharArray());

        return mongoClient.getDatabase(dbName);
    }
}

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;

public class Main {

    public static void main(String[] args) {

        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("vemsersbc");

        MongoCollection<Document> carro = mongoDatabase.getCollection("carro");

        // Novo carro
        Document novoCarro = new Document("modelo","Celta")
                .append("Status", "DISPONIVEL")
                .append("marca", "Chevrolet")
                .append("preco_diaria", Arrays.asList(100, 120, 130));
        Document novoCarro1 = new Document("modelo","Fusca")
                .append("Status", "INDISPONIVEL")
                .append("marca", "Wolksvagen")
                .append("preco_diaria", Arrays.asList(50, 60, 70));
        Document novoCarro2 = new Document("modelo","Fiesta")
                .append("Status", "DISPONIVEL")
                .append("marca", "Ford")
                .append("preco_diaria", Arrays.asList(100, 120, 130));
        Document novoCarro3 = new Document("modelo","Siena")
                .append("Status", "DISPONIVEL")
                .append("marca", "Fiat")
                .append("preco_diaria", Arrays.asList(90, 110, 120));


        //Insert
        carro.insertOne(novoCarro);
        carro.insertOne(novoCarro1);
        carro.insertMany(List.of(novoCarro2, novoCarro3));

        carro.updateOne(Filters.eq("modelo", "Celta"), new Document("$set", new Document("status" , "INDISPONIVEL")));

        carro.deleteOne(Filters.eq("marca" , "Jepp"));

        //Find
        System.out.println(carro.find(new Document("marca", "Chevrolet")).first());
        carro.find().sort(Sorts.ascending("preco_diaria")).iterator().forEachRemaining(System.out::println);

        //Delete
        carro.deleteOne(Filters.eq("modelo", "Onix"));
        carro.deleteOne(Filters.eq("marca", "Chevrolet"));

        //Aggregate
        carro.aggregate(Arrays.asList(
                        match(Filters.empty()),
                        group("$preco_diaria", Accumulators.sum("preco_diaria", 1))))
                .iterator().forEachRemaining(System.out::println);

        carro.aggregate(
                Arrays.asList(
                        match(Filters.eq("modelo", "Elegance")),
                        group("$modelo", Accumulators.sum("modelo", "$modelo"))
                )).iterator().forEachRemaining(System.out::println);

        //Projections

        carro.find()
                .projection(Projections.exclude("_id", "modelo", "status"))
                .iterator()
                .forEachRemaining(System.out::println);

        carro.find()
                .projection(Projections.exclude( "preco_diaria", "placa"))
                .iterator()
                .forEachRemaining(System.out::println);

        mongoClient.close();
    }
}

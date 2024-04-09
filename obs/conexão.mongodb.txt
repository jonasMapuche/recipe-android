package br.com.stomach.recipe.helpers;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.UuidRepresentation;
import org.bson.codecs.UuidCodec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import br.com.stomach.recipe.models.EquationModel;

public class ConnectRecipe {

    private String ConnectionName = "mongodb://jonas:freedown@cluster0-shard-00-00.28oko.azure.mongodb.net:27017,cluster0-shard-00-01.28oko.azure.mongodb.net:27017,cluster0-shard-00-02.28oko.azure.mongodb.net:27017/?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true&w=majority";
    //private String ConnectionName = "mongodb+srv://jonas:freedown@cluster0.28oko.azure.mongodb.net/letterDB?retryWrites=true&w=majority";
    //private String ConnectionName = "mongodb+srv://jonas:freedown@cluster0.28oko.azure.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private String DatabaseName = "letterDB";
    private String Collection = "equation";
    public MongoCollection ConnectDB () {
        try {
            MongoClientURI mongoClientURI = new MongoClientURI(ConnectionName);
            CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                    CodecRegistries.fromCodecs(new UuidCodec(
                            UuidRepresentation.STANDARD)), MongoClient
                            .getDefaultCodecRegistry());
            MongoClient mongo = new MongoClient(mongoClientURI);
            MongoDatabase db = mongo.getDatabase(DatabaseName).withCodecRegistry(codecRegistry);
            MongoCollection<EquationModel> collection = db.getCollection(Collection, EquationModel.class);
            //EquationModel doc = collection.aggregate()


            //_recipeCollection = collection;
            //double value = collection.count();
            //EquationModel col = collection.find().first();
        } catch (Exception e) {
            e.toString();
        }
        return null;
    }
}

package it.unibo.sistemidigitali.exam.jhon_ai.mongodb;

import android.content.Context;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import io.realm.mongodb.App;
import io.realm.mongodb.RealmResultTask;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;
import io.realm.mongodb.mongo.iterable.MongoCursor;
import it.unibo.sistemidigitali.exam.jhon_ai.UtteranceAdapter;
import it.unibo.sistemidigitali.exam.jhon_ai.model.Movie;
import it.unibo.sistemidigitali.exam.jhon_ai.model.Speaker;
import it.unibo.sistemidigitali.exam.jhon_ai.model.Utterance;

public class MongoDb {

    static  String  SERVICE_NAME = "mongodb-atlas";
    static  String  DATABASE_NAME ="databaseSD";
    static  String  COLLECTION_NAME ="movie_collection_complete";

    public static MongoCollection<Document> mongoConnection(App app){

        User user = app.currentUser();
        MongoClient mongoClient = user.getMongoClient(SERVICE_NAME);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(DATABASE_NAME);
        return mongoDatabase.getCollection(COLLECTION_NAME);



    }

    }



package it.unibo.sistemidigitali.exam.jhon_ai.model;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass(embedded = true)
public class MovieCollectionCompleteSpeaker extends RealmObject {
    private String id;

    private String name;

    // Standard getters & setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

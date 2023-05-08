package it.unibo.sistemidigitali.exam.jhon_ai.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

import org.bson.types.ObjectId;

public class MovieCollectionComplete extends RealmObject {
    @PrimaryKey
    private ObjectId _id;

    private String conversation_id;

    private String id;

    private MovieCollectionCompleteMovie movie;

    private MovieCollectionCompleteSpeaker speaker;

    private String text;

    // Standard getters & setters
    public ObjectId get_id() { return _id; }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getConversationId() { return conversation_id; }
    public void setConversationId(String conversation_id) { this.conversation_id = conversation_id; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public MovieCollectionCompleteMovie getMovie() { return movie; }
    public void setMovie(MovieCollectionCompleteMovie movie) { this.movie = movie; }

    public MovieCollectionCompleteSpeaker getSpeaker() { return speaker; }
    public void setSpeaker(MovieCollectionCompleteSpeaker speaker) { this.speaker = speaker; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}




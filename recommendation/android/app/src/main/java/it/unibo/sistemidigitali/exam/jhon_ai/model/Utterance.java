package it.unibo.sistemidigitali.exam.jhon_ai.model;

import org.bson.types.ObjectId;

public class Utterance  {

//   @PrimaryKey
    private ObjectId _id = new ObjectId();

 //  @BsonProperty("_partition")
   private String id;
    private String text;
    private String conversation_id;
     Speaker speaker;

     Movie movie;
    public Utterance() {

    }

    public Utterance(ObjectId _id, String id, String text, String conversation_id, Speaker speaker, Movie movie) {
        this._id = _id;
        this.id = id;
        this.text = text;
        this.conversation_id = conversation_id;
        this.speaker = speaker;
        this.movie = movie;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String speaker_link) {
        this.conversation_id = speaker_link;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Utterance{" +
                "_id=" + _id +
                ", id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", conversation_id='" + conversation_id + '\'' +
                ", speaker=" + speaker +
                ", movie=" + movie +
                '}';
    }
}

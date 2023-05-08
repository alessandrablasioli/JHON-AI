package it.unibo.sistemidigitali.exam.jhon_ai.model;

//@RealmClass(embedded = true)
public class Speaker  {
    private String id;
    private String name;

    public Speaker() {
    }

    public Speaker(String id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "Speaker{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

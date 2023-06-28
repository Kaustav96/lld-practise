package interview.flipkart.lld.models;

import java.util.UUID;

public class Users {
    private String id;
    private String name;
    private String profession;

    public Users(String name, String profession) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

package interview.flipkart.lld.models;

import java.util.UUID;

public class Topics {
    private String id;
    private String topicName;

    public Topics(String topicName) {
        this.id = UUID.randomUUID().toString();
        this.topicName = topicName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}

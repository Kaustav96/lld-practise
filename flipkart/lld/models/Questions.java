package interview.flipkart.lld.models;

import java.util.UUID;

public class Questions {
    private String questionName;
    private String questionAnswer;
    private boolean isAnswered;
    private String id;
    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Questions(String questionName, String questionAnswer) {
        this.id = UUID.randomUUID().toString();
        this.questionName = questionName;
        this.questionAnswer = questionAnswer;
    }
    public Questions(String questionName) {
        this.id = UUID.randomUUID().toString();
        this.questionName = questionName;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public boolean isAnswered() {
        return isAnswered;
    }
}

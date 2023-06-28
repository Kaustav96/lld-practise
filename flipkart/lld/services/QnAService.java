package interview.flipkart.lld.services;

import interview.flipkart.lld.models.Questions;
import interview.flipkart.lld.models.Topics;
import interview.flipkart.lld.models.Users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QnAService {

    private Map<String, Users> usersMap;
    private Map<String, Topics> topicsMap;
    private Map<String, Questions> questionsMap;
    private Map<String, List<Topics>> userTopicMap;
    private Map<String, List<String>> questionTopicMap;
    private Map<String, String> questionAnswerMap;

    public QnAService() {
        this.usersMap = new HashMap<>();
        this.questionsMap = new HashMap<>();
        this.userTopicMap = new HashMap<>();
        this.topicsMap = new HashMap<>();
        this.questionTopicMap = new HashMap<>();
        this.questionAnswerMap = new HashMap<>();
    }

    // ===================== user service starts ===============
    public void addUsers(Users users) {
        usersMap.put(users.getId(),users);
        System.out.println("User "+ users.getName()+" logged in.");
    }
    public void subscribeTopics(Users users, List<Topics> topicList){
        for(Topics topic : topicList){
            topicsMap.put(topic.getId(),topic);
        }
        userTopicMap.put(users.getId(),topicList);
        System.out.println("User "+ users.getName()+" subscribed to topics - ");
        for(Topics topic : topicList){
            System.out.println(topic.getTopicName());
        }
    }
    public void logout(Users users){
        System.out.println("User "+usersMap.get(users.getId()).getName()+" logged out");
        usersMap.remove(users.getId());
    }
    // ===================== user service ends ===============

    // ===================== question service starts ===============
    public void addQuestion(Questions questions, List<String> topics){
        questionsMap.put(questions.getId(),questions);
        questions.setAnswered(false);
        questionTopicMap.put(questions.getId(),topics);
        System.out.println("Question has been added and is related to topics - "+topics);
    }
    public void answerQuestion(String question ,String answer){
        // check if question is present
        boolean flag = false;
        for(Map.Entry<String,Questions> entry : questionsMap.entrySet()){
            if(entry.getValue().getQuestionName().equalsIgnoreCase(question)){
                flag = true;
                questionAnswerMap.put(entry.getKey(),answer);
                entry.getValue().setAnswered(true);
                System.out.println("Question has been answered");
                break;
            }
        }
        if(flag==false){
            System.out.println("Question not available in list");
        }
    }

    public Map<String, Questions> getQuestionsMap() {
        return questionsMap;
    }

    public Map<String, List<String>> getQuestionTopicMap() {
        return questionTopicMap;
    }

    public Map<String, String> getQuestionAnswerMap() {
        return questionAnswerMap;
    }
    // ===================== question service ends ===============


    // ===================== feed service starts ===============
    public void showFeed() {
        // show all questions
        for(Map.Entry<String, Questions> entry: questionsMap.entrySet()){
            System.out.println(entry.getValue().getQuestionName());
            System.out.print("Question has been answered - ");
            if(entry.getValue().isAnswered()){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    public void showFeedByFilter(String filter){
        System.out.println("Questions by filter - "+filter);
        for(Map.Entry<String,List<String>> entry : questionTopicMap.entrySet()){
            if(entry.getValue().contains(filter)){
                System.out.println(this.questionsMap.get(entry.getKey()).getQuestionName());
            }
        }
    }

    public void showFeedByAnswers(boolean isAnswered) {
        System.out.println("Questions filtered by answers present - "+isAnswered);
        for(Map.Entry<String, Questions> entry: questionsMap.entrySet()){
            if(entry.getValue().isAnswered()==isAnswered){
                System.out.println(entry.getValue().getQuestionName());
            }
        }
    }
    // ===================== feed service ends ===============
}

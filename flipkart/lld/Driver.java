package interview.flipkart.lld;

import interview.flipkart.lld.models.Questions;
import interview.flipkart.lld.models.Topics;
import interview.flipkart.lld.models.Users;
import interview.flipkart.lld.services.QnAService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        QnAService questionService = new QnAService();

        Scanner sc = new Scanner(System.in);

        int ch = 1;
        Users users = null;
        System.out.println("How many users are there - ");
        int noOfUsers = sc.nextInt();
        for(int i=0;i<noOfUsers;i++) {
            List<Topics> topicList = new ArrayList<>();
            System.out.println("Enter user details ");
            String userName = sc.next();
            String userProfession = sc.next();
            // user signup
            users = new Users(userName, userProfession);
            questionService.addUsers(users);
            sc.nextLine();
            // user subscribe to topics
            System.out.println("Enter number of topics to subscribe");
            int noTopics = sc.nextInt();
            System.out.println("Give the list of topics to subscribe");

            for (int j = 0; j < noTopics; j++) {
                String topic = sc.next();
                topicList.add(new Topics(topic));
            }

            questionService.subscribeTopics(users, topicList);
            while (ch != 0) {
                // add questions
                sc.nextLine();
                System.out.println("Enter the question - ");
                String questionName = sc.nextLine();
                System.out.println("How many topics it belongs to - ");
                List<String> topicQuestion = new ArrayList<>();
                int topicQues = sc.nextInt();
                for (int j = 0; j < topicQues; j++) {
                    String topic = sc.next();
                    topicQuestion.add(topic);
                }

                questionService.addQuestion(new Questions(questionName), topicQuestion);

                sc.nextLine();
                System.out.println("Do you want to add more questions press 1");
                ch = sc.nextInt();
            }

            ch = 0;
            while (ch != 1) {
                System.out.println("1. Show all questions\n2. Show questions based on topic\n3. Show questions based on answered or not" +
                        "\n4. Answer question");
                System.out.println("Enter your choice");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        // show all questions
                        questionService.showFeed();
                        break;
                    case 2:
                        // show questions based on feed
                        String filter = sc.next();
                        questionService.showFeedByFilter(filter);
                        break;
                    case 3:
                        // show questions based on answered or not
                        boolean ans = sc.nextBoolean();
                        questionService.showFeedByAnswers(ans);
                        break;
                    case 4:
                        sc.nextLine();
                        System.out.println("Enter the question to answer - ");
                        String q = sc.nextLine();
                        System.out.println("Enter the answer - ");
                        String answer = sc.nextLine();
                        questionService.answerQuestion(q, answer);
                        break;
                    case 5:
                        questionService.logout(users);
                        break;
                }
                System.out.println("Want to continue? Press 0 else press 1");
                ch = sc.nextInt();
            }
        }
    }
}

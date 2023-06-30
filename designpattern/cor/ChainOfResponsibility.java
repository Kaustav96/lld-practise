package interview.practise.designpattern.cor;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        LogProcessor logObject = new Info(new Debug(new Error(null)));

        logObject.log(LogProcessor.ERROR, "exception happens");
        logObject.log(LogProcessor.DEBUG, "need to debug this ");
        logObject.log(LogProcessor.INFO, "just for info ");


    }
}

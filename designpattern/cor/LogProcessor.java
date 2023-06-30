package interview.practise.designpattern.cor;

public abstract class LogProcessor {
    public static  int INFO = 1;
    public static  int DEBUG = 2;
    public static  int ERROR = 3;

    LogProcessor nexLogProcessor;

    public LogProcessor(LogProcessor nexLogProcessor) {
        this.nexLogProcessor = nexLogProcessor;
    }

    public void log(int level, String msg){
        if (nexLogProcessor!=null){
            nexLogProcessor.log(level,msg);
        }
    }
}

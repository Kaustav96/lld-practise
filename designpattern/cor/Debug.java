package interview.practise.designpattern.cor;

public class Debug extends LogProcessor{
    public Debug(LogProcessor nexLogProcessor) {
        super(nexLogProcessor);
    }
    public void log(int logLevel, String msg){
        if(logLevel==DEBUG){
            System.out.println("DEBUG : "+ msg);
        }else{
            super.log(logLevel,msg);
        }
    }
}

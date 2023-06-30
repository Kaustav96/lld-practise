package interview.practise.designpattern.cor;

public class Error extends LogProcessor{
    public Error(LogProcessor nexLogProcessor) {
        super(nexLogProcessor);
    }
    public void log(int logLevel, String msg){
        if(logLevel==ERROR){
            System.out.println("ERROR : "+ msg);
        }else{
            super.log(logLevel,msg);
        }
    }
}

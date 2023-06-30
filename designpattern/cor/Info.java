package interview.practise.designpattern.cor;

public class Info extends LogProcessor{
    public Info(LogProcessor nexLogProcessor) {
        super(nexLogProcessor);
    }
    public void log(int logLevel, String msg){
        if(logLevel==INFO){
            System.out.println("INFO : "+ msg);
        }else{
            super.log(logLevel,msg);
        }
    }
}

package interview.practise.lld.covidTracker;

import interview.practise.lld.covidTracker.model.Address;
import interview.practise.lld.covidTracker.model.Person;
import interview.practise.lld.covidTracker.service.CovidService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        CovidService covidService = new CovidService();
        File file=new File("practise/lld/covidTracker/Input.txt");    //creates a new file instance
        FileReader fr=new FileReader(file);   //reads the file
        BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
        String line;
        while((line=br.readLine())!=null)
        {
            String[] commands = line.split(" ");
            String commandType = commands[0];
            switch (commandType){
                case "register":
                    covidService.createUser(new Person(new Address(commands[3]),commands[2],
                            commands[1].equalsIgnoreCase("admin")?true:false));
                    break;
                case "report":
                    int active = Integer.valueOf(commands[2]),fatal = Integer.valueOf(commands[3]),cured = Integer.valueOf(commands[4]);
                    int totalCasesPerZipCode = active+fatal+cured;
                    covidService.addCasesToZipCode(commands[1],active,fatal,cured,totalCasesPerZipCode);
                    break;
                case "selfassessment":
                    System.out.println(covidService.selfAssessment(commands[1],
                            commands[2].equalsIgnoreCase("y")?true:false,
                            commands[3].equalsIgnoreCase("y")?true:false,
                            commands[4].equalsIgnoreCase("y")?true:false)==true?"":"");
                    break;
                case "display":
                    if(commands.length==1){
                        covidService.displayAllZipCodes();
                    }else{
                        covidService.displayCasesByZipCode(commands[1]);
                    }
                    break;
                case "covidresult":
                    String admin_mobile = commands[1],user_mobile = commands[2], covid_status = commands[3];
                    covidService.adminCases(admin_mobile,user_mobile,covid_status);
                    break;
                case "getzone":
                    covidService.getZoneStatus(commands[1]);
                    break;
            }
        }
        fr.close();    //closes the stream and release the resources
    }
}

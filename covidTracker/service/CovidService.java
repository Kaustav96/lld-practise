package interview.practise.lld.covidTracker.service;

import interview.practise.lld.covidTracker.model.Person;

import java.util.HashMap;
import java.util.Map;

public class CovidService {
    private HashMap<String, Person> userMap;
    private HashMap<String, Person> adminMap;
    private HashMap<String, String> caseCountZipMap;
    private HashMap<String, String> covidStatusUser;

    public CovidService() {
        this.userMap = new HashMap<>();
        this.adminMap = new HashMap<>();
        this.caseCountZipMap = new HashMap<>();
        this.covidStatusUser = new HashMap<>();
    }

    // create user -> can be regular user & admin
    public void createUser(Person person){
        if(person.isAdmin()){
            adminMap.put(person.getPhone(),person);
            System.out.println(person.getPhone()+" has been logged in as an Admin");
        }else{
            userMap.put(person.getPhone(),person);
            System.out.println(person.getPhone()+" has been logged in as a Regular User");
        }
    }
    /*
        if admin ->
        add case
        update case
        delete case
     */
    public void adminCases(String adminMobile, String userMobile, String covidStatus) {
        if(!adminMap.containsKey(adminMobile)){
            System.out.println("This mobile does not belong to admin");
        }
        else{
            if(this.covidStatusUser.containsKey(userMobile)){
                this.covidStatusUser.put(userMobile,covidStatus.equalsIgnoreCase("y")?"Yes":"No");
            }else{
                this.covidStatusUser.put(userMobile,covidStatus.equalsIgnoreCase("y")?"Yes":"No");
            }
            System.out.println("Covid status has been published by admin for user with mobile number - "+userMobile);
        }
    }
    /*
        if user
        A. not vaccinated
        B. came in contact with covid patient
        C. visited covid red zone
     */
    public boolean selfAssessment(String phone, boolean isVaccinated, boolean cameInContactCovidPatient, boolean visitedRedZone){
        if(!userMap.containsKey(phone) && !adminMap.containsKey(phone)){
            throw new RuntimeException("Phone number not registered till now");
        }
        if((isVaccinated && cameInContactCovidPatient) && (cameInContactCovidPatient && visitedRedZone)){
            System.out.println("100% chance of covid positive");
            return true;
        }
        else if((isVaccinated && cameInContactCovidPatient) || (isVaccinated && visitedRedZone)){
            System.out.println("50% chance of covid positive");
            return true;
        }
        else if(cameInContactCovidPatient && visitedRedZone){
            System.out.println("75% chance of covid positive");
        }
        return false;
    }

    public void addCasesToZipCode(String zipCode, int active, int fatal, int cured, int totalCasesPerZipCode) {
        if(caseCountZipMap.containsKey(zipCode)){
            caseCountZipMap.remove(zipCode);
        }
        caseCountZipMap.put(zipCode,"Total : "+totalCasesPerZipCode+"\nActive : "+active+"" +
                "\nFatal : "+fatal+"\nCured : "+cured);
    }

    public void displayAllZipCodes() {
        System.out.println("All zip code data as below - ");
        for(Map.Entry<String,String> entry:caseCountZipMap.entrySet()){
            System.out.println("Zip Code : " +entry.getKey()+"\n"+entry.getValue());
        }
    }

    public void displayCasesByZipCode(String zipCode) {
        if(!caseCountZipMap.containsKey(zipCode)){
            throw new RuntimeException("Zip code not present.");
        }
        String caseData = caseCountZipMap.get(zipCode);
        System.out.println("Zip code - "+zipCode+" has the following data currently\n"+caseData);
    }

    public void getZoneStatus(String zipCode) {
        if(!caseCountZipMap.containsKey(zipCode)){
            throw new RuntimeException("Zip code is not present currently");
        }
        String data = caseCountZipMap.get(zipCode);
        String[] dataArray = data.split("\\n");
        int totalCases = Integer.parseInt(dataArray[0].split(" ")[2]);
        int active = Integer.parseInt(dataArray[1].split(" ")[2]);
        int caseValue = (active*100)/totalCases;
        if(caseValue>=75){
            System.out.println(zipCode + " is Red Zone");
        }
        else if(caseValue>=25 && caseValue<75){
            System.out.println(zipCode + " is Orange Zone");
        }
        else{
            System.out.println(zipCode + " is Green Zone safe zone!!!!!");
        }
    }


}

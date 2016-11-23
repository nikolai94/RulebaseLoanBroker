/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rule;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author nikolai
 */
@WebService(serviceName = "RuleBase")
public class RuleBase {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetBanks")
    public java.util.ArrayList<String> Rule(@WebParam(name = "CreditScore") Integer CreditScore) {
        ArrayList<String> banksInJson = new ArrayList<String>();
        
        if (CreditScore > 800 || CreditScore <= 0){
            return banksInJson;
        }
        ArrayList<Bank> listOfBanks = new ArrayList<Bank>();
        listOfBanks.add(new Bank("Danske Bank", "1245",500));
        listOfBanks.add(new Bank("Nordea", "6543",700));
        listOfBanks.add(new Bank("Our bank", "9823", 0));
        
        
        
        List<Bank> ruleBaseBanks = findRuleForBank(CreditScore, listOfBanks);
        if(!ruleBaseBanks.isEmpty())
            banksInJson = toJson(ruleBaseBanks);
        
        return banksInJson;
    }
    
    //Help Methods !!!!!!!!!!!!!!!!!-------------------------------------------
    
    private static List<Bank> findRuleForBank(Integer creditScore, List<Bank> banks ){
        List<Bank> listOfBanks = new ArrayList<Bank>();
        for (Bank bank : banks) {
            //if the bank-request/CreditScore is bigger or equal to the minimum rule from the bank
            if(bank.getMinScore() <= creditScore){
                listOfBanks.add(bank);
            }
        }
        return listOfBanks;
    }

    //convert to a arraylist of strings there contains json DtoBank class
    private static ArrayList<String> toJson(List<Bank> banks){
        Gson gson = new Gson();
        ArrayList<String> listOfBanksInJson = new ArrayList<String>();
        for (Bank bank : banks) {
            listOfBanksInJson.add(gson.toJson(new DtoBank(bank.getName(), bank.getRoutingKey())));
        }
        
        return listOfBanksInJson;
    }
    
}

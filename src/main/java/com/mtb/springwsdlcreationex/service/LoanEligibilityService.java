package com.mtb.springwsdlcreationex.service;

import com.mtbwsdlex.spring.soap.api.loaneligibility.Acknowledgement;
import com.mtbwsdlex.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MithileshB
 * @created 23/08/2021 - 7:42 PM
 * @project spring-wsdl-creation-ex
 */
@Service
public class LoanEligibilityService {

    public Acknowledgement checkEligibilityService(CustomerRequest request){
        Acknowledgement acknowledgement=new Acknowledgement();
        List<String> mismatchCriteriaList=acknowledgement.getCriteriaMismatch();

        if(!(request.getAge()>30 && request.getAge()<=60)){
            mismatchCriteriaList.add("Person age should be in between 30 to 60");
        }
        if(!(request.getYearlyIncome()>200000)){
            mismatchCriteriaList.add("Minimum income should be more that 200000") ;
        }
        if(!(request.getCibilScore()>500)){
            mismatchCriteriaList.add("Low Cibil Score,Please try after 6 months");
        }
        if(mismatchCriteriaList.size()>0){
            acknowledgement.setApprovedAmount(0);
            acknowledgement.setIsEligible(false);
        }else{
            acknowledgement.setApprovedAmount(500000);
            acknowledgement.setIsEligible(true);
            mismatchCriteriaList.clear();
        }
        return acknowledgement;
    }
}

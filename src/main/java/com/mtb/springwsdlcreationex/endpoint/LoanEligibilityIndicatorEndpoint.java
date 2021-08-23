package com.mtb.springwsdlcreationex.endpoint;

import com.mtb.springwsdlcreationex.service.LoanEligibilityService;
import com.mtbwsdlex.spring.soap.api.loaneligibility.Acknowledgement;
import com.mtbwsdlex.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author MithileshB
 * @created 23/08/2021 - 7:49 PM
 * @project spring-wsdl-creation-ex
 */
@Endpoint
public class LoanEligibilityIndicatorEndpoint {

    private static final String NAMESPACE="http://www.mtbwsdlex.com/spring/soap/api/loaneligibility";

    @Autowired
    private LoanEligibilityService loanEligibilityService;

    @PayloadRoot(namespace = NAMESPACE,localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request){
        return loanEligibilityService.checkEligibilityService(request);
    }
}

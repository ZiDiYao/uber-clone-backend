package org.zidi.rules.service.Impl;

import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;
import org.zidi.rules.dto.request.FeeRuleRequest;
import org.zidi.rules.dto.response.FeeRuleResponse;
import org.zidi.rules.service.FeeRuleService;

@Service
@RequiredArgsConstructor
public class FeeRuleServiceImpl implements FeeRuleService {

    private final KieContainer kieContainer;
    @Override
    public FeeRuleResponse calculateOrderFee(FeeRuleRequest feeRuleRequest) {
        // Drools
        KieSession kieSession = kieContainer.newKieSession();
        FeeRuleResponse feeRuleResponse = new FeeRuleResponse();
        kieSession.setGlobal("feeRuleResponse",feeRuleResponse);
        kieSession.insert(feeRuleRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return feeRuleResponse;
    }
}

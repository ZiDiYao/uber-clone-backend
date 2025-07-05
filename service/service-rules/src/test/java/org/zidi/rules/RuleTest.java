package org.zidi.rules;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.zidi.rules.dto.request.FeeRuleRequest;
import org.zidi.rules.dto.response.FeeRuleResponse;

import java.math.BigDecimal;

@SpringBootTest
public class RuleTest {
    @Test
    public void testRule() {
        // 1. Create request object
        FeeRuleRequest request = new FeeRuleRequest();
        request.setDistance(new BigDecimal("15.5")); // total distance
        request.setStartTime("06:30:00"); // within night-time window
        request.setWaitMinute(0);

        // 2. Create response object
        FeeRuleResponse response = new FeeRuleResponse();

        // 3. Set up Drools
        KieServices kieServices = KieServices.Factory.get();
        KieContainer container = kieServices.getKieClasspathContainer();
        KieSession session = container.newKieSession();

        // 4. Inject data
        session.setGlobal("feeRuleResponse", response);
        session.insert(request);

        // 5. Fire rules
        session.fireAllRules();
        session.dispose();

        // 6. Print result
        System.out.println("=== Result ===");
        System.out.println("Base Distance: " + response.getBaseDistance() + " km");
        System.out.println("Base Fare: ¥" + response.getBaseDistanceFee());
        System.out.println("Extra Distance: " + response.getExceedDistance() + " km");
        System.out.println("Extra Distance Unit Price: ¥" + response.getExceedDistancePrice());
    }
}

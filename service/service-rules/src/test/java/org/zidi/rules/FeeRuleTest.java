package org.zidi.rules;

import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FeeRuleTest {
    @Autowired
    private KieContainer kieContainer;

    @Test
    public void testRule() {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}

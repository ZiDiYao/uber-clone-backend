package org.zidi.rules.service;

import org.zidi.rules.dto.request.FeeRuleRequest;
import org.zidi.rules.dto.response.FeeRuleResponse;

public interface FeeRuleService {

    FeeRuleResponse calculateOrderFee(FeeRuleRequest calculateOrderFeeForm);
}

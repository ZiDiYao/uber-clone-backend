package org.zidi.rules.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zidi.rules.dto.request.FeeRuleRequest;
import org.zidi.rules.dto.response.FeeRuleResponse;
import org.zidi.rules.service.FeeRuleService;

@RestController
@RequestMapping("/internal/rule/fee")
@RequiredArgsConstructor
public class FeeRuleController  {

    private final FeeRuleService feeRuleService;

    @PostMapping("/calculateOrderFee")
    public FeeRuleResponse calculateOrderFee(@RequestBody FeeRuleRequest feeRuleRequest){
        return feeRuleService.calculateOrderFee(feeRuleRequest);
    }
}

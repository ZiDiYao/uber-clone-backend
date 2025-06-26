package org.zidi.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zidi.order.dto.request.OrderInfoForm;
import org.zidi.order.service.OrderInfoService;
import org.zidi.uber.common.core.Result;

@RestController
@Requ
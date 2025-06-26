package org.zidi.order.service;

import org.zidi.order.dto.request.UpdateOrderCartFormRequest;

public interface CustomerOrderActionService {

    Boolean updateOrderCart(UpdateOrderCartFormRequest updateOrderCartForm);
    void orderCancel(long orderId);
}

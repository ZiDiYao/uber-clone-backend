package org.zidi.order.service;

import org.zidi.order.dto.request.StartDriveFormRequest;
import org.zidi.order.dto.request.UpdateOrderBillFormRequest;

public interface DriverOrderActionService {

    Boolean robNewOrder(Long driverId, Long orderId);
    Boolean driverArriveStartLocation(Long orderId, Long driverId);
    Boolean startDriver(StartDriveFormRequest startDriveForm);
    Boolean endDrive(UpdateOrderBillFormRequest updateOrderBillForm);
}

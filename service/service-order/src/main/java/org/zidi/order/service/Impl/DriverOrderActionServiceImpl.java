package org.zidi.order.service.Impl;

import org.zidi.order.dto.request.StartDriveFormRequest;
import org.zidi.order.dto.request.UpdateOrderBillFormRequest;
import org.zidi.order.service.DriverOrderActionService;

public class DriverOrderActionServiceImpl implements DriverOrderActionService {
    @Override
    public Boolean robNewOrder(Long driverId, Long orderId) {
        return null;
    }

    @Override
    public Boolean driverArriveStartLocation(Long orderId, Long driverId) {
        return null;
    }

    @Override
    public Boolean startDriver(StartDriveFormRequest startDriveForm) {
        return null;
    }

    @Override
    public Boolean endDrive(UpdateOrderBillFormRequest updateOrderBillForm) {
        return null;
    }
}

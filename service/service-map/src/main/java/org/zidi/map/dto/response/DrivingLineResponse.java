package org.zidi.map.dto.response;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DrivingLineResponse {

    private BigDecimal distance; // unit : km

    private BigDecimal duration; // minutes 结合路况
    // 方案路线坐标点串
    private JSONArray polyline;

}

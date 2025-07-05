package org.zidi.map.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.zidi.map.dto.request.CalculateDrivingLineFormRequest;
import org.zidi.map.dto.response.DrivingLineResponse;
import org.zidi.map.service.MapService;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MapServiceImpl implements MapService {

    @Value("${tencent.cloud.map.key}")
    private String key;

    private final RestTemplate restTemplate;

    /**
     * @param request
     * @return
     */

    @Override
    public DrivingLineResponse calculateDrivingLine(CalculateDrivingLineFormRequest request) {
        Map<String, String> uriParams = buildUriParams(request);
        JSONObject result = callDrivingApi(uriParams);

        JSONArray routes = result.getJSONArray("routes");
        if (routes == null || routes.isEmpty()) {
            throw new RuntimeException("No Route Available");
        }

        JSONObject route = routes.getJSONObject(0);
        BigDecimal distance = route.getBigDecimal("distance");
        BigDecimal duration = route.getBigDecimal("duration");
        JSONArray polyline = route.getJSONArray("polyline");

        DrivingLineResponse drivingLineResponse = new DrivingLineResponse();
        drivingLineResponse.setDistance(distance);
        drivingLineResponse.setDuration(duration);
        drivingLineResponse.setPolyline(polyline);
        return drivingLineResponse;
    }

    /**
     * Calls the Tencent Map driving route API and returns the result JSON object.
     *
     * @param uriParams A map containing query parameters: from, to, and key.
     * @return The "result" field of the JSON response, which contains route information.
     * @throws RuntimeException if the API call fails or returns an error status.
     */
    private JSONObject callDrivingApi(Map<String, String> uriParams) {
        // Define the request URL with placeholders
        String url = "https://apis.map.qq.com/ws/direction/v1/driving/?from={from}&to={to}&key={key}";

        // Send GET request to Tencent Map API
        JSONObject response = restTemplate.getForObject(url, JSONObject.class, uriParams);

        // Check if the response is null
        if (response == null) {
            throw new RuntimeException("Tencent Map API call failed: response is null");
        }

        // Check the status field in the response
        int status = response.getIntValue("status");
        if (status != 0) {
            String message = response.getString("message");
            log.error("Map API error, status={}, message={}", status, message);
            throw new RuntimeException("Tencent Map API error. Status code: " + status + ", message: " + message);
        }

        // Return the "result" part of the response, which contains the route details
        return response.getJSONObject("result");
    }

    /**
     *
     *
     * @param request
     * @return
     */
    private Map<String, String> buildUriParams(CalculateDrivingLineFormRequest request) {
        String from = request.getStartPointLatitude() + "," + request.getStartPointLongitude();
        String to = request.getEndPointLatitude() + "," + request.getEndPointLongitude();
        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("from", from);
        uriParams.put("to", to);
        uriParams.put("key", key);
        return uriParams;
    }

}

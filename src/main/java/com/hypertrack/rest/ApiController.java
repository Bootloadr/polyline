package com.hypertrack.rest;

import com.hypertrack.beans.ApiInput;
import com.hypertrack.beans.ApiOutput;
import com.hypertrack.beans.PolylineOutput;
import com.hypertrack.service.ComputePolylineService;
import com.hypertrack.service.FetchPolylineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author abhinav
 * @date 24/12/17
 */

@RestController
@RequestMapping(value="/polyline")
public class ApiController {
    @Autowired private ComputePolylineService computePolylineService;
    @Autowired private FetchPolylineService fetchPolylineService;

    @RequestMapping(value = "/store",method = RequestMethod.POST)
    public ApiOutput storeData(@RequestBody ApiInput input){
        return computePolylineService.callApi(input);
    }

    @RequestMapping(value = "/fetch",method = RequestMethod.GET)
    public PolylineOutput fetchPolyline(@RequestParam(value = "tripId") String tripId){
        return fetchPolylineService.callApi(tripId);
    }
}

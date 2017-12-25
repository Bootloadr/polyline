package com.hypertrack.service;

import com.hypertrack.beans.PolylineOutput;
import com.hypertrack.constants.ErrorCode;
import com.hypertrack.entity.EncodedData;
import com.hypertrack.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author abhinav
 * @date 25/12/17
 */
@Service("fetchPolylineService")
public class FetchPolylineService implements ApiService<String,PolylineOutput> {
    @Autowired DataRepository dataRepository;
    public PolylineOutput callApi(String tripId){
        PolylineOutput output = new PolylineOutput();
        EncodedData data = dataRepository.findByTripId(tripId);
        if(data == null)
            return new PolylineOutput(ErrorCode.DATA_NOT_FOUND_FOR_TRIP);
        output.setPolylineData(data.getEncodedLoc());
        return output;
    }
}

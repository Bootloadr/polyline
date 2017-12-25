package com.hypertrack.service;

import com.hypertrack.beans.ApiInput;
import com.hypertrack.beans.ApiOutput;
import com.hypertrack.beans.LocationInput;
import com.hypertrack.constants.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author abhinav
 * @date 24/12/17
 */
@Service("computePolylineService")
public class ComputePolylineService implements ApiService<ApiInput,ApiOutput> {
    private static final Logger logger = LoggerFactory.getLogger(ComputePolylineService.class);
    private final static double MULTIPLIER = 100000;
    private final static int FIVE_BIT_MASK = 0x1f;

    @Override
    public ApiOutput callApi(ApiInput input) {
        ApiOutput out = new ApiOutput();
        if(input.getData().size() == 0)
            return new ApiOutput(ErrorCode.LOCATION_DATA_EMPTY);
        List<LocationInput> locations = input.getData();
        StringBuilder encodedStrings = new StringBuilder();
        for(LocationInput point : locations){
            encodedStrings.append(
                    encodeCoordinate(point.getLatitude()) +
                    encodeCoordinate(point.getLongitude())+ "\n");
        }
        logger.info("Encoded string for tripId : "+input.getTripId()+" is "+encodedStrings);
        //todo store to database
        return out;
    }

    private String encodeCoordinate(double coordinate) {
        StringBuilder encodedCoordinate = new StringBuilder();
        boolean hasNext;

        coordinate *= MULTIPLIER;
        int value = (int) coordinate;
        value <<= 1;
        if(coordinate < 0) value = ~value;

        do {
            int next = (value >> 5);
            hasNext = (next > 0);
            int encVal = value & FIVE_BIT_MASK;
            if(hasNext) encVal |= 0x20;
            encVal += 0x3f;
            value = next;
            encodedCoordinate.append((char)(encVal));
        } while (hasNext);

        return encodedCoordinate.toString();
    }

}

package com.hypertrack.service;

import com.hypertrack.beans.ApiInput;
import com.hypertrack.beans.ApiOutput;
import com.hypertrack.beans.LocationInput;
import com.hypertrack.constants.ErrorCode;
import com.hypertrack.entity.EncodedData;
import com.hypertrack.repository.DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author abhinav
 * @date 24/12/17
 */
@Service("computePolylineService")
public class ComputePolylineService implements ApiService<ApiInput,ApiOutput> {
    @Autowired DataRepository dataRepository;
    private static final Logger logger = LoggerFactory.getLogger(ComputePolylineService.class);
    private final static double MULTIPLIER = 100000;
    private final static int FIVE_BIT_MASK = 0x1f;

    @Override
    public ApiOutput callApi(ApiInput input) {
        ApiOutput out = new ApiOutput();
        if(input.getData().size() == 0)
            return new ApiOutput(ErrorCode.LOCATION_DATA_EMPTY);
        EncodedData data = dataRepository.findByTripId(input.getTripId());
        if (data == null){
            data = new EncodedData();
            data.setCreatedTime(Date.valueOf(LocalDate.now()));
            data.setTripId(input.getTripId());
        }
        List<LocationInput> locations = input.getData();
        StringBuilder encodedStrings = new StringBuilder();
        for(LocationInput point : locations){
            encodedStrings.append(
                    encodeCoordinate(point.getLatitude()) +
                    encodeCoordinate(point.getLongitude())+ "\n");
        }
        data.setEncodedLoc(encodedStrings.toString());
        data.setLastUpdated(Date.valueOf(LocalDate.now()));
        try {
            dataRepository.save(data);
        }catch (Exception e){
            logger.info("Exception caught during data persistance" + e.getStackTrace().toString());
            return new ApiOutput(ErrorCode.JAVA_EXCEPTION);
        }
        logger.info("Encoded string for tripId : "+input.getTripId()+" is "+encodedStrings);
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

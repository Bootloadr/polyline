package com.hypertrack.repository;

import com.hypertrack.entity.EncodedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author abhinav
 * @date 24/12/17
 */
@Repository
public interface DataRepository extends JpaRepository<EncodedData,Long>{
    public EncodedData findByTripId(String tripId);
}

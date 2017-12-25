import com.hypertrack.beans.ApiInput;
import com.hypertrack.beans.ApiOutput;
import com.hypertrack.beans.LocationInput;
import com.hypertrack.beans.PolylineOutput;
import com.hypertrack.entity.EncodedData;
import com.hypertrack.repository.DataRepository;
import com.hypertrack.service.ComputePolylineService;
import com.hypertrack.service.FetchPolylineService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

/**
 * @author abhinav
 * @date 25/12/17
 */
@RunWith(SpringRunner.class)
public class TestComputeAndFetchPolyline {
    @TestConfiguration
    static class ComputePolylineTestContextConfiguration{
        @Bean
        public ComputePolylineService computePolylineService(){
            return new ComputePolylineService();
        }
        @Bean
        public FetchPolylineService fetchPolylineService(){
            return new FetchPolylineService();
        }
        @Bean
        @Primary
        public DataRepository dataRepository() {
            return Mockito.mock(DataRepository.class);
        }
    }
    @Autowired private ComputePolylineService computePolylineService;
    @Autowired private FetchPolylineService fetchPolylineService;
    @Autowired private DataRepository dataRepository;

    @Before
    public void setUp(){

        ApiOutput output = new ApiOutput();
        ApiInput input = new ApiInput();
        EncodedData data = new EncodedData();
        data.setEncodedLoc("dvsdvjlk");
        input.setTripId("ABHI-1");
        LocationInput loc = new LocationInput();
        loc.setLongitude(44.576079);
        loc.setLatitude(-75.194874);
        List<LocationInput> list = new ArrayList<>();
        list.add(loc);
        input.setData(list);
        PolylineOutput polylineOutput = new PolylineOutput();
        polylineOutput.setPolylineData(data.getEncodedLoc());
        
        Mockito.when(dataRepository.findByTripId("ABHI-1")).thenReturn(data);
    }

    @Test
    public void computeTest() {
        ApiInput in = new ApiInput();
        in.setTripId("ABHI-1");
        LocationInput loc = new LocationInput();
        loc.setLongitude(44.576079);
        loc.setLatitude(-75.194874);
        List<LocationInput> list = new ArrayList<>();
        list.add(loc);
        in.setData(list);
        ApiOutput res = computePolylineService.callApi(in);
        assertEquals(res.isSuccess(),true);
    }
    @Test
    public void fetchTest(){
        PolylineOutput output = fetchPolylineService.callApi("ABHI-1");
        assertEquals(output.getPolylineData(),"dvsdvjlk");

    }

}

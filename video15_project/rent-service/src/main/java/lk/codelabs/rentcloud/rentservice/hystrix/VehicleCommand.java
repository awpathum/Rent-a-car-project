package lk.codelabs.rentcloud.rentservice.hystrix;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lk.codelabs.rentcloud.model.vehicle.Vehicle;
import org.springframework.web.client.RestTemplate;

public class VehicleCommand extends HystrixCommand<Vehicle> {

    RestTemplate restTemplate;
    int vehicleId;

    public VehicleCommand(RestTemplate restTemplate, int vehicleId) {
        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.restTemplate = restTemplate;
        this.vehicleId = vehicleId;
    }

    @Override
    protected Vehicle getFallback() {
        return new Vehicle();
    }

    @Override
    protected Vehicle run() throws Exception {
        return restTemplate.getForObject("http://vehicle-service:9191/services/vehicles/"+vehicleId,Vehicle.class);
    }
}

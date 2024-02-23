package GasStation.Stations.Controller;

import GasStation.Stations.Model.FuelPriceStats;
import GasStation.Stations.Model.FuelPricesResponse;
import GasStation.Stations.Model.Station;
import GasStation.Stations.Service.FuelPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/fuel-prices")
public class FuelPriceController {
    private static final Logger logger = LoggerFactory.getLogger(FuelPriceController.class);
    @Autowired
    private FuelPriceService fuelPriceService;

    @GetMapping("/stats")
    public FuelPricesResponse getFuelPriceStats() {
        logger.info("Received request to get fuel price statistics.");
        return fuelPriceService.getFuelPriceStats();
    }

    @GetMapping("/stations/search")
    public List<Station> searchStationsByName(@RequestParam("name") String name) {
        logger.info("Received request to search stations by name: {}", name);
        return fuelPriceService.searchStationsByName(name);
    }
}

package GasStation.Stations.Service;

import GasStation.Stations.Model.FuelPriceStats;
import GasStation.Stations.Model.FuelPrices;
import GasStation.Stations.Model.FuelPricesResponse;
import GasStation.Stations.Model.Station;
import GasStation.Stations.Repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class FuelPriceService {
    @Autowired
    private StationRepository stationRepository;

    public List<Station> searchStationsByName(String name) {
        return stationRepository.findByNameContainingIgnoreCase(name);
    }

    public FuelPricesResponse getFuelPriceStats() {

        List<Double> pricesDiesel = stationRepository.findByFuelType("diesel").stream()
                .map(station -> getPriceByFuelType(station, "diesel"))
                .collect(Collectors.toList());

        double medianPriceDiesel = calculateMedian(pricesDiesel);
        double maxPriceDiesel = pricesDiesel.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
        double minPriceDiesel = pricesDiesel.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
        FuelPrices fuelPriceDiesel = new FuelPrices(minPriceDiesel,maxPriceDiesel,medianPriceDiesel);

        List<Double> pricesE5 = stationRepository.findByFuelType("e5").stream()
                .map(station -> getPriceByFuelType(station, "e5"))
                .collect(Collectors.toList());

        double medianPriceE5 = calculateMedian(pricesE5);
        double maxPriceE5 = pricesE5.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
        double minPriceE5= pricesE5.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
        FuelPrices fuelPriceE5 = new FuelPrices(minPriceE5,maxPriceE5,medianPriceE5);


        List<Double> pricesE10 = stationRepository.findByFuelType("e10").stream()
                .map(station -> getPriceByFuelType(station, "e10"))
                .collect(Collectors.toList());

        double medianPriceE10 = calculateMedian(pricesE10);
        double maxPriceE10 = pricesE10.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
        double minPriceE10 = pricesE10.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
        FuelPrices fuelPriceE10 = new FuelPrices(minPriceE10,maxPriceE10,medianPriceE10);

        FuelPricesResponse fuelPricesResponse = new FuelPricesResponse(fuelPriceE5,fuelPriceE10,fuelPriceDiesel);

        return fuelPricesResponse;
    }
    private double calculateMedian(List<Double> prices) {
        int size = prices.size();
        if (size == 0) {
            //System.out.println("Empty list provided to calculateMedian method.");
            return 0.0; // or throw an exception
        }

        Collections.sort(prices); // Ensure prices are sorted

        if (size % 2 == 0) {
            double median = (prices.get(size / 2 - 1) + prices.get(size / 2)) / 2.0;
            //System.out.println("Median (even size): " + median);
            return median;
        } else {
            double median = prices.get(size / 2);
           // System.out.println("Median (odd size): " + median);
            return median;
        }
    }
    private Double getPriceByFuelType(Station station, String fuelType) {
        switch (fuelType) {
            case "diesel":
                return station.getDiesel();
            case "e5":
                return station.getE5();
            case "e10":
                return station.getE10();
            default:
                return null;
        }
    }
    /*private List<Double> CalculatePrice (List<Double> pricesCalculated, List<Double> prices)
    {
        double medianPrice = calculateMedian(prices);
        double maxPrice = prices.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
        double minPrice = prices.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
        prices.add((medianPrice));
        prices.add((maxPrice));
        prices.add((minPrice));
        return pricesCalculated;
    }*/

}

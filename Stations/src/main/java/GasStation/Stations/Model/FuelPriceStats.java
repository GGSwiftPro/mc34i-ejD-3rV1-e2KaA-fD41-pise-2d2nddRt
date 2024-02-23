package GasStation.Stations.Model;

public class FuelPriceStats {
    private double medianPrice;
    private double maxPrice;
    private double minPrice;

    // Constructors, getters, and setters

    public FuelPriceStats(double medianPrice, double maxPrice, double minPrice) {
        this.medianPrice = medianPrice;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
    }
}

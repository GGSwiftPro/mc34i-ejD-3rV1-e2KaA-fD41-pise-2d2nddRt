package GasStation.Stations.Model;

public class FuelPrices {
    private double min;
    private double max;
    private double median;

    public FuelPrices(double min, double max, double median) {
        this.min = min;
        this.max = max;
        this.median = median;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }
}

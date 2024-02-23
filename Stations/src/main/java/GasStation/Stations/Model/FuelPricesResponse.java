package GasStation.Stations.Model;

public class FuelPricesResponse {
    private FuelPrices e5;
    private FuelPrices e10;
    private FuelPrices Diesel;

    public FuelPricesResponse(FuelPrices e5, FuelPrices e10, FuelPrices diesel) {
        this.e5 = e5;
        this.e10 = e10;
        Diesel = diesel;
    }

    public FuelPrices getE10() {
        return e10;
    }

    public void setE10(FuelPrices e10) {
        this.e10 = e10;
    }

    public FuelPrices getDiesel() {
        return Diesel;
    }

    public void setDiesel(FuelPrices diesel) {
        Diesel = diesel;
    }

    public FuelPrices getE5() {
        return e5;
    }

    public void setE5(FuelPrices e5) {
        this.e5 = e5;
    }
}

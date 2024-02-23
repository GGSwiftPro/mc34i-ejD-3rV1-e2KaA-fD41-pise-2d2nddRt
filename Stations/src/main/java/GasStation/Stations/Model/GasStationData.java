package GasStation.Stations.Model;

import com.google.gson.annotations.SerializedName;

public class GasStationData {
    @SerializedName("stations")
    private Station[] stations;

    public Station[] getStations() {
        return stations;
    }

    public void setStations(Station[] stations) {
        this.stations = stations;
    }
}
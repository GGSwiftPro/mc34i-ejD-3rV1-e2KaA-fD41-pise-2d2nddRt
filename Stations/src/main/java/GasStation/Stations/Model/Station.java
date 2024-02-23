package GasStation.Stations.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Stations")
public class Station {
    @Id
    private String id;
    private String name;
    private String brand;
    private String street;
    private String place;
    private Double lat;
    private Double lng;
    private Double dist;
    private Double diesel;
    private Double e5;
    private Double e10;
    private Boolean isOpen;
    private String houseNumber;
    private int postCode;

    public String getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getDist() {
        return dist;
    }

    public void setDist(Double dist) {
        this.dist = dist;
    }

    public Double getDiesel() {
        return diesel;
    }

    public void setDiesel(Double diesel) {
        this.diesel = diesel;
    }

    public Double getE5() {
        return e5;
    }

    public void setE5(Double e5) {
        this.e5 = e5;
    }

    public Double getE10() {
        return e10;
    }

    public void setE10(Double e10) {
        this.e10 = e10;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

}

package GasStation.Stations.Repository;

import GasStation.Stations.Model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StationRepository extends JpaRepository<Station, Long> {
    @Query("SELECT s FROM Station s WHERE s.diesel IS NOT NULL AND s.e5 IS NOT NULL AND s.e10 IS NOT NULL")
    List<Station> findByFuelType(String fuelType);
    List<Station> findByNameContainingIgnoreCase(String name);
}

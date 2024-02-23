package GasStation.Stations;

import GasStation.Stations.Model.GasStationData;
import GasStation.Stations.Model.Station;
import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;

@SpringBootApplication
public class StationsApplication {

	public static void main(String[] args) throws MalformedURLException {
		SpringApplication.run(StationsApplication.class, args);
		try {
			// Fetch JSON data
			String jsonData = fetchJsonData("https://wejago.de/assets/data/gas-stations-data.json");

			// Parse JSON data
			Gson gson = new Gson();
			GasStationData gasStationData = gson.fromJson(jsonData, GasStationData.class);

			// Store data in database
			storeDataInDatabase(gasStationData.getStations());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	private static String fetchJsonData(String urlString) throws IOException {
		StringBuilder jsonData = new StringBuilder();

		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				jsonData.append(line);
			}
		}

		connection.disconnect();

		return jsonData.toString();
	}
	private static void storeDataInDatabase(Station[] dataArray) {
		String url = "jdbc:postgresql://localhost:5432/Stations";
		String username = "postgres";
		String password = "7005038450";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			for (Station data : dataArray) {
				String checkSql = "SELECT COUNT(*) FROM Stations WHERE id = ?";
				try (PreparedStatement checkStatement = connection.prepareStatement(checkSql)) {
					checkStatement.setString(1, data.getId());
					try (ResultSet resultSet = checkStatement.executeQuery()) {
						if (resultSet.next() && resultSet.getInt(1) > 0) {
							// ID already exists, skip inserting
							continue;
						}
					}
				}
				//TODO CREATE AUTO DATABASE
				String sql = "INSERT INTO Stations (name, brand, street, place, lat, lng, dist, diesel, e5, e10, is_open, house_number, post_code,id) " +
						"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				try (PreparedStatement statement = connection.prepareStatement(sql)) {
					if(data.getOpen()){
					statement.setString(1, data.getName());
					statement.setString(2, data.getBrand());
					statement.setString(3, data.getStreet());
					statement.setString(4, data.getPlace());
					statement.setDouble(5, data.getLat());
					statement.setDouble(6, data.getLng());
					statement.setDouble(7, data.getDist());
					if (data.getDiesel()==null){
						statement.setNull(8, Types. NULL);
					}
					else {
						statement.setDouble(8, data.getDiesel());
					}

					if (data.getE5()==null){
						statement.setNull(9, Types. NULL);
					}
					else {
						statement.setDouble(9, data.getE5());
					}
					if (data.getE10()==null){
						statement.setNull(10, Types. NULL);
					}
					else {
						statement.setDouble(10, data.getE10());
					}
					statement.setBoolean(11, data.getOpen());
					statement.setString(12, data.getHouseNumber());
					statement.setInt(13, data.getPostCode());
					statement.setString(14, data.getId());
					statement.executeUpdate();}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}


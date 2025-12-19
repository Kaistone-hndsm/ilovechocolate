import java.util.*;
import java.io.*;
public class airQualityIndex_Monitor {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		double[] aqiLevels = inputAQILevels();
		StringBuilder report = new StringBuilder();
		
		for(int i = 0; i < aqiLevels.length; i++) {
			String status = getAQIStatus(aqiLevels[i]);
			
			String line = "Location " + (i + 1) + ": " + aqiLevels[i] + " - " + status;
			System.out.println(line);
			report.append(line).append("\n");
		}
		
		saveToFile(report.toString());
		
		
		
		
		
		
	}
	public static double[] inputAQILevels() {
		System.out.print("How many locations do you want to monitor? ");
		int locationNum = sc.nextInt();
		double[] aqi = new double[locationNum];
		
		System.out.println("Enter AQI levels for " + locationNum + " locations");
		
		for(int i = 0; i < locationNum; i++) {
			System.out.print("Location " + (i + 1) + ": ");
			aqi[i] = sc.nextDouble();
		}
		
		return aqi;
		
		
	}
	public static String getAQIStatus(double aqi) {
		if(aqi > 150) {
			return "Unhealthy(Red)";
		}else if(aqi >= 51 && aqi <= 150) {
			return "Moderate(Yellow)";
		}else{
			return "Good(Green)";
		}
	}
	public static void saveToFile(String data) {
		try {
			FileWriter wr = new FileWriter("air_quality_report.txt");
			wr.write(data);
			wr.close();
			
			System.out.println("Report saved to to air_quality_report.txt");
			
		}catch (IOException e) {
			System.out.println("Error writing to file.");
		}
	}

}

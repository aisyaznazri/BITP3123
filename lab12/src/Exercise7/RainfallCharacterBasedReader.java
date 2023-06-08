package Exercise7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RainfallCharacterBasedReader 
{
	public static void main (String[]args)
	{
		//declare output file
		String sourceFile = "RainfallCharacterBased.txt";
		
		//display the sentence for read the data
		System.out.println("Reading data from " + sourceFile + "\n");
		try
		{
			//construct the reader object
			BufferedReader brInput = new BufferedReader(new FileReader(sourceFile));
			
			//read values from the stream from variables to handle data from source file
			
			//receive daily rainfall reading
			String dailyRainfall = "";
			
			//variables to count num of daily reading in the source file
			int noOfRecords = 0;
			
			//variable to calculate total daily rainfall
			double totalRainfall = 0.0;
			
			
			//read data
			dailyRainfall = brInput.readLine();
			while(dailyRainfall != null)
			{
				//Display each daily rainfall reading
				System.out.println(dailyRainfall);
				
				//calculate total daily rainfall
				totalRainfall = totalRainfall + Double.parseDouble(dailyRainfall);
				
				//auto update current num of records read from source file
				noOfRecords ++;
				
				//read next value for the daily rainfall reading
				dailyRainfall = brInput.readLine();
			}
			//display total num of records for the daily rainfall readings from source file
			System.out.println("\nTotal Records: " + noOfRecords);
			
			//display total daily rainfall
			System.out.println("Total Daily Rainfall: " + totalRainfall);
			
			//calculate average daily rainfall
			double averageRainfall = totalRainfall/Double.valueOf(noOfRecords);
			
			String formattedAverage = String.format("%.1f", averageRainfall);
			System.out.println("\nAverage rainfall for " + noOfRecords + " days from station Simpang Ampat in Alor Gajah district: "+ formattedAverage);
			
			//close reader
			brInput.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}



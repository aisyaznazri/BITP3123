package Exercise5;

import java.io.DataInputStream;
import java.io.FileInputStream;


public class RainfallDataReader 
{
	
	public static void main(String[]args)
	{
		//Declare output file
		String sourceFile = "RainFall.txt";
		
		//display the sentence for reading data
		System.out.println("Reading data from " + sourceFile + "\n");
		
		try
		{
			//create stream to read data
			DataInputStream disInput = new DataInputStream(new FileInputStream(sourceFile));
			
			//Read values from stream that have variables to handle data read from the source file
			
			//receive daily rainfall reading
			double dailyRainfall = 0;
			
			//variables to count num of daily reading in the source file
			int noOfRecords = 0;
			
			//variable to calculate total daily rainfall
			double totalRainfall = 0.0;
			
			//read values from the stream
			dailyRainfall = disInput.read();
			
			System.out.println("The 6 days readings of daily rainfall from station Simpang Ampat in Alor Gajah district: ");
			
			//read until end of the file/stream
			while (dailyRainfall != -1)
			{
				//display each daily rainfall reading
				System.out.println(dailyRainfall);
				
				//calculate total daily rainfall
				totalRainfall = totalRainfall + dailyRainfall;
				
				//auto update current num of records read from the source file
				noOfRecords ++;
				
				//read next value for the daily rainfall reading
				dailyRainfall = disInput.read();
				
			}
			//Display total num of records for daily rainfall readings from the source file
			System.out.println("\nTotal Records: " + noOfRecords);
			
			//Display total daily rainfall
			System.out.println("Total Daily Rainfall: " + totalRainfall);
			
			//calculate average daily rainfall
			double averageRainfall = totalRainfall/Double.valueOf(noOfRecords);
			
			String formattedAverage = String.format("%.1f", averageRainfall);
			System.out.println("\nAverage rainfall for " + noOfRecords + " days from station Simpang Ampat in Alor Gajah district: " + formattedAverage);
			
			//close stream
			disInput.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		//indicate end of the program
		System.out.println("\nEnd of program.");
	}

}

package Exercise6;

import java.io.DataInputStream;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.HashSet;

public class RainfallByteBasedReader
{
	public static void main(String[]args)
	{
		//declare source file
		String sourceFile = "RainfallByteBased.txt";
		System.out.println("Reading data from " + sourceFile + "\n");
		
		try
		{
			//create input stream to read data
			DataInputStream disInput = new DataInputStream(new FileInputStream(sourceFile));
			
			//variables for process the byte-based data
			//station id
			int id = 0;
			
			//station name and district
			String station = " ";
			String district = " ";
			
			//daily rainfall readings from 2 June 2023 to 7 June 2023
			double readings1 = 0.0, readings2 = 0.0, readings3 = 0.0, readings4 = 0.0, readings5 = 0.0, readings6 = 0.0;
			
			//variable declaration for the calculation
			//total num of records read from the source file
			int noOfRecords = 0;
			
			//total daily rainfall readings for each station
			double sum = 0.0;
			
			//declaration for arraylist to store to each total daily rainfall readings
			ArrayList<Double> totalRainfall = new ArrayList<Double>();
			
			ArrayList<String> station1= new ArrayList<String>();
			
			HashSet<String> districtCount = new HashSet<String>();
			
			//data process until end-of-file
			while(disInput.available()>0)
			{
				//read data
				
				//station id
				id = disInput.readInt();
				
				//station name
				station = disInput.readUTF();
				
				//district
				district = disInput.readUTF();
				
				// daily rainfall readings for 2 June 2023
				readings1 = disInput.readDouble();
				
				// daily rainfall readings for 3 June 2023
				readings2 = disInput.readDouble();
				
				// daily rainfall readings for 4 June 2023
				readings3 = disInput.readDouble();
				
				// daily rainfall readings for 5 June 2023
				readings4 = disInput.readDouble();
				
				// daily rainfall readings for 6 June 2023
				readings5 = disInput.readDouble();
				
				// daily rainfall readings for 7 June 2023
				readings6 = disInput.readDouble();
				
				System.out.println( id + "\t" + station1 + "\t" + district
						+ "\t" + readings1 + "\t" + readings2 + "\t" + readings3 
						+ "\t" + readings4 + "\t" + readings5 + "\t" + readings6 );
				
				// calculate total daily rainfall readings for each station
				sum = readings1 + readings2 + readings3 + readings4 + readings5 + readings6;
				
				// save the sum into the arraylist, totalRainfall
				totalRainfall.add(sum);
				
				// save the station names into the arraylist, stations
				station1.add(station);
				
				// save the distinct district into hashSet, districtCount
				districtCount.add(district);
				
				// Auto update for current number of records
				noOfRecords ++;
			}
			
			System.out.println("\n");
			
			// Calculation for average daily rainfall readings in each station
			for(int index = 0; index < station1.size(); index++)
			{
				// Calculation for average daily rainfall readings in each station
				double average = totalRainfall.get(index) / noOfRecords;
				
				// format the average in one decimal places
				String formattedAverage = String.format("%.1f", average);
				
				// display the total daily rainfall readings in each station and its correspond average
				System.out.println("The total daily rainfall readings in " + station1.get(index) + " : " 
						+ totalRainfall.get(index) );
				System.out.println("The average daily rainfall readings in " + station1.get(index) + " : " 
						+ formattedAverage + "\n");
			}
			
			System.out.println("There are " + station1.size() + " stations and "
						+ districtCount.size() + " districts in Melaka.");
			
			// 4. Close stream
			disInput.close();
	
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");
				
	}
	
}

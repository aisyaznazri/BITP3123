package Exercise6;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class RainfallByteBasedGenerator 
{
	
	public static void main(String[]args)
	{
		//declare output file
		String outFile = "RainfallByteBased.txt";
		
		//data declaration 
		//station id
		int[] id = {2321006,2222002,2324033,2225044,2223023,2222005};
		
		//station name
		String[] station = {"Ladang Lendu","Durian Tunggal","Hospital Jasin","Chohong","Sg.Duyong","Klebang Besar D/S"};
		
		//name of district
		String[] district = {"Alor Gajah","Alor Gajah","Jasin","Jasin","Melaka Tengah","Melaka Tengah"};
		
		//readings on 2 June 2023
		double readings1[] = {0.0,0.0,0.0,0.0,0.0,0.0};
		
		//readings on 3 June 2023
		double readings2[] = {2.0,0.0,0.0,0.0,0.0,0.0};
		
		//readings on 4 June 2023
		double readings3[] = {0.0,0.0,14.0,21.5,3.0,14.0};
		
		//readings on 5 June 2023
		double readings4[] = {0.0,0.0,0.0,0.0,0.0,0.0};
				
		//readings on 6 June 2023
		double readings5[] = {3.0,37.0,11.0,39.0,43.0,75.5};
		
		//readings on 7 June 2023
		double readings6[] = {4.0,6.0,15.0,14.5,26.0,25.5};
		
		try
		{
			//create output stream to read data
			DataOutputStream dosOutput = new DataOutputStream(new FileOutputStream(outFile));
			
			//data process
			for (int index = 0; index < station.length; index++)
			{
				//write data into data stream
				dosOutput.writeInt(id[index]);
				dosOutput.writeUTF(station[index]);
				dosOutput.writeUTF(district[index]);
				dosOutput.writeDouble(readings1[index]);
				dosOutput.writeDouble(readings2[index]);
				dosOutput.writeDouble(readings3[index]);
				dosOutput.writeDouble(readings4[index]);
				dosOutput.writeDouble(readings5[index]);
				dosOutput.writeDouble(readings6[index]);
				
				//flush for each writing
				dosOutput.flush();
			}
			
			//close stream
			dosOutput.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		//indicate end of the program
		System.out.println("End of program. Check out" + outFile);
	}


}

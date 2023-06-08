package Exercise5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RainfallDataGenerate
{
	public static void main(String[]args)
	{
		//Declare output file
		String outFile = "Rainfall.txt";
		
		try
		{
			//create an output stream between the program and the output file
			DataOutputStream dosOutput = new DataOutputStream(new FileOutputStream(outFile));
			
			//write the 6 days reading of daily rainfall (from 2 June 2023 to 7 June 2023)
			//from station Simpang Ampat in Alor Gajah district into the output file
			dosOutput.write(0);
			dosOutput.write(4);
			dosOutput.write(1);
			dosOutput.write(0);
			dosOutput.write(6);
			dosOutput.write(19);
			
			//clear the stream
			dosOutput.flush();
			
			//close the stream
			dosOutput.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		//indicate end of the program
		System.out.println("End of the program. Check out " + outFile);
	}

}

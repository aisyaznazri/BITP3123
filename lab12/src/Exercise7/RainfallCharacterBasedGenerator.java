package Exercise7;

import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class RainfallCharacterBasedGenerator 
{
	public static void main(String[]args)
	{
		String outFile = "RainfallCharacterBased.txt";
		try
		{
			//construct BufferedWriter object together with FileWriter
			FileWriter files = new FileWriter(outFile);
			BufferedWriter bwOutput = new BufferedWriter(files);
			int[]array = {0,4,1,0,6,19};
			
			//write the data
			for(int index =0; index < array.length; index++)
			{
				bwOutput.write(String.valueOf(array[index]));
				bwOutput.newLine();
			}
			
			//clear the stream
			bwOutput.flush();
			
			//close the stream
			bwOutput.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//indicate end of the program
		System.out.println("End of program. Check out " + outFile);
	}

}

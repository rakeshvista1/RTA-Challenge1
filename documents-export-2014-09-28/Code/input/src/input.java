import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvWriter;


public class input {   

// private static Configuration conf = null;
 public static String row;
 public static String col;
 public static String val="";
 public static String tableName;
 public static long i = 0;



public static void main(String agrs[]) throws IOException
{                           
		
		String fileName="/home/cloudera/Desktop/filename1.txt";
    		
    		
    			FileReader inputFile = new FileReader(fileName);
    			BufferedReader bufferReader = new BufferedReader(inputFile);
    			String line;
    			while ((line = bufferReader.readLine()) != null)   {
			
			
			
			
			String[] splits1 = line.split("\""+"text"+"\""+"\\:"+"\"");
			
			for (int k = 1;k<=splits1.length-1;k++)
			{
			String[] splits2 = splits1[k].split("\""+"\\,");
			System.out.println(splits2[0]);





			String csv = "/home/cloudera/Desktop/output.csv";
			try {
				// use FileWriter constructor that specifies open for appending
				CsvWriter writer = new CsvWriter(new FileWriter(csv, true), ',');
				
				
 

 
writer.write(splits2[0]);
writer.write("o");
writer.endRecord();
writer.close();
				
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			}
			
			
	}

}
}
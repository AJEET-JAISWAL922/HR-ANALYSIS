package com.salary;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SalReducer extends Reducer<Text, Text, Text, Text>
{
	public final void reduce(final Text key, final Iterable<Text> values, final Context context) throws IOException, InterruptedException
	{
		try {
			  
			
			   for (Text var : values)
			   {		    
			  
				   context.write(key, (var));
			   
			   }
			  } 
		catch (Exception e)
		{
			   e.printStackTrace();
		
	}
	}
}

package com.u;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class OReducer extends Reducer<Text, IntWritable, Text, IntWritable>
{
	
	
	public final void reduce(final Text key, final Iterable<IntWritable> values, final Context context) throws IOException, InterruptedException
	{
		try {

			int count=0;
			for(IntWritable var: values)
			{
				
				
				count++;
				
			}
			
			 context.write(key, new IntWritable(count));
				  
			   
			  
		}
			  
		catch (Exception e)
		{
			   e.printStackTrace();
		
	}
	

	}
		

}

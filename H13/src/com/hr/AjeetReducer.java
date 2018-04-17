package com.hr;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public final class AjeetReducer extends Reducer<Text, IntWritable, Text, IntWritable>
{
	public final void reduce(final Text key, final Iterable<IntWritable> values, final Context context) throws IOException, InterruptedException
	{
		try {
			   int sum = 0;
			
			   for (IntWritable var : values)
			   {
			    sum += var.get();
			    
			   }
				   context.write(key, new IntWritable(sum));
			   
			  
			  } 
		catch (Exception e)
		{
			   e.printStackTrace();
		
	}
	

	}
}


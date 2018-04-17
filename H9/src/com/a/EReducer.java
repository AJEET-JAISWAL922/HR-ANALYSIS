package com.a;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class EReducer  extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable>
{
	public final void reduce(IntWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException
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

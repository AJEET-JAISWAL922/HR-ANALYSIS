package com.department.avg.monthly.working;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public final class WorkReducer extends Reducer<Text, IntWritable, Text, DoubleWritable>
{
	public final void reduce(final Text key, final Iterable<IntWritable> values, final Context context) throws IOException, InterruptedException
	{
		try {
			   int sum = 0;
			int count = 0;
			   for (IntWritable var : values)
			   {
			    sum += var.get();
			    System.out.println("reducer " + var.get());
			    count++;
			    
			   }
			   double avg = (sum / count);
			   
			   context.write(key, new DoubleWritable(avg));
				  
			   
			  
			  } 
		catch (Exception e)
		{
			   e.printStackTrace();
		
	}
	

	}
}

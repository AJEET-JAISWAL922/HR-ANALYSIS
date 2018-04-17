package com.satisfaction;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public final class Hrreducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable>
{
	public final void reduce(final Text key, final Iterable<DoubleWritable> values, final Context context) throws IOException, InterruptedException
	{
		try {
			   Double sum = 0.0;
			   int count = 0;
			   
			
			   for (DoubleWritable var : values)
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

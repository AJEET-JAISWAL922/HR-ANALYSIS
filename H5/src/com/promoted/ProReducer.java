package com.promoted;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public final class ProReducer extends Reducer<Text, MapWritable, Text, IntWritable>
{
	MapWritable mw = new MapWritable();
	private final IntWritable department = new IntWritable();
	public final void reduce(final Text key, final Iterable<MapWritable> values, final Context context) throws IOException, InterruptedException
	{
		try {
			   int sum = 0;
			   int sum1 = 0;
			
			   for (MapWritable var : values)
			   {
				   sum = sum + ((IntWritable) var.get(new IntWritable(1))).get();
				   sum1  = sum1 + ((IntWritable) var.get(new IntWritable(2))).get();
			   }   
			  
			 
			    
			 
			  
			   department.set(sum-sum1);
		
			   
			   
			    
		
			
			  
				   context.write(key, department);
			   
			  
		}
			  
		catch (Exception e)
		{
			   e.printStackTrace();
		
	}
	

	}

}

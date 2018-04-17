package com.avg.sat.lst;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public final class SevReducer extends Reducer<Text, MapWritable, Text, DoubleWritable>
{
	MapWritable mw = new MapWritable();
	private final DoubleWritable department = new DoubleWritable();
	
	public final void reduce(final Text key, final Iterable<MapWritable> values, final Context context) throws IOException, InterruptedException
	{
		try {
			   Double sum = 0.0;
			   int sum1 = 0;
			int sum2 = 0;
			int count = 0;
			int count1 = 0;
			   for (MapWritable var : values)
			   {
				   sum = sum + ((DoubleWritable) var.get(new DoubleWritable(1))).get();
				 
				    count++;
				   sum1  = sum1 + ((IntWritable) var.get(new IntWritable(2))).get();
				   count1++;
				   sum2 = sum2 + ((IntWritable) var.get(new IntWritable(3))).get();
			   }   
			  double avg1 = 0.0; 
			 double avg2 = 0.0;
			    
			 avg1 = (sum / count);
			 avg2 = (sum1 / count1);
			  
			   department.set(avg1);
			   department.set(avg2);
			   department.set(sum2);
			   
			   
			    
		
			
			  
				   context.write(key, new DoubleWritable(avg1));
				   context.write(key, new DoubleWritable(avg2));
				   context.write(key, new DoubleWritable(sum2));
				   
			   
			  
		}
			  
		catch (Exception e)
		{
			   e.printStackTrace();
		
	}
	

	}

}

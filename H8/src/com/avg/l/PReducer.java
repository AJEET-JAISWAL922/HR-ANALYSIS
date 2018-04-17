package com.avg.l;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PReducer  extends Reducer<Text, MapWritable, Text, DoubleWritable>
{
	MapWritable mw = new MapWritable();
	private final DoubleWritable department = new DoubleWritable();
	
	public final void reduce(final Text key, final Iterable<MapWritable> values, final Context context) throws IOException, InterruptedException
	{
		try {
			   Double sum = 0.0;
			   int sum1 = 0;
			int sum2 = 0;
			
			for (MapWritable var : values)
			   {
				String[] s = ((Text) var.get(new IntWritable(1))).toString().split(",");
				int pro = ((IntWritable) var.get(new IntWritable(2))).get();
				 
				for (int i = 0; i < s.length; i++) {
			        if (s[i].equalsIgnoreCase("low"))
				
			{
			        	if(pro == 0)
			        	{
				   sum = sum + ((DoubleWritable) var.get(new DoubleWritable(3))).get();
				   sum1  = sum1 + ((IntWritable) var.get(new IntWritable(4))).get();
				   sum2 = sum2 + ((IntWritable) var.get(new IntWritable(5))).get();
			 
				}
			   }
				}
			   }	 
			    
			 
			  
			   department.set(sum);
			   department.set(sum1);
			   department.set(sum2);
			   
			   
			    
		
			
			  
				   context.write(key, new DoubleWritable(sum));
				   context.write(key, new DoubleWritable(sum1));
				   context.write(key, new DoubleWritable(sum2));
				   
			   
			  
		}
			  
		catch (Exception e)
		{
			   e.printStackTrace();
		
	}
	

	}
		

}


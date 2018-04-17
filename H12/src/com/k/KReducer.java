package com.k;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class KReducer  extends Reducer<Text, IntWritable, Text, NullWritable>
{
	
	
	
	@SuppressWarnings("unused")
	public final void reduce(final Text key, final Iterable<IntWritable> values, final Context context) throws IOException, InterruptedException
	{
		try {
			 int projectsum = 0;
			
			for (IntWritable var : values)
			{
				projectsum += var.get();
			}
			for (IntWritable var : values)
			{
			int s = 0;
			 s = (s + projectsum);
			 double projectper = 0.0;
			 
			 projectper = ((projectsum/s)*100);
				   if(projectper > 40)
				   {
					   context.write(key, null);
				   }   
				   
				
			}
		}
		catch (Exception e) 
		{
			   e.printStackTrace();
			  }
				}
}
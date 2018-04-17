package com.u;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class OMapper extends Mapper<LongWritable, Text, Text, IntWritable> 
{
	private final Text department = new Text();
	
	
public void map(final LongWritable key, final Text value, final Context context)
		throws IOException, InterruptedException
		{		
		final String line = value.toString();	

final String[] data  = line.trim().split(",");

final String department = data[8];


	if (data.length == 10)
{
		try {
			
			
			   final int timespend = Integer.parseInt(data[4]);
			   if(timespend > 4)
			   {
				   int b = timespend;
			  context.write(new Text(department), new IntWritable(b));
			  } 
		}
		catch (Exception e) 
		{
			   e.printStackTrace();
			  }
		
	
}
		}


}

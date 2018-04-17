package com.promoted;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public final class ProMapper extends Mapper<LongWritable, Text, Text, MapWritable> 
{
	private final Text department = new Text();
	MapWritable mw = new MapWritable();
	
public void map(final LongWritable key, final Text value, final Context context)
		throws IOException, InterruptedException
		{		
		final String line = value.toString();	

final String[] data  = line.trim().split(",");

final String department = data[8];


	if (data.length == 10)
{
		try {
			   final int promoted = Integer.parseInt(data[6]);
			   final int left = Integer.parseInt(data[7]);
			   mw.put(new IntWritable(1),
		                new IntWritable(Integer.parseInt(data[6])));
			   
			   mw.put(new IntWritable(2),
		                new IntWritable(Integer.parseInt(data[7])));
			   
			   context.write(new Text(department), mw);
			  } 
		catch (Exception e) 
		{
			   e.printStackTrace();
			  }
		
	
}
		}
}


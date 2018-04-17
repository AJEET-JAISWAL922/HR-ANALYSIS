package com.avg.l;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class PMapper extends Mapper<LongWritable, Text, Text, MapWritable> 
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
			
			final String s = data[9];
			final int pro = Integer.parseInt(data[7]);
			   final double satis = Double.parseDouble(data[0]);
			   final int working = Integer.parseInt(data[3]);
			   final int left = Integer.parseInt(data[6]);
			   
			   mw.put(new IntWritable(1), new Text(data[9]));
		        
			   mw.put(new IntWritable(2),
		                new IntWritable(Integer.parseInt(data[7])));
			   
			   mw.put(new DoubleWritable(3),
		                new DoubleWritable(Double.parseDouble(data[0])));
			   
			   mw.put(new IntWritable(4),
		                new IntWritable(Integer.parseInt(data[3])));
			   mw.put(new IntWritable(5),
		                new IntWritable(Integer.parseInt(data[6])));
			   context.write(new Text(department), mw);
			  } 
		catch (Exception e) 
		{
			   e.printStackTrace();
			  }
		
	
}
		}

}


package com.no.of.project;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ProMapper extends Mapper<LongWritable, Text, Text, IntWritable> 
{
	private final Text category = new Text();
	private final IntWritable noofproject = new IntWritable();
public void map(final LongWritable key, final Text value, final Context context)
		throws IOException, InterruptedException
		{		
		final String line = value.toString();	

final String[] data  = line.trim().split(",");

final String department = data[8];


	if (data.length == 10)
{
		try {
			   final int noofproject = Integer.parseInt(data[2]);
			   context.write(new Text(department), new IntWritable(noofproject));
			  } 
		catch (Exception e) 
		{
			   e.printStackTrace();
			  }
		
	

}
}
} 

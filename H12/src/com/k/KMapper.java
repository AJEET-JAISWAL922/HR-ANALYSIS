package com.k;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class KMapper extends Mapper<LongWritable, Text, Text, IntWritable> 
{
	private final Text department = new Text();
	private final IntWritable projectno = new IntWritable();
	
public void map(final LongWritable key, final Text value, final Context context)
		throws IOException, InterruptedException
		{		
		final String line = value.toString();	

final String[] data  = line.trim().split(",");

final String department = data[8];


	if (data.length == 10)
{
		try {
			   final int projectno = Integer.parseInt(data[2]);
			   
			   
			   context.write(new Text(department), new IntWritable(projectno));
			  } 
		catch (Exception e) 
		{
			   e.printStackTrace();
			  }
		
	
}
		}

}

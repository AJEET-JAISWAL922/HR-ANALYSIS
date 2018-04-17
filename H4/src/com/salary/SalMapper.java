package com.salary;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SalMapper extends Mapper<LongWritable, Text, Text, Text> 
{
	private final Text category = new Text();
	private final Text salary = new Text();
public void map(final LongWritable key, final Text value, final Context context)
		throws IOException, InterruptedException
		{		
		final String line = value.toString();	

final String[] data  = line.trim().split(",");

final String department = data[8];


	if (data.length == 10)
{
		try {
			   final String salary = data[9];
			   context.write(new Text(department), new Text(salary));
			  } 
		catch (Exception e) 
		{
			   e.printStackTrace();
			  }
		
	
}
}
}

 

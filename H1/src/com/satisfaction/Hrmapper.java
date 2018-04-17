package com.satisfaction;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public final class Hrmapper extends Mapper<LongWritable, Text, Text, DoubleWritable> 
	{
		private final Text category = new Text();
		private final DoubleWritable satis = new DoubleWritable();
	public void map(final LongWritable key, final Text value, final Context context)
			throws IOException, InterruptedException
			{		
			final String line = value.toString();	

	final String[] data  = line.trim().split(",");

	final String department = data[8];


		if (data.length == 10)
	{
			try {
				   final double satis = Double.parseDouble(data[0]);
				   context.write(new Text(department), new DoubleWritable(satis));
				  } 
			catch (Exception e) 
			{
				   e.printStackTrace();
				  }
			
		
//					(Men's Clothing,214.05) 	output to reducer 
	}
	}
}
package com.h;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class QMapper extends Mapper<LongWritable, Text, IntWritable, Text> 
{
	
	
	
public void map(final LongWritable key, final Text value, final Context context)
		throws IOException, InterruptedException
		{		
		final String line = value.toString();	

final String[] data  = line.trim().split(",");
String str = data[4];
int val = 0;
try {
     val=Integer.parseInt(str);
    		 
}catch (NumberFormatException e)
{
    System.out.println("not a number"); 
} 
	if (data.length == 10)
{
		try {
			
			
			  
			   if(val > 4)
			   {
				   String s = data[9];
				   
			  context.write(new IntWritable(val), new Text(s));
			  } 
		}
		catch (Exception e) 
		{
			   e.printStackTrace();
			  }
		
	
}
		}



}

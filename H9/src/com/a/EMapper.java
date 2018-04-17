package com.a;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EMapper  extends Mapper<LongWritable, Text, IntWritable, IntWritable> 
{
	
	
public void map(LongWritable key, Text value, Context context)
		throws IOException, InterruptedException
		{		
String line = value.toString();	

String[] data  = line.trim().split(",");
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
			
			   final int left = Integer.parseInt(data[6]);
			   context.write(new IntWritable(val), new IntWritable(left));
			  } 
		catch (Exception e) 
		{
			   e.printStackTrace();
			  }
		
	

}
}



}

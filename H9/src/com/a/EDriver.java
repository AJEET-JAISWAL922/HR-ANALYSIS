package com.a;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class EDriver 
{

	public final static void main(final String[] args)throws Exception
	{
		if(args.length<2)
		{
			System.err.println("error");
			System.exit(-1);
		}
		try
		{
			

	 Job job = new Job();
				
		job.setJarByClass(EDriver.class);
		job.setJobName("Sev Driver");
		
		FileInputFormat.addInputPath(job, new Path(args[0])); 
		 FileOutputFormat.setOutputPath(job, new Path(args[1]));
		 
		 job.setMapperClass(EMapper.class);
		 job.setReducerClass(EReducer.class);	
		 job.setNumReduceTasks(1);
		 
		 job.setOutputKeyClass(IntWritable.class);
		 job.setOutputValueClass(IntWritable.class);
		 
		 job.setMapOutputKeyClass(IntWritable.class);
			job.setMapOutputValueClass(IntWritable.class);
			

			job.setInputFormatClass(TextInputFormat.class);
			job.setOutputFormatClass(TextOutputFormat.class);
		 
		 
		 
		 System.exit(job.waitForCompletion(true) ? 0 : 1); 
		 } 
		catch (IOException e) 
		{
			  e.printStackTrace();
			 } catch (ClassNotFoundException e) {
			  e.printStackTrace();
			 } catch (InterruptedException e) {
			  e.printStackTrace();
			 }
		 
	}
	

	

}

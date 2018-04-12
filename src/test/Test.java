package test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Test
{
	private static class MyTask implements Callable<String>
	{
		public int value;
		public MyTask(int value)
		{
			this.value = value;
		}
		
		@Override
		public String call() {
			// TODO Auto-generated method stub
			System.out.println("Callalbe:"+value);
			return "return:"+value;
		}
		
	}
   public static void main(String[] args)
   {
	   int n=10;
	   ExecutorService pool = Executors.newFixedThreadPool(n);
	   List<FutureTask<String>> list = new LinkedList<FutureTask<String>>();
	   for(int i=0;i<n;i++)
	   {
		   Callable<String> task = new MyTask(i);
		   FutureTask<String> futureTask = new FutureTask<String>(task);
		   list.add(futureTask);
		   pool.submit(futureTask);
		//	String s =pool.submit(task).get();
	   }
	
	   for(FutureTask<String> task:list)
	   {
			String s=null;
			try {
				s = task.get();
				
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   System.out.println(s);
	   }
	   pool.shutdown();
	   
   }
}
package Graphics;

import java.util.Date;

public class Stopwatch implements Runnable
{
	private Thread clock_thread;
	
	static long t01=new Date().getTime();
	static long t02=new Date().getTime();

	static private long elapsedTime1;
	static private long elapsedTime2;
		
	public Stopwatch()
	{
		clock_thread=new Thread(this);
		clock_thread.start();
	}
		
	@Override
	public void run()
	{
		long tx1;
		long time1;
		
		int s1=0;
		int m1=0;
		
		/////////////////
		long tx2;
		long time2;
		
		int s2=0;
		int m2=0;
		
		while(true)
		{						
			try
			{
				Thread.sleep(7);
            }
			catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
			
			if(Board.getTurn()%2==1)
			{
				tx1=new Date().getTime();
				
				time1=tx1-t01;
				
				s1=(int) (time1/1000);
				m1=s1/60;
				
				if(Board.getTurn()%2==1)
				{
					String timeString=minToString(m1)+":"+secToString(s1);
					//System.out.println(timeString);
					updateTimeLabel("p1", timeString);
				}
			}
			
			if(Board.getTurn()%2==0)
			{
				tx2=new Date().getTime();
				
				time2=tx2-t02;
				
				s2=(int) (time2/1000);
				m2=s2/60;
				
				if(Board.getTurn()%2==0)
				{
					String timeString=minToString(m2)+":"+secToString(s2);
					//System.out.println(timeString);
					updateTimeLabel("p2", timeString);
				}
			}
		}
    }
	
	public static void stopClock(String player)
	{
		if(player.equals("p1"))
		{
			elapsedTime1=(new Date().getTime())-t01;
		}
		else if(player.equals("p2"))
		{
			elapsedTime2=(new Date().getTime())-t02;
		}
		
		//System.out.println(elapsed_time);
	}
	
	public void updateTimeLabel(String player, String timeString)
	{
		if(player.equals("p1"))
		{
			Board.player1TimeLabel.setText(timeString);
		}
		
		if(player.equals("p2"))
		{
			Board.player2TimeLabel.setText(timeString);
		}
	}
	
	public static void resumeClock(String player)
	{
		if(player.equals("p1"))
		{
			t01=(new Date().getTime())-elapsedTime1;
		}
		else if(player.equals("p2"))
		{
			t02=(new Date().getTime())-elapsedTime2;
		}
	}
	
	public static String minToString(int min)
	{
		String minString="";
		
		if(min<10)
		{
			minString="0"+Integer.toString(min);
		}
		else
			minString=Integer.toString(min);
		
		return minString;
	}
	
	public static String secToString(int sec)
	{
		String secString="";
		sec=sec%60;
		
		if(sec<10)
		{
			secString="0"+Integer.toString(sec);
		}
		else
			secString=Integer.toString(sec);
			
		return secString;
	}
}

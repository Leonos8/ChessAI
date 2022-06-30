package Graphics;

import java.util.Date;

public class Stopwatch implements Runnable
{
	static String timeString;
	String player;

	long t0=new Date().getTime();
	
	public Thread t;
	
	public Stopwatch(String player)
	{
		t=new Thread(this);
		this.player=player;
	}
	
	@Override
	public void run()
	{
		long tx;
		long time;
		
		int s=0; //second
		int m=0; //minute
		
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
			
			tx=new Date().getTime();
			
			time=tx-t0;
			
			s=(int) (time/1000);
			m=s/60;
			if(player.equals("p1"))
			{
				timeString=minToString(m)+":"+secToString(s);
				System.out.println(timeString);
				Board.updateTime("p1", timeString);
			}
			else if(player.equals("p2"))
			{
				timeString=minToString(m)+":"+secToString(s);
				System.out.println(timeString);
				Board.updateTime("p2", timeString);
			}
		}
    }
	
	public static String getTimeString()
	{
		return timeString;
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
		
		if(sec<10)
		{
			secString="0"+Integer.toString(sec);
		}
		else
			secString=Integer.toString(sec);
		
		return secString;
	}
}

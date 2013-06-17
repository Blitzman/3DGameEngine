package com.base.engine;

public class Time
{
	public static final long SECOND = 1000000000L;
	
	private static double delta;
	
	public static long GetTime()
	{
		return System.nanoTime();
	}
	
	public static double GetDelta()
	{
		return delta;
	}
	
	public static void SetDelta(double delta)
	{
		Time.delta = delta;
	}
}

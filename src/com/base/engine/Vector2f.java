package com.base.engine;

public class Vector2f
{
	private float x;
	private float y;
	
	public Vector2f(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public float GetX()
	{
		return x;
	}

	public float GetY()
	{
		return y;
	}

	public void SetX(float x)
	{
		this.x = x;
	}

	public void SetY(float y)
	{
		this.y = y;
	}
	
	public String toString()
	{
		return "(" + x + "," + y + ")";
	}
}

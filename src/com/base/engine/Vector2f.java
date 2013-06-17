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
	
	public float Length()
	{
		return (float)Math.sqrt(x*x + y*y);
	}
	public Vector2f Normalize()
	{
		return new Vector2f(x/Length(), y/Length());
	}
	public Vector2f Rotate(float angle)
	{
		float rad = (float)Math.toRadians(angle);
		float cos = (float)Math.cos(rad);
		float sin = (float)Math.sin(rad);
		
		return new Vector2f(x*cos - y*sin, x*sin + y*cos);
	}
	
	public float Dot(Vector2f v)
	{
		return (x * v.x + y * v.y);
	}
	
	public Vector2f Add(Vector2f v)
	{
		return new Vector2f(x + v.x, y + v.y);
	}
	public Vector2f Add(float a)
	{
		return new Vector2f(x + a, y + a);
	}
	public Vector2f Sub(Vector2f v)
	{
		return new Vector2f(x - v.x, y - v.y);
	}
	public Vector2f Sub(float a)
	{
		return new Vector2f(x - a, y - a);
	}
	public Vector2f Mul(Vector2f v)
	{
		return new Vector2f(x * v.x, y * v.y);
	}
	public Vector2f Mul(float a)
	{
		return new Vector2f(x * a, y * a);
	}
	public Vector2f Div(Vector2f v)
	{
		return new Vector2f(x / v.x, y / v.y);
	}
	public Vector2f Div(float a)
	{
		return new Vector2f(x / a, y / a);
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
		return "(" + x + ", " + y + ")";
	}
}

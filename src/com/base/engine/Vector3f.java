package com.base.engine;

public class Vector3f
{
	private float x;
	private float y;
	private float z;
	
	public Vector3f()
	{
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
	}
	public Vector3f(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float Length()
	{
		return (float)Math.sqrt(x*x + y*y + z*z);
	}
	public Vector3f Normalize()
	{
		float length = Length();
		
		x /= length;
		y /= length;
		z /= length;
		
		return this;
	}
	public Vector2f Rotate(float angle)
	{
		float rad = (float)Math.toRadians(angle);
		float cos = (float)Math.cos(rad);
		float sin = (float)Math.sin(rad);
		
		return new Vector2f(x*cos - y*sin, x*sin + y*cos);
	}
	
	public float Dot(Vector3f v)
	{
		return (x * v.x + y * v.y + z * v.z);
	}
	public Vector3f Cross(Vector3f v)
	{
		float resX = y * v.z - z * v.y;
		float resY = z * v.x - x * v.z;
		float resZ = x * v.y - y * v.x;
		
		return new Vector3f(resX, resY, resZ);
	}
	
	public Vector3f Add(Vector3f v)
	{
		return new Vector3f(x + v.x, y + v.y, z - v.z);
	}
	public Vector3f Add(float a)
	{
		return new Vector3f(x + a, y + a, z + a);
	}
	public Vector3f Sub(Vector3f v)
	{
		return new Vector3f(x - v.x, y - v.y, z - v.z);
	}
	public Vector3f Sub(float a)
	{
		return new Vector3f(x - a, y - a, z - a);
	}
	public Vector3f Mul(Vector3f v)
	{
		return new Vector3f(x * v.x, y * v.y, z * v.z);
	}
	public Vector3f Mul(float a)
	{
		return new Vector3f(x * a, y * a, z * a);
	}
	public Vector3f Div(Vector3f v)
	{
		return new Vector3f(x / v.x, y / v.y, z / v.z);
	}
	public Vector3f Div(float a)
	{
		return new Vector3f(x / a, y / a, z / a);
	}
	
	public float GetX()
	{
		return x;
	}
	public float GetY()
	{
		return y;
	}
	public float GetZ()
	{
		return z;
	}

	public void SetX(float x)
	{
		this.x = x;
	}
	public void SetY(float y)
	{
		this.y = y;
	}
	public void SetZ(float z)
	{
		this.z = z;
	}
	
	public String toString()
	{
		return "(" + x + ", " + y + ", " + z + ")";
	}
}
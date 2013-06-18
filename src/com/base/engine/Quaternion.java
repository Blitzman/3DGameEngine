package com.base.engine;

public class Quaternion
{
	private float x;
	private float y;
	private float z;
	private float w;
	
	public Quaternion(float x, float y, float z, float w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public float Length()
	{
		return (float)Math.sqrt(x*x + y*y + z*z + w*w);
	}
	public Quaternion Normalize()
	{
		float length = Length();
		
		x /= length;
		y /= length;
		z /= length;
		w /= length;
		
		return this;
	}
	public Quaternion Conjugate()
	{
		return new Quaternion(-x, -y, -z, w);
	}

	public Quaternion Mul(Quaternion q)
	{
		float resX = w * q.w - x * q.x - y * q.y - z * q.z;
		float resY = x * q.w + w * q.x + y * q.z - z * q.y; 
		float resZ = y * q.w + w * q.y + z * q.x - x * q.z;
		float resW = z * q.w + w * q.z + x * q.y - y * q.x;
		
		return new Quaternion(resX, resY, resZ, resW);
	}
	public Quaternion Mul(Vector3f v)
	{
		float resX = -x * v.GetX() - y * v.GetY() - z * v.GetZ();
		float resY = w * v.GetX() + y * v.GetZ() - z * v.GetY();
		float resZ = w * v.GetY() + z * v.GetX() - x * v.GetZ();
		float resW = w * v.GetZ() + x * v.GetY() - y * v.GetX();
		
		return new Quaternion(resX, resY, resZ, resW);
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
	public float GetW()
	{
		return w;
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
	public void SetW(float w)
	{
		this.w = w;
	}
}

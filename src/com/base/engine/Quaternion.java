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
		float resW = w * q.GetW() - x * q.GetX() - y * q.GetY() - z * q.GetZ();
		float resX = x * q.GetW() + w * q.GetX() + y * q.GetZ() - z * q.GetY(); 
		float resY = y * q.GetW() + w * q.GetY() + z * q.GetX() - x * q.GetZ();
		float resZ = z * q.GetW() + w * q.GetZ() + x * q.GetY() - y * q.GetX();
		
		return new Quaternion(resX, resY, resZ, resW);
	}
	public Quaternion Mul(Vector3f v)
	{
		float resW = -x * v.GetX() - y * v.GetY() - z * v.GetZ();
		float resX = w * v.GetX() + y * v.GetZ() - z * v.GetY();
		float resY = w * v.GetY() + z * v.GetX() - x * v.GetZ();
		float resZ = w * v.GetZ() + x * v.GetY() - y * v.GetX();
		
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

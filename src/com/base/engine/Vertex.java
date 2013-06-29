package com.base.engine;

public class Vertex
{
	public static final int SIZE = 3;
	
	private Vector3f position;
	
	public Vertex(Vector3f position)
	{
		this.position = position;
	}
	
	public Vector3f GetPosition()
	{
		return position;
	}
	
	public void SetPosition(Vector3f position)
	{
		this.position = position;
	}
	
	public String toString()
	{
		return position.toString();
	}
}

package com.base.engine;

public class Transformation
{
	private Vector3f translation;
	
	public Transformation()
	{
		translation = new Vector3f();
	}
	
	public Matrix4f GetTransformation()
	{
		Matrix4f translationMatrix = new Matrix4f().InitTranslation(translation);
		
		return translationMatrix;
	}
	
	public Vector3f GetTranslation()
	{
		return translation;
	}
	
	public void SetTranslation(Vector3f translation)
	{
		this.translation = translation;
	}
	public void SetTranslation(float x, float y, float z)
	{
		this.translation = new Vector3f(x, y, z);
	}
}

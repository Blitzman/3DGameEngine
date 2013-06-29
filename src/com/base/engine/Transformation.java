package com.base.engine;

public class Transformation
{
	private Vector3f translation;
	private Vector3f rotation;
	
	public Transformation()
	{
		translation = new Vector3f();
		rotation = new Vector3f();
	}
	
	public Matrix4f GetTransformation()
	{
		Matrix4f translationMatrix = new Matrix4f().InitTranslation(translation.GetX(),
																	translation.GetY(),
																	translation.GetZ());
		Matrix4f rotationMatrix = new Matrix4f().InitRotation(rotation.GetX(),
																rotation.GetY(),
																rotation.GetZ());
		
		return translationMatrix.Mul(rotationMatrix);
	}
	
	public Vector3f GetTranslation()
	{
		return translation;
	}
	public Vector3f GetRotation()
	{
		return rotation;
	}
	
	public void SetTranslation(Vector3f translation)
	{
		this.translation = translation;
	}
	public void SetTranslation(float x, float y, float z)
	{
		this.translation = new Vector3f(x, y, z);
	}
	public void SetRotation(Vector3f rotation)
	{
		this.rotation = rotation;
	}
	public void SetRotation(float x, float y, float z)
	{
		rotation = new Vector3f(x, y, z);
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Translation: " + translation.toString() + "\n");
		sb.append("Rotation: " + rotation.toString() + "\n");
		
		return sb.toString();
	}
}

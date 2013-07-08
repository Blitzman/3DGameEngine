package com.base.engine;

public class Transformation
{
	private static Camera camera;
	
	private static float zNear;
	private static float zFar;
	private static float width;
	private static float height;
	private static float fov;
	
	private Vector3f translation;
	private Vector3f rotation;
	private Vector3f scale;
	
	public Transformation()
	{
		translation = new Vector3f();
		rotation = new Vector3f();
		scale = new Vector3f(1.0f, 1.0f, 1.0f);
	}
	
	public Matrix4f GetTransformation()
	{
		Matrix4f translationMatrix = new Matrix4f().InitTranslation(translation.GetX(),
																	translation.GetY(),
																	translation.GetZ());
		
		Matrix4f rotationMatrix = new Matrix4f().InitRotation(rotation.GetX(),
															  rotation.GetY(),
															  rotation.GetZ());
		
		Matrix4f scaleMatrix = new Matrix4f().InitScale(scale.GetX(),
														scale.GetY(),
														scale.GetZ());
		
		return translationMatrix.Mul(rotationMatrix.Mul(scaleMatrix));
	}
	public Matrix4f GetProjectedTransformation()
	{
		Matrix4f transformationMatrix = GetTransformation();
		Matrix4f projectionMatrix = new Matrix4f().InitProjection(fov, width, height, zNear, zFar);
		Matrix4f cameraRotationMatrix = new Matrix4f().InitCamera(camera.getForward(), camera.getUp());
		Matrix4f cameraTranslationMatrix = new Matrix4f().InitTranslation(-camera.getPosition().GetX(),
																		  -camera.getPosition().GetY(),
																		  -camera.getPosition().GetZ());
		
		return projectionMatrix.Mul(cameraRotationMatrix.Mul(cameraTranslationMatrix.Mul(transformationMatrix)));
	}
	
	public Vector3f GetTranslation()
	{
		return translation;
	}
	public Vector3f GetRotation()
	{
		return rotation;
	}
	public Vector3f GetScale()
	{
		return scale;
	}
	public Camera GetCamera()
	{
		return camera;
	}
	
	public void SetProjection(float fov, float width, float height, float zNear, float zFar)
	{
		Transformation.fov = fov;
		Transformation.width = width;
		Transformation.height = height;
		Transformation.zNear = zNear;
		Transformation.zFar = zFar;
	}
	public void SetTranslation(Vector3f translation)
	{
		this.translation = translation;
	}
	public void SetTranslation(float x, float y, float z)
	{
		translation.SetX(x);
		translation.SetY(y);
		translation.SetZ(z);
	}
	public void SetRotation(Vector3f rotation)
	{
		this.rotation = rotation;
	}
	public void SetRotation(float x, float y, float z)
	{
		rotation.SetX(x);
		rotation.SetY(y);
		rotation.SetZ(z);
	}
	public void SetScale(Vector3f scale)
	{
		this.scale = scale;
	}
	public void SetScale(float x, float y, float z)
	{
		scale.SetX(x);
		scale.SetY(y);
		scale.SetZ(z);
	}
	public void SetCamera(Camera camera)
	{
		Transformation.camera = camera;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Translation: " + translation.toString() + "\n");
		sb.append("Rotation: " + rotation.toString() + "\n");
		
		return sb.toString();
	}
}

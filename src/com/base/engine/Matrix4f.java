package com.base.engine;

public class Matrix4f
{
	private float[][] matrix;
	
	public Matrix4f()
	{
		matrix = new float[4][4];
	}
	
	public Matrix4f InitIdentity()
	{
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (i == j) matrix[i][j] = 1;
				else matrix[i][j] = 0;
		
		return this;
	}	
	public Matrix4f InitTranslation(float x, float y, float z)
	{
		matrix[0][0] = 1;	matrix[0][1] = 0;	matrix[0][2] = 0;	matrix[0][3] = x;
		matrix[1][0] = 0;	matrix[1][1] = 1;	matrix[1][2] = 0;	matrix[1][3] = y;
		matrix[2][0] = 0;	matrix[2][1] = 0;	matrix[2][2] = 1;	matrix[2][3] = z;
		matrix[3][0] = 0;	matrix[3][1] = 0;	matrix[3][2] = 0;	matrix[3][3] = 1;
		
		return this;
	}
	public Matrix4f InitRotation(float x, float y, float z)
	{
		Matrix4f rx = new Matrix4f().InitIdentity();
		Matrix4f ry = new Matrix4f().InitIdentity();
		Matrix4f rz = new Matrix4f().InitIdentity();
		
		x = (float)Math.toRadians(x);
		y = (float)Math.toRadians(y);
		z = (float)Math.toRadians(z);
		
		rz.matrix[0][0] = (float)Math.cos(z);	
		rz.matrix[0][1] = -(float)Math.sin(z);
		rz.matrix[1][0] = (float)Math.sin(z);
		rz.matrix[1][1] = (float)Math.cos(z);
		
		rx.matrix[1][1] = (float)Math.cos(x);
		rx.matrix[2][1] = (float)Math.sin(x);
		rx.matrix[1][2] = -(float)Math.sin(x);
		rx.matrix[2][2] = (float)Math.cos(x);
		
		ry.matrix[0][0] = (float)Math.cos(y);
		ry.matrix[2][0] = (float)Math.sin(y);
		ry.matrix[0][2] = -(float)Math.sin(y);
		ry.matrix[2][2] = (float)Math.cos(y);
		
		matrix = rz.Mul(ry.Mul(rx)).GetMatrix();
		
		return this;
	}
	public Matrix4f InitScale(float x, float y, float z)
	{
		matrix[0][0] = x;	matrix[0][1] = 0;	matrix[0][2] = 0;	matrix[0][3] = 0;
		matrix[1][0] = 0;	matrix[1][1] = y;	matrix[1][2] = 0;	matrix[1][3] = 0;
		matrix[2][0] = 0;	matrix[2][1] = 0;	matrix[2][2] = z;	matrix[2][3] = 0;
		matrix[3][0] = 0;	matrix[3][1] = 0;	matrix[3][2] = 0;	matrix[3][3] = 1;
		
		return this;
	}
	public Matrix4f InitProjection(float fov, float width, float height, float zNear, float zFar)
	{
		float aspectRatio = width / height;
		float tanHalfFov = (float)Math.tan(Math.toRadians(fov / 2));
		float zRange = zNear - zFar;
		
		matrix[0][0] = 1.0f / (tanHalfFov * aspectRatio);	matrix[0][1] = 0;					matrix[0][2] = 0;							matrix[0][3] = 0;
		matrix[1][0] = 0;									matrix[1][1] = 1.0f / tanHalfFov;	matrix[1][2] = 0;							matrix[1][3] = 0;
		matrix[2][0] = 0;									matrix[2][1] = 0;					matrix[2][2] = (-zNear - zFar) / zRange;	matrix[2][3] = 2 * zFar * zNear / zRange;
		matrix[3][0] = 0;									matrix[3][1] = 0;					matrix[3][2] = 1;							matrix[3][3] = 0;
		
		return this;
	}
	
	public Matrix4f Mul(Matrix4f m)
	{
		Matrix4f res = new Matrix4f();
		
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				float acc = 0.0f;
				
				for (int k = 0; k < 4; k++)
					acc += matrix[i][k] * m.GetElement(k, j);
				
				res.SetElement(i, j, acc);
			}
		}		
		
		matrix = res.GetMatrix();
		
		return this;
	}
	
	public float[][] GetMatrix()
	{
		return matrix;
	}
	public float GetElement(int x, int y)
	{
		return matrix[x][y];
	}
	
	public void SetMatrix(float[][] m)
	{
		matrix = m;
	}
	public void SetElement(int x, int y, float e)
	{
		matrix[x][y] = e;
	}
	
	public String ToString()
	{
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				sb.append("[" + matrix[i][j] + "]");
		
		return sb.toString();
	}
}

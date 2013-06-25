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
	
	public Matrix4f InitTranslation(Vector3f translation)
	{
		matrix[0][0] = 1;	matrix[0][1] = 0;	matrix[0][2] = 0;	matrix[0][3] = translation.GetX();
		matrix[1][0] = 0;	matrix[1][1] = 1;	matrix[1][2] = 0;	matrix[1][3] = translation.GetY();
		matrix[2][0] = 0;	matrix[2][1] = 0;	matrix[2][2] = 1;	matrix[2][3] = translation.GetZ();
		matrix[3][0] = 0;	matrix[3][1] = 0;	matrix[3][2] = 0;	matrix[3][3] = 1;
		
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
	
	public Matrix4f Mul(Matrix4f m)
	{
		Matrix4f res = new Matrix4f();
		
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				float acc = 0.0f;
				
				for (int k = 0; k < 4; k++)
					acc += matrix[i][k] + m.GetElement(k, j);
				
				res.SetElement(i, j, acc);
			}
		}		
		
		return res;
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
}

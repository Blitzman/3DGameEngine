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

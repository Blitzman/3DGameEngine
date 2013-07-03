package com.base.engine;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;

public class Util
{
	public static IntBuffer CreateFlippedBuffer(int[] indices)
	{
		IntBuffer buffer = BufferUtils.createIntBuffer(indices.length);
		buffer.put(indices);
		buffer.flip();
		
		return buffer;
	}
	
	public static FloatBuffer CreateFlippedBuffer(Vertex[] vertices)
	{
		FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length * Vertex.SIZE);
		
		for (int i = 0; i < vertices.length; i++)
		{
			buffer.put(vertices[i].GetPosition().GetX());
			buffer.put(vertices[i].GetPosition().GetY());
			buffer.put(vertices[i].GetPosition().GetZ());
		}
		
		buffer.flip();
		
		return buffer;
	}
	
	public static FloatBuffer CreateFlippedBuffer(Matrix4f matrix)
	{
		FloatBuffer buffer = BufferUtils.createFloatBuffer(4*4);
		
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				buffer.put(matrix.GetElement(i, j));
				
		buffer.flip();
		
		return buffer;
	}
}

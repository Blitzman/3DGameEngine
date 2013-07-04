package com.base.engine;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

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
	
	public static String[] RemoveEmptyStrings(String[] strings)
	{
		ArrayList<String> result = new ArrayList<String>();
		
		for (int i = 0; i < strings.length; i++)
			if (!strings[i].equals(""))
				result.add(strings[i]);
		
		String[] resultArray = new String[result.size()];
		result.toArray(resultArray);
		
		return resultArray;
	}
	
	public static int[] ToIntArray(Integer[] data)
	{
		int[] result = new int[data.length];
		
		for (int i = 0; i < data.length; i++)
			result[i] = data[i];
		
		return result;
	}
}

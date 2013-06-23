package com.base.engine;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

public class Util
{
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
}

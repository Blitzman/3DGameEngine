package com.base.engine;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.*;

public class Shader
{
	private int program;
	
	public Shader()
	{
		program = glCreateProgram();
		
		if (program == 0)
		{
			System.err.println("Shader Creation failed: Invalid memory location in constructor");
			System.exit(-1);
		}
	}
	
	public void Bind()
	{
		glUseProgram(program);
	}
	
	public void AddVertexShader(String text)
	{
		AddProgram(text, GL_VERTEX_SHADER);
	}
	
	public void AddGeometryShader(String text)
	{
		AddProgram(text, GL_GEOMETRY_SHADER);
	}
	
	public void AddFragmentShader(String text)
	{
		AddProgram(text, GL_FRAGMENT_SHADER);
	}
	
	public void CompileShader()
	{
		glLinkProgram(program);
		
		if (glGetProgrami(program, GL_LINK_STATUS) == 0)
		{
			System.err.println(glGetProgramInfoLog(program, 1024));
			System.exit(-1);
		}
		
		glValidateProgram(program);
		
		if (glGetProgrami(program, GL_VALIDATE_STATUS) == 0)
		{
			System.err.println(glGetProgramInfoLog(program, 1024));
			System.exit(-1);
		}
	}
	
	private void AddProgram(String text, int type)
	{
		int shader = glCreateShader(type);
		
		if (shader == 0)
		{
			System.err.println("Shader Creation failed: Invalid memory location when adding the shader.");
			System.exit(-1);
		}
		
		glShaderSource(shader, text);
		glCompileShader(shader);
		
		if (glGetShaderi(shader, GL_COMPILE_STATUS) == 0)
		{
			System.err.println(glGetShaderInfoLog(shader, 1024));
			System.exit(-1);
		}
		
		glAttachShader(program, shader);
	}
}

package com.base.engine;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.*;

import java.util.HashMap;

public class Shader
{
	private int program;
	private HashMap<String, Integer> uniforms;
	
	public Shader()
	{
		program = glCreateProgram();
		uniforms = new HashMap<String, Integer>();
		
		if (program == 0)
		{
			System.err.println("Shader Creation failed: Invalid memory location in constructor");
			System.exit(-1);
		}
	}
	
	public void AddUniform(String uniform)
	{
		int uniformLocation = glGetUniformLocation(program, uniform);
		
		if (uniformLocation == -1)
		{
			System.err.println("Could not find uniform: " + uniform);
			new Exception().printStackTrace();
			System.exit(-1);
		}
		
		uniforms.put(uniform, uniformLocation);
	}
	
	public void SetUniformi(String uniform, int value)
	{
		glUniform1i(uniforms.get(uniform), value);
	}
	
	public void SetUniformf(String uniform, float value)
	{
		glUniform1f(uniforms.get(uniform), value);
	}
	
	public void SetUniform(String uniform, Vector3f value)
	{
		glUniform3f(uniforms.get(uniform), value.GetX(), value.GetY(), value.GetZ());
	}
	
	public void SetUniform(String uniform, Matrix4f value)
	{
		glUniformMatrix4(uniforms.get(uniform), true, Util.CreateFlippedBuffer(value));
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
	
	public void Compile()
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
	
	public void Bind()
	{
		glUseProgram(program);
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

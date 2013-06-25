package com.base.engine;

import org.lwjgl.input.Keyboard;

public class Game
{
	private Mesh mesh;
	private Shader shader;
	
	float temp = 0.0f;
	
	public Game()
	{
		mesh = new Mesh();
		shader = new Shader();
		
		Vertex[] data = new Vertex[] { 	new Vertex(new Vector3f(-1, -1, 0)),
										new Vertex(new Vector3f(0, 1, 0)), 
										new Vertex(new Vector3f(1, -1, 0)) };
		
		mesh.AddVertices(data);
		
		shader.AddVertexShader(ResourceLoader.LoadShader("basicVertex.vs"));
		shader.AddFragmentShader(ResourceLoader.LoadShader("basicFragment.fs"));
		shader.Compile();
		
		shader.AddUniform("uniformFloat");
	}
	
	public void Input()
	{
		if (Input.GetKeyDown(Keyboard.KEY_UP))
			System.out.println("UP Pressed");
		if (Input.GetKeyUp(Keyboard.KEY_UP))
			System.out.println("UP is Up");
		
		if (Input.GetMouseDown(0))
			System.out.println("Click pressed at " + Input.GetMousePosition().toString());
		if (Input.GetMouseUp(0))
			System.out.println("Click released at " + Input.GetMousePosition().toString());
	}
	
	public void Update()
	{
		temp += Time.GetDelta();
		shader.SetUniformf("uniformFloat", (float)Math.abs(Math.sin(temp)));
	}
	
	public void Render()
	{
		shader.Bind();
		mesh.Draw();
	}
}

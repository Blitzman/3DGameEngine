package com.base.engine;

import org.lwjgl.input.Keyboard;

public class Game
{
	private Mesh mesh;
	private Shader shader;
	private Transformation transform;
	
	public Game()
	{
		mesh = ResourceLoader.LoadMesh("cube.obj");
		shader = new Shader();
		
//		Vertex[] vertices = new Vertex[] { 	new Vertex(new Vector3f(-1, -1, 0)),
//											new Vertex(new Vector3f(0, 1, 0)), 
//											new Vertex(new Vector3f(1, -1, 0)),
//											new Vertex(new Vector3f(0, -1, 1)) };
//
//		int[] indices = new int[] { 0, 1, 3,
//									3, 1, 2,
//									2, 1, 0,
//									0, 2, 3 };
//		
//		mesh.AddVertices(vertices, indices);
		
		transform = new Transformation();
		
		shader.AddVertexShader(ResourceLoader.LoadShader("basicVertex.vs"));
		shader.AddFragmentShader(ResourceLoader.LoadShader("basicFragment.fs"));
		shader.Compile();
		
		shader.AddUniform("transform");
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
	
	float temp = 0.0f;
	
	public void Update()
	{
		temp += Time.GetDelta();
		
		transform.SetTranslation((float)Math.sin(temp), 0.0f, 0.0f);
		transform.SetRotation(0, (float)Math.sin(temp) * 180.0f, 0);
		transform.SetScale(0.7f * (float)Math.sin(temp), 0.7f * (float)Math.sin(temp), 0.7f * (float)Math.sin(temp));
	}
	
	public void Render()
	{
		shader.Bind();
		shader.SetUniform("transform", transform.GetTransformation());
		mesh.Draw();
	}
}

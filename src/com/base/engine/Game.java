package com.base.engine;

public class Game
{
	private Mesh mesh;
	private Shader shader;
	private Transformation transform;
	private Camera camera;
	
	public Game()
	{
		mesh = ResourceLoader.LoadMesh("cube.obj");
		shader = new Shader();
		camera = new Camera();
		
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
		transform.SetProjection(70.0f, Window.GetWidth(), Window.GetHeight(), 0.1f, 1000.0f);
		transform.SetCamera(camera);
		
		shader.AddVertexShader(ResourceLoader.LoadShader("basicVertex.glsl"));
		shader.AddFragmentShader(ResourceLoader.LoadShader("basicFragment.glsl"));
		shader.Compile();
		
		shader.AddUniform("transform");
	}
	
	public void Input()
	{
		camera.input();
	}
	
	float temp = 0.0f;
	
	public void Update()
	{
		temp += Time.GetDelta();
		
		transform.SetTranslation(0.0f, 0.0f, 5.0f);
		//transform.SetRotation((float)Math.sin(temp) * 180.0f, (float)Math.sin(temp) * 180.0f, 0.0f);
		//transform.SetScale(0.7f * (float)Math.sin(temp), 0.7f * (float)Math.sin(temp), 0.7f * (float)Math.sin(temp));
	}
	
	public void Render()
	{
		shader.Bind();
		shader.SetUniform("transform", transform.GetProjectedTransformation());
		mesh.Draw();
	}
}

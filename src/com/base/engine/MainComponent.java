package com.base.engine;

public class MainComponent
{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "3DGameEngine";
	public static final double FRAME_CAP = 500.0;
	
	private boolean isRunning;
	private Game game;
	
	public MainComponent()
	{
		System.out.println(RenderUtil.GetOpenGLVersion());
		RenderUtil.InitGraphics();
		isRunning = false;
		game = new Game();
	}
	
	public void Start()
	{
		if (!isRunning)
			Run();
	}
	
	public void Stop()
	{
		if (isRunning)
			isRunning = false;
	}
	
	private void Run()
	{
		isRunning = true;
		
		int frames = 0;
		long frameCounter = 0;
		
		final double frameTime = 1.0 / FRAME_CAP;
		
		long lastTime = Time.GetTime();
		double unprocessedTime = 0.0;
		
		while(isRunning)
		{
			boolean render = false;
			
			long startTime = Time.GetTime();
			long passedTime = startTime - lastTime;
			lastTime = startTime;
			
			unprocessedTime += passedTime / (double)Time.SECOND;
			frameCounter += passedTime;
			
			while (unprocessedTime > frameTime)
			{
				render = true;
				
				unprocessedTime -= frameTime;
				
				if (Window.IsCloseRequested())
					Stop();
				
				Time.SetDelta(frameTime);
				
				Input.Update();
				
				game.Input();
				game.Update();
				
				if (frameCounter >= Time.SECOND)
				{
					System.out.println("FPS: " + frames);
					frames = 0;
					frameCounter = 0;
				}
			}
		
			if (render)
			{
				Render();
				frames++;
			}
			else
			{
				try
				{
					Thread.sleep(1);
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		CleanUp();
	}
	
	private void Render()
	{
		RenderUtil.ClearScreen();
		game.Render();
		Window.Render();
	}
	
	private void CleanUp()
	{
		Window.Dispose();
	}
	
	public static void main(String[] args)
	{
		Window.CreateWindow(WIDTH, HEIGHT, TITLE);
		
		MainComponent game = new MainComponent();
		
		game.Start();
	}
}

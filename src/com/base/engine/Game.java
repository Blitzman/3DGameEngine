package com.base.engine;

import org.lwjgl.input.Keyboard;

public class Game
{
	public Game()
	{
		
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
		
	}
	
	public void Render()
	{
		
	}
}

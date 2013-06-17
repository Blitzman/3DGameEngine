package com.base.engine;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Input
{
	public static final int NUM_KEYCODES = 256;
	public static final int NUM_MOUSEBUTTONS = 5;
	
	private static ArrayList<Integer> currentKeys = new ArrayList<Integer>();
	private static ArrayList<Integer> downKeys = new ArrayList<Integer>();
	private static ArrayList<Integer> upKeys = new ArrayList<Integer>();
	
	private static ArrayList<Integer> currentMouse = new ArrayList<Integer>();
	private static ArrayList<Integer> downMouse = new ArrayList<Integer>();
	private static ArrayList<Integer> upMouse = new ArrayList<Integer>();
	
	public static void Update()
	{
		upKeys.clear();
		
		for (int i = 0; i < NUM_KEYCODES; i++)
			if (!GetKey(i) && currentKeys.contains(i))
				upKeys.add(i);
		
		downKeys.clear();
		
		for (int i = 0; i < NUM_KEYCODES; i++)
			if (GetKey(i) && !currentKeys.contains(i))
				downKeys.add(i);
		
		currentKeys.clear();
		
		for (int i = 0; i < NUM_KEYCODES; i++)
			if (GetKey(i))
				currentKeys.add(i);
		
		upMouse.clear();
		
		for (int i = 0; i < NUM_MOUSEBUTTONS; i++)
			if (!GetMouse(i) && currentMouse.contains(i))
				upMouse.add(i);
		
		downMouse.clear();
		
		for (int i = 0; i < NUM_MOUSEBUTTONS; i++)
			if (GetMouse(i) && !currentMouse.contains(i))
				downMouse.add(i);
		
		currentMouse.clear();
		
		for (int i = 0; i < NUM_MOUSEBUTTONS; i++)
			if (GetMouse(i))
				currentMouse.add(i);
		
	}
	
	public static boolean GetKey(int keyCode)
	{
		return Keyboard.isKeyDown(keyCode);
	}
	
	public static boolean GetKeyDown(int keyCode)
	{
		return downKeys.contains(keyCode);
	}
	
	public static boolean GetKeyUp(int keyCode)
	{
		return upKeys.contains(keyCode);
	}
	
	public static boolean GetMouse(int mouseButton)
	{
		return Mouse.isButtonDown(mouseButton);
	}
	
	public static boolean GetMouseDown(int mouseButton)
	{
		return downMouse.contains(mouseButton);
	}
	
	public static boolean GetMouseUp(int mouseButton)
	{
		return upMouse.contains(mouseButton);
	}
	
	public static Vector2f GetMousePosition()
	{
		return new Vector2f(Mouse.getX(), Mouse.getY());
	}
}

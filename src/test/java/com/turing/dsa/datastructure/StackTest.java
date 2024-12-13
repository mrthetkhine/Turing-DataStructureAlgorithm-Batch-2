package com.turing.dsa.datastructure;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class StackTest {
	
	 Stack stack = new Stack(10);
	  @Test
	  public void testPush()
	  {

		  stack.push(100);
		  assertEquals(1, stack.size());
		  
		  int element = stack.peek();
		  assertEquals(100, element);
	  }
	  
	  @Test
	  public void testPushElement2()
	  {
		 
		  stack.push(200);
		  assertEquals(1, stack.size());
		  
		  int element = stack.peek();
		  assertEquals(200, element);
	  }
	  @Test
	  public void testPushMultipleElement()
	  {
		  
		  stack.push(200);
		  stack.push(300);
		  assertEquals(2, stack.size());
		  
		  int element = stack.peek();
		  assertEquals(300, element);
	  }
	  @Test
	  public void testPop()
	  {
		  stack.push(100);
		  
		  int size = stack.size();
		  int element = stack.pop();
		  
		  assertEquals(100, element);
		  assertEquals(size-1, stack.size());
	  }
	  @Test
	  public void testPopTwo()
	  {
		  stack.push(100);
		  stack.push(200);
		  
		  int size = stack.size();
		  int element = stack.pop();
		  
		  assertEquals(200, element);
		  
		  element = stack.pop();
		  assertEquals(100, element);
		  
		  assertEquals(size-2, stack.size());
	  }
	  
}

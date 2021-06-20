package com.hjf.utils.youxi;

import java.awt.*;

public class TEs{


	public static void main(String[] args) throws AWTException {
		//"1".compareTo("3");
	
		//鼠标移动 ,延迟,键盘输入;
		
		
	    String keyImagePath = "D:/baofeng.bmp";
	    ImageFindDemo demo = new ImageFindDemo(keyImagePath);  
	    String [] position = demo.printFindData().split(",");
	    System.out.println(Integer.parseInt(position[0].trim()));
	   	System.out.println(Integer.parseInt(position[1].trim()));
		Robot robot2 = new Robot();
		robot2.mouseMove(Integer.parseInt(position[1].trim()) , Integer.parseInt(position[0].trim()));
	  
		
		
		
		 //下面是一些基础 
		
	 /*  
		Robot robot = new Robot();
		robot.mouseMove(100, 100);
		robot.delay(200);	
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(20);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);	
		robot.keyPress(65);
		robot.delay(20);
		robot.keyRelease(65);
		// 得到屏幕坐标的rgb 值
		Color c = robot.getPixelColor(15,15);
		int a = c.getRed();
		int a1 = c.getGreen();
		int a2 = c.getBlue();
		
		//自己完成上面和 上面 值一样
		int[] rgb = new int [3];
		int pixel = c.getRGB();
		rgb[0] = (pixel & 0xff) >> 16;
        rgb[1] = (pixel & 0xff) >> 8;
        rgb[2] = (pixel & 0xff);*/

	}

}

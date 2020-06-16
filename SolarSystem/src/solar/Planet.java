package solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;

public class Planet extends Star{
	//除了有图片和坐标，行星还有运行轨迹（椭圆，长轴，短轴），速度，角度，挨着某个Star飞
	double longAxis;
	double shortAxis;
	double speed;
	double degree;
	Star center;
	
	boolean satellite;
	
	public void draw(Graphics g) {
		super.draw(g);
//		相当于g.drawImage(img, (int)x, (int)y, null);
		move();
		if(!satellite) {
			drawTrace(g);
		}
	}
	
	public void drawTrace(Graphics g) {			//画椭圆轨迹
		double ovalX, ovalY, ovalWidth, ovalHeight;
		
		ovalWidth = longAxis*2;
		ovalHeight = shortAxis*2;
		ovalX = center.x + center.width/2 - longAxis;
		ovalY = center.y + center.height/2 - shortAxis;
		
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
		g.setColor(c);
	}
	public void move() {
		//沿着椭圆飞
				x = (center.x + center.width/2) + longAxis*Math.cos(degree);	//需要加上图片的宽度和高度的1/2
				y = (center.y + center.height/2) + shortAxis*Math.sin(degree);
				degree += speed; 
	}
	
	public Planet(Star center, String imgpath, double longAxis, double shortAxis, double speed) {
		super(GameUtil.getImage(imgpath));
		
		this.center = center;
		this.x = center.x + longAxis;
		this.y = center.y;
		
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
	}
	public Planet(Star center, String imgpath, double longAxis, double shortAxis, double speed, boolean satellite) {
		this(center, imgpath, longAxis, shortAxis, speed);
		this.satellite = satellite;
	}
	public Planet(Image img, double x, double y) {
		super(img, x, y);
	}
	public Planet(String imgpath, double x, double y) {
		super(imgpath, x, y);
	}

	

}

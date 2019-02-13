package test;

import java.awt.Point;

public class thoughtwork {
	public static void main(String[] args) {
		String command = "3 3\n"
				+ "0,1 0,2;"
				+ "0,0 1,0;"
				+ "0,1 1,1;"
				+ "0,2 1,2;"
				+ "1,0 1,1;"
				+ "1,1 1,2;"
				+ "1,1 2,1;"
				+ "1,2 2,2;"
				+ "2,0 2,1";
		Maze maze = MazeFactory.Create(command);
		String mazeText = maze.Render();
		System.out.println(mazeText);
	}
}

class MazeFactory{
	public static Maze Create(String command) {
		return new Maze(command);
	}
}

class Maze{
	int[][] maze;
	
	Maze(String command){
		String[] s = command.split("\n");
		init(s[0]);
		create(s[1]);
	}
	
	/**
	 * 生成对应网格的矩阵
	 * @param command1 command第一行，m*n的矩阵
	 */
	void init(String command1) {
		String[] mn = command1.split(" ");
		int m = Integer.valueOf(mn[0]);
		int n = Integer.valueOf(mn[0]);
		maze = new int[m*2+1][n*2+1];
		for(int i = 1; i < m*2+1; i = i+2) {
			for(int j = 1; j < n*2+1; j = j+2) {
				maze[i][j] = 1;
			}
		}
	}
	
	/**
	 * 连通command要求的网格
	 * @param command2 command第二行
	 */
	void create(String command2) {
		String[] connections = command2.split(";");
		for(String connection: connections) {
			Point[] points = getpoints(connection);
			connect(points);
		}
	};
	
	/**
	 * 对于每组连通数据，获得对应的两个点
	 * @param p 一组连通数据
	 * @return 对应两点构成的 point数组
	 */
	Point[] getpoints(String p) {
		Point[] points = new Point[2];
		
		String[] ps = p.split(" |,");
		try {
			points[0] = new Point(Integer.valueOf(ps[0]),Integer.valueOf(ps[1]));
			points[1] = new Point(Integer.valueOf(ps[2]),Integer.valueOf(ps[3]));
		}
		catch(Exception e){
			//Todo 异常123
		}
		
		return points;
	}
	
	/**
	 * 连通两点
	 * @param points 对应两点构成的point数组
	 */
	void connect(Point[] points) {
		if(Math.abs(points[0].x - points[1].x) +
				Math.abs(points[0].y - points[1].y)  == 1) {
			maze[points[0].x + points[1].x + 1][points[0].y + points[1].y + 1] = 1;
		}
		else {
			//Todo 异常4
		}
	}
	
	/**
	 * 输出渲染网格字符串
	 * @return 渲染网格字符串
	 */
	String Render() {
		String s = "";
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[0].length; j++) {
				if(maze[i][j] == 0) s += "[W]";
				else s += "[R]";
				if(j != maze[0].length-1) s += " ";
			}
			if(i != maze.length-1) s += "\n";
		}
		return s;
	}
}
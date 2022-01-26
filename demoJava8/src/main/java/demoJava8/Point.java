package demoJava8;

import java.util.Objects;

public class Point implements Comparable<Point>{
	private double x;
	private double y;
	
	public Point() {
		this.x=0;
		this.y=0;
	}
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}
	@Override
	public int compareTo(Point o) {
		if(this.getX()<o.getX()) {
			return -1;
		}else if(this.getX()>o.getX()) {
			return 1;
		}else if(this.getY()<o.getY()) {
			return -1;
		}else if(this.getY()>o.getY()){
			return 1;
		}else {
			return 0;
		}
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}

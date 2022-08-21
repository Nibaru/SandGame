package gg.twinhead.SandBox.util;

public class Vector {

	public float x;
	public float y;

	public Vector(){
		this.x = 0.0f;
		this.y = 0.0f;
	}

	public Vector(float x, float y){
		this.x = x;
		this.y = y;
	}

	public boolean equals(Vector vector){
		return this.x == vector.x && this.y == vector.y;
	}

	public void multiply(float f){
		this.x *= f;
		this.y *= f;
	}

	public void add(Vector vector){
		this.x += vector.x;
		this.y += vector.y;
	}

	public static double distance(Vector a, Vector b) {
		float v0 = b.x - a.x;
		float v1 = b.y - a.y;
		return Math.sqrt(v0*v0 + v1*v1);
	}
}

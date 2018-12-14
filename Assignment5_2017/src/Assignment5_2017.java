/**
 *
 * Student Name: Manik Shakya
 * Student Number: 2869290
 */

public class Assignment5_2017 {
	public static void main(String[] args) {
		// Shape test here
		Square s1 = new Square("Square", 15);
		System.out.println(s1.area());
		System.out.println(s1.perimeter());
		System.out.println(s1.diagonal());
		System.out.println(s1);
		
		Shape s2 = new Circle("Circle", 5);
		System.out.println(s2.area());
		
		//Test Rational class here ========================
		//Rational k = new Rational(4,5);
		Rational k = new Rational(-3,5);
		System.out.println(k);
		//Rational k1 = new Rational(20,8);
		Rational k1 = new Rational(11,7);
		System.out.println(k1);
		System.out.println(new Rational(-3,-4));
		
		System.out.println("Addition: " + k.add(k1));
		System.out.println("Substraction: " + k.sub(k1));
		System.out.println("Multiplication: " + k.mult(k1));
		System.out.println("Multiply By: " + k.multBy(5));
		System.out.println("Division: " + k.div(k1));
		System.out.println("Divide By: " + k.divBy(5));
		System.out.println("Equal = True or False: " + k.eq(k1));
	  //=================================================
		
		
		
		
	}
}
abstract class Shape{
	private String name;
	public Shape(String n){name = n;}
	public abstract double area();
	public abstract double perimeter();
	public String name(){return name;}
	public String toString(){
	 return String.format("%s area: %6.2f perimeter: %6.2f\n",
				          name, area(), perimeter());
	}
	public void display(){
		System.out.printf("%s with area %6.2f and perimeter %6.2f\n",
				          name, area(), perimeter());
	}
}
class Square extends Shape{
	private double width, height;
	public Square(String n, double w) {
		super(n);
		width = w;
	}
	public double area(){return width*width;}
	public double perimeter(){return 4*width;}
	
	public double diagonal(){
		return width*Math.sqrt(2);
	}
	
	public String toString(){
		return super.toString() + "Diagonal: " + diagonal();
	}
}
class Circle extends Shape{
	private final double PI = 3.14;
	private double radius;
	public Circle(String n, double radius) {
		super(n);
		this.radius = radius;
	}

	@Override
	public double area() {return PI * radius * radius;}
	
	@Override
	public double perimeter() {return 2 * PI * radius;}
	
	public String toString(){
		return "";
	}
}

interface Operations{
	public Rational add(Rational q);
	public Rational sub(Rational q);
	public Rational mult(Rational q);
	public Rational multBy(int k);
	public Rational div(Rational q);
	public Rational divBy(int k);
	public boolean eq(Rational q); //returns true if this equals q
} 
class Rational implements Operations{
	private int num,den;
	public Rational(int n, int d){//assume d != 0
        if(n < 0 && d < 0){ n = -n; d = -d;}
        else if(d < 0){ n = -n; d = -d;}
        //ensures that d never negative and n positive e.g. 1/-2 is changed to -1/2
        int g = gcd(Math.abs(n), Math.abs(d));
        num = n/g;den = d/g;
	}
	public Rational(int n){num = n; den = 1;}
	public int num(){return num;}
	public int den(){return den;}
	
	public Rational add(Rational q){
		//num = (this.num * q.den) - (q.num * this.den);
		//den = this.den * q.den;
		//return new Rational(num, den);
		
		Rational temp = new Rational(this.num, this.den);
		int newNum = (this.num * q.den) + (q.num * this.den);
		int newDen = this.den * q.den;
		this.num = temp.num;
		this.den = temp.den;
		return new Rational(newNum, newDen);
	}
	public Rational sub(Rational q){
		Rational temp = new Rational(this.num, this.den);
		int newNum = (this.num * q.den) - (q.num * this.den);
		int newDen = this.den * q.den;
		this.num = temp.num;
		this.den = temp.den;
		return new Rational(newNum, newDen);
		
		//num = (this.num * q.den);
		//num = (q.num * this.den);
		//den = this.den * q.den;
		//System.out.println("Num1: " + this.num + " Num2: " + q.den);
		//System.out.println("Num1: " + num + " Num2: " + num);System.out.println("Den: " + den);
		//return new Rational(num, den);
	}
	public Rational mult(Rational q){
		Rational temp = new Rational(this.num, this.den);
		int newNum = (this.num * q.num);
		int newDen = this.den * q.den;
		this.num = temp.num;
		this.den = temp.den;
		return new Rational(newNum, newDen);
	}
	public Rational multBy(int k){
		Rational temp = new Rational(this.num, this.den);
		int newNum = (this.num * k);
		int newDen = this.den * 1;
		this.num = temp.num;
		this.den = temp.den;
		return new Rational(newNum, newDen);
	}
	public Rational div(Rational q){
		Rational temp = new Rational(this.num, this.den);
		int newNum = (this.num * q.den);
		int newDen = this.den * q.num;
		this.num = temp.num;
		this.den = temp.den;
		return new Rational(newNum, newDen);
	}
	public Rational divBy(int k){
		Rational temp = new Rational(this.num, this.den);
		int newNum = (this.num * 1);
		int newDen = this.den * k;
		this.num = temp.num;
		this.den = temp.den;
		return new Rational(newNum, newDen);
	}
	public boolean eq(Rational q){
		return (this.num == q.num && this.den == q.den);
	}
	// ... all the other required methods
	public String toString(){return num+"/"+den;}
	private int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b,a%b);
  }
}
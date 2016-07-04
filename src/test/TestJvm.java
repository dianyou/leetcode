package test;

public class TestJvm {

	public static void main(String[] args)
	{
		test1();
		test2();
	}
	private static void test2()
	{
		boolean test = true;
		System.out.println(test);
	}
	
	private static void test1()
	{
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 4;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;
		System.out.println(g);
		System.out.println( c == d);
		System.out.println( e == f);
		System.out.println(c == (a+b));
		System.out.println(c.equals(a+b));
		System.out.println(g == (a+b));
		System.out.println(g.equals(a+b));
	}
	
}

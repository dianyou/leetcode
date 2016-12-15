package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String args[])
	{
		Pattern pattern = Pattern.compile("^(.*)$");
		Matcher matcher = pattern.matcher("/Hello World.js");
		System.out.println(matcher.matches());
	}
}

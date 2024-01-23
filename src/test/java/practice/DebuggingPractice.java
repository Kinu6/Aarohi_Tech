package practice;

import org.testng.annotations.Test;

public class DebuggingPractice {
	
@Test
public void method()
{
	System.out.println("This is Method Start");
	int z= div(1,0);
	System.out.println(z);
	
}

public static int div(int a, int b) {
    return a/b;	
}
}

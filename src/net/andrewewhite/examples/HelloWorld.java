package net.andrewewhite.examples;
 
public class HelloWorld {
	public static void main(String[] argv) {
		System.out.println("Hello World");
        new HelloWorld().execute("String");
	}

    private void execute(String string) {
        System.out.println("....");
    }
}
/* BasicAspect.java */
package net.andrewewhite.aspects;
 
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
 
@Aspect
public class BasicAspect {
 
	/* Read as -- do this *before* any *call* to the function
         * *java.io.PrintStream.println* that takes a *String*
         * and returns *void* and the function is not called
	 * within any class under the package net.andrewewhite.aspects
	 */
    @Before("execution(* *.execute(..))")
    public void beforePrintlnCall() {
        System.out.println("About to make call to print Hello World");
    }
 
    @After("    call(void java.io.PrintStream.println(String)) " +
           "&&  !within(net.andrewewhite.aspects..*)")
    public void afterPrintlnCall(JoinPoint.StaticPart thisJoinPointStaticPart) {
        System.out.println("Just made call to print Hello World : "+thisJoinPointStaticPart.getSignature());
    }
}
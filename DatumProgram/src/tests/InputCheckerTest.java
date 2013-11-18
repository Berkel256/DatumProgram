package tests;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import view.InputChecker;

@RunWith(Parameterized.class)
public class InputCheckerTest {
	private InputChecker check;
	private String input;
	private boolean isNumber;

	@Parameters
	public static Collection<Object[]> getValues(){
		Vector<Object[]> v = new Vector<Object[]>();
		//Object: input, isYear
		v.add(new Object[]{ "-100", true});
		v.add(new Object[]{ "5.5", false});
		v.add(new Object[]{ "2004", true});
		v.add(new Object[]{ "0", true});
		v.add(new Object[]{ "", false});
		v.add(new Object[]{ "5a", false});
		return v;
	}

	public InputCheckerTest(String input, boolean isNumber){
		this.input = input;
		this.isNumber = isNumber;
	}

	@Before
	public void initialize(){
		check = new InputChecker();
	}

	@Test
	public void isNumberTest() {
		boolean erg = check.isNumber(input);
		assertTrue(input + " is " + erg, erg == isNumber);
	}

}

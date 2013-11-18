package tests;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Vector;
import leapyear.CalendarException;
import leapyear.LeapYearCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class LeapYearCalculatorTest {
	private LeapYearCalculator calculator;
	private int year;
	private boolean isLeapYear;


	@Parameters
	public static Collection<Object[]> getValues(){
		Vector<Object[]> v = new Vector<Object[]>();
		//Object: year, isLeapYear
		v.add(new Object[]{ 2100, false});
		v.add(new Object[]{ 2004, true});
		return v;
	}



	public LeapYearCalculatorTest(int year, boolean isLeapYear){
		this.year = year;
		this.isLeapYear = isLeapYear;
	}

	@Before // each test
	public void initialize() {
		calculator = new LeapYearCalculator();
	}


	@Test
	public void testIsLeapYear() {
		boolean erg;
		try {
			erg = calculator.isLeapYear(year);
			assertTrue(year + " is " + erg, erg == isLeapYear);
		} catch (CalendarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = CalendarException.class)
	public void testIsLeapYearException() throws CalendarException{
		int year = Integer.MIN_VALUE;
		calculator.isLeapYear(year);
	}



}

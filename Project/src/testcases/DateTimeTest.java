package testcases;

import classes.DateTime;
import net.datafaker.Faker;
import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class DateTimeTest {
	Faker faker = new Faker();
	
    @Test
    public void testbdaypat()
    {
		String input = faker.date().birthday("yyyy/mm/dd");
		//System.out.println(input);
        assertTrue(DateTime.verifybirthdate(input));
    }
    
    @Test
    public void testbdayminmax()
    {
		String input = faker.date().birthday(0, 25, "yyyy/mm/dd");
		//System.out.println(input);
        assertTrue(DateTime.verifybirthdate(input));
    }
    
    @Test
    public void testbday()
    {
		Timestamp input = faker.date().birthday();
		//System.out.println(input);
        assertTrue(DateTime.verifybirthdatestamp(input));
    }
    
    @Test
    public void testDurations()
    {
		Duration input = faker.date().duration(5, ChronoUnit.DAYS);
		Duration input2 = faker.date().duration(5, "DAYS");
		Duration input3 = faker.date().duration(0, 5, ChronoUnit.DAYS);
		Duration input4 = faker.date().duration(0, 5, "DAYS");
        assertTrue(DateTime.verifyduration(input));
        assertTrue(DateTime.verifyduration(input2));
        assertTrue(DateTime.verifyduration(input3));
        assertTrue(DateTime.verifyduration(input4));
    }
    
    @Test
    public void testFutures()
    {
    	Timestamp input = faker.date().future(5, TimeUnit.DAYS);
    	Timestamp input2 = faker.date().future(5, 1, TimeUnit.DAYS);
    	
    	String input3 = faker.date().future(5, TimeUnit.DAYS,"yyyy-mm-dd hh:mm:ss");
    	String input4 = faker.date().future(5, 1, TimeUnit.DAYS, "yyyy-mm-dd hh:mm:ss");
    	
    	assertTrue(DateTime.verifyfutures1(input));
    	assertTrue(DateTime.verifyfutures2(input2, 1, 5));
    	assertTrue(DateTime.verifyfutures3(input3));
    	//assertTrue(DateTime.verifyfutures4(input4, 1, 5)); //THIS TEST HAS PROBLEMS
    }
    
    @Test
    public void testPasts()
    {
    	Timestamp input = faker.date().past(5, TimeUnit.DAYS);
    	Timestamp input2 = faker.date().past(5, 1, TimeUnit.DAYS);
    	
    	String input3 = faker.date().past(5, TimeUnit.DAYS,"yyyy-mm-dd hh:mm:ss");
    	String input4 = faker.date().past(5, 1, TimeUnit.DAYS, "yyyy-mm-dd hh:mm:ss");
    	
    	assertTrue(DateTime.verifypast1(input));
    	assertTrue(DateTime.verifypast2(input2, 1, 5));
    	assertTrue(DateTime.verifypast3(input3));
    	//assertTrue(DateTime.verifypast4(input4, 1, 5)); //THIS TEST HAS PROBLEMS AS WELL
    }
    
}
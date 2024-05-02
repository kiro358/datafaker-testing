package testcases;

import classes.Finance;
import net.datafaker.Faker;
import static org.junit.Assert.*;
import org.junit.Test;

public class FinanceTest {
	
    @Test
    public void testexpiry()
    {
    	Faker faker = new Faker();
		String input = faker.business().creditCardExpiry();
		//System.out.println(input);
        assertTrue(Finance.verifyexpiry(input));
    }
    
    @Test
    public void testnumber()
    {
    	Faker faker = new Faker();
		String input = faker.business().creditCardNumber();
		//System.out.println(input);
        assertTrue(Finance.verifycard(input));
    }
    
    @Test
    public void testtype()
    {
    	Faker faker = new Faker();
		String input = faker.business().creditCardType();
		//System.out.println(input);
        assertTrue(Finance.verifytype(input));
    }
    
    @Test
    public void testsecurity()
    {
    	Faker faker = new Faker();
		String input = faker.business().securityCode();
		//System.out.println(input);
        assertTrue(Finance.verifysecurity(input));
    }
    
    @Test
    public void testhash()
    {
    	Faker faker = new Faker();
		int input = faker.business().hashCode();
		System.out.println(input);
        assertTrue(Finance.verifyhash(input));
    }
    
}

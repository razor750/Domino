import static org.junit.Assert.*;

import org.junit.Test;

public class test {

	@Test
	public void test_forward() {
		assertTrue(Run.predictDomino("||//||\\||/\\|", 1).equals("||///\\\\||/\\|"));
	}
	
	@Test
	public void test_backward() {
		assertTrue(Run.predictDomino("||////\\\\\\|////|", -2).equals("||//||||\\|//|||"));
	}

}

package org.wahlzeit.services.mailing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	EmailAddressTest.class,
	EmailServiceTest.class
})
public class EmailServiceTestSuite {
}

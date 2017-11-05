package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.mailing.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	InteractionTestSuite.class,
	EmailServiceTestSuite.class,
	FunctionalityTestSuite.class	
})

public class WahlzeitTestSuite {
}

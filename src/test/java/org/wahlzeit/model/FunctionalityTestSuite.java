package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.persistence.*;
import org.wahlzeit.services.*;
import org.wahlzeit.utils.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	PhotoFilterTest.class,
	ValueTest.class,
	DatastoreAdapterTest.class,
	LogBuilderTest.class,
	StringUtilTest.class,
	VersionTest.class
})

public class FunctionalityTestSuite {

}

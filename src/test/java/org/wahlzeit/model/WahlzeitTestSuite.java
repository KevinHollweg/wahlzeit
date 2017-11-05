package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.*;
import org.wahlzeit.model.persistence.*;
import org.wahlzeit.services.*;
import org.wahlzeit.services.mailing.*;
import org.wahlzeit.utils.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	TellFriendTest.class,
	AccessRightsTest.class,
	FlagReasonTest.class,
	GenderTest.class,
	GuestTest.class,
	LocationCoordinateTest.class,
	PhotoFilterTest.class,
	TagsTest.class,
	UserStatusTest.class,
	ValueTest.class,
	DatastoreAdapterTest.class,
	LogBuilderTest.class,
	EmailServiceTestSuite.class,
	StringUtilTest.class,
	VersionTest.class
	
})

public class WahlzeitTestSuite {
}

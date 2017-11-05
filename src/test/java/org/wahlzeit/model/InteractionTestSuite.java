package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	TellFriendTest.class,
	AccessRightsTest.class,
	FlagReasonTest.class,
	GenderTest.class,
	GuestTest.class,
	TagsTest.class,
	UserStatusTest.class
})

public class InteractionTestSuite {

}

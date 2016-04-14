package zm.hashcode.hashdroidpvt;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import zm.hashcode.hashdroidpvt.factories.settings.AddressTypeFactoryTest;
import zm.hashcode.hashdroidpvt.factories.settings.ContactTypeFactoryTest;
import zm.hashcode.hashdroidpvt.factories.settings.GenderFactoryTest;
import zm.hashcode.hashdroidpvt.factories.settings.SettingsFactoryTest;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
// Runs all unit tests.
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddressTypeFactoryTest.class,
        ContactTypeFactoryTest.class,
        GenderFactoryTest.class,
        SettingsFactoryTest.class})
public class AppUnitTestSuite {}
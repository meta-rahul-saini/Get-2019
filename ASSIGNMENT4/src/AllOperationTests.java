import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ CountClumpsTest.class, FixXYTest.class, MaxMirrorTest.class,
		SplitArrayIndexTest.class })
public class AllOperationTests {

}

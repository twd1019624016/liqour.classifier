package classifier.detection;

import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;

import classifier.detection.liqour.LiqourDetectRequest;
import classifier.detection.liqour.LiqourDetectResponse;

public class ClassifierFacadeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {


/*		ClassifierFacade liqourClassifier = ClassifierFacade.getInstanceClassifierFacade("bz-3.12-1.csv");
*/		
	 URL resource = ClassifierFacadeTest.class.getClassLoader().getResource("bz-3.12-1.csv");
	 System.out.println(resource);
	ClassifierFacade liqourClassifier = ClassifierFacade.getInstanceClassifierFacade(resource.getPath());

		
		double voltage256 = 0.0256011;
		double voltage280 = 0.0386016;
		double voltage310 = 0.3329916;
		int devNo = 2;
		int simpleId = 7;

		LiqourDetectRequest detectRequest = new LiqourDetectRequest(simpleId, devNo,voltage256, voltage280, voltage310);

		LiqourDetectResponse detect = liqourClassifier.detect(detectRequest);
		Double matchingDegree = detect.getMatchingDegree();
	
		System.out.println(detect);
	}

}

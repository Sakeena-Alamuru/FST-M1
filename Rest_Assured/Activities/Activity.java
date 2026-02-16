package Activities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.core.model.annotations.PactFolder;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;

@SuppressWarnings("deprecation")
@Provider("UserProvider")
	@PactFolder("target/pacts")
	public class Activity {
	    @BeforeEach
	    public void setUp(PactVerificationContext context) {
	        HttpTestTarget target = new HttpTestTarget("localhost", 8585);
	        context.setTarget(target);
	    }

	    @TestTemplate
	    @ExtendWith(PactVerificationInvocationContextProvider.class)
	    public void providerTest(PactVerificationContext context) {
	        context.verifyInteraction();
	    }

	    @State("POST Request")
	    public void state1() {}
	}



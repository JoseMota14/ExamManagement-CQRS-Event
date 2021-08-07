package util;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UpdateConfigProperties implements JavaDelegate {
	private static Log log = LogFactory.getLog(getStudents.class);
	 
	public void execute(DelegateExecution execution) throws Exception {
		log.info("updating config properties...");
		int timeLimit = Integer.parseInt(String.valueOf(execution.getVariable("timeLimit")));
		
		execution.setVariable("timeLimit", timeLimit/4);
		execution.setVariable("retry", "false");
	}
}
package util;

import java.util.ArrayList;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class resetVariables implements JavaDelegate {	 
	public void execute(DelegateExecution execution) throws Exception {		
		execution.setVariable("countRejectionsRejections", 0);
		execution.setVariable("revisoresAceites", new ArrayList<String>());
	}
}

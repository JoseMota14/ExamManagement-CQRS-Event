package util;


import java.util.ArrayList;
import java.util.List;
 
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.impl.util.json.JSONArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class getStudents implements JavaDelegate{
	private static Log log = LogFactory.getLog(getStudents.class);
	 
	public void execute(DelegateExecution execution) throws Exception {
		log.info("looking for registered users...");
 
		List<String> registeredUsers= new ArrayList<String>();
		JSONArray arr = new JSONArray(String.valueOf(execution.getVariable("studentsVar")));
		for (int i = 0; i < arr.length(); i++) {
            String email = arr.getJSONObject(i).getString("email");
            registeredUsers.add(email);
        }
 
		execution.setVariable("registeredUsers", registeredUsers);
	}

}

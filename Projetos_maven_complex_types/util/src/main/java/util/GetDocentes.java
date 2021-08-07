package util;

import java.util.ArrayList;
import java.util.List;
 
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.impl.util.json.JSONArray;

public class GetDocentes implements JavaDelegate{
	 
	public void execute(DelegateExecution execution) throws Exception {
 
		List<String> registeredUsers= new ArrayList<String>();
		JSONArray allDocentes = new JSONArray(String.valueOf(execution.getVariable("docentesVar")));
		System.out.println(allDocentes.toString());
		Object selectedDocentes = execution.getVariable("docentesRevisorVar");
		List<String> auxiliarList = new ArrayList<String>();
        if(selectedDocentes instanceof String){
        	auxiliarList.add((String)selectedDocentes);
        }else{
        	auxiliarList = (ArrayList<String>)selectedDocentes;
        }
		System.out.println(auxiliarList.toString());
		for (int i = 0; i < auxiliarList.size(); i++) {
			for(int j=0; j<allDocentes.length();j++) {
				if(auxiliarList.get(i).equals(allDocentes.getJSONObject(j).getString("name"))) {
					String email = allDocentes.getJSONObject(i).getString("email");
					System.out.println(email + " added ");
	            	registeredUsers.add(email);
				}
			}
        }
		System.out.println("array devolvido: " + registeredUsers.toString());
		execution.setVariable("nameDocentes", auxiliarList);
		execution.setVariable("registeredDocentes", registeredUsers);
	}

}
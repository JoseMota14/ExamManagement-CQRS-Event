package util;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.TaskListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CountReviewersListener implements TaskListener {

	private static final String REVISOR = "docente";
	private static final String DOCENTES = "revisoresAceites";
	private static final String DECISION = "decisionFormalization";

	public Expression variableNameExpression;

	@SuppressWarnings("unchecked")
	public void notify(DelegateTask delegateTask) {
		List<String> revisor = new ArrayList<String>();
		if (delegateTask.hasVariable(DOCENTES)) {
			revisor = (List<String>) delegateTask.getVariable(DOCENTES);
		}

		if (delegateTask.getVariable(DECISION, String.class).equals("yes")) {
			revisor.add(delegateTask.getVariable(REVISOR, String.class));
		}
		delegateTask.setVariable(DOCENTES, revisor);
	}

}

package util;

import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.TaskListener;

public class CountFormalizationRejections implements TaskListener {

	private static final String COUNT = "countRejectionsRejections";
	private static final String DECISION = "decisionFormalization";
	private static final String REVISORESLIST = "revisoresAceites";
	private static final String ACCEPTEDFORMALIZATION = "finalDecision";

	public Expression variableNameExpression;

	@SuppressWarnings("unchecked")
	public void notify(DelegateTask delegateTask) {
		int countRejections = 0;
		if (delegateTask.hasVariable(COUNT)) {
			countRejections = delegateTask.getVariable(COUNT, Integer.class);
		}

		if (delegateTask.getVariable(DECISION, String.class).equals("reject")) {
			countRejections++;
		}
		delegateTask.setVariable(COUNT, countRejections);
		
		List<String> listaDeRevisores = (List<String>) delegateTask.getVariable(REVISORESLIST);
		int tamanho = listaDeRevisores.size();
		
		if(countRejections >= (double) tamanho / 2) {
			delegateTask.setVariable(ACCEPTEDFORMALIZATION, "false");
		}else {
			delegateTask.setVariable(ACCEPTEDFORMALIZATION, "true");
		}
	}

}
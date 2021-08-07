package properties;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Logger; 

public class ConfigApp implements JavaDelegate{     

      private static final Logger LOGGER = Logger.getLogger(ConfigApp.class.getName());
      HashMap<String, String> properties = new HashMap<String, String>();          

      @SuppressWarnings("rawtypes")
      public void execute(DelegateExecution execution) throws Exception {
           
            LOGGER.info("Config File Service Task");
            ConfigFile file = new ConfigFile();           

            this.properties = file.getProperties();                                                 

            Iterator entries = this.properties.entrySet().iterator();
            while (entries.hasNext()) {
                  HashMap.Entry entry = (HashMap.Entry) entries.next();
                String key = entry.getKey().toString();
                String value = entry.getValue().toString();                                  

                execution.setVariable(key, value);
            } 
       

      }
}

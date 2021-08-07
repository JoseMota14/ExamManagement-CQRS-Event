package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConfigFile {

	private static Log log = LogFactory.getLog(ConfigFile.class);

	HashMap<String, String> properties = new HashMap<String, String>();

	public ConfigFile() {
		this.readProperties();
	}

	public void readProperties() {

		Properties prop = new Properties();
		InputStream input = null;

		try {
			Path currentRelativePath = Paths.get("");
			String absolutePath = currentRelativePath.toAbsolutePath().toString();
			log.info("Current relative path is: " + absolutePath);

			input = new FileInputStream(absolutePath + "/conf/myconfig.properties");

			// load a properties file
			prop.load(input);

			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);
				properties.put(key, value);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public HashMap<String, String> getProperties() {
		return this.properties;
	}

}

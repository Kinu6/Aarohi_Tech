package aarohi.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
    /**
     * This method is for reading Property File
     * @return
     * @throws IOException
     */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fisp= new FileInputStream(ConstantsUtility.propertyFilePath);
		Properties pObj= new Properties();
		pObj.load(fisp);
		String value=pObj.getProperty(key);
		return value;
	}
}

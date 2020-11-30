package automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import automation.utils.models.User;

public class Helper {

	public static User converXmlToUser(String xml){
		JAXBContext jaxbContext;
		User user = null;
		try {
			jaxbContext = JAXBContext.newInstance(User.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			user = (User) jaxbUnmarshaller.unmarshal(new StringReader(xml));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		if(user == null)
			throw new IllegalArgumentException(String.format("%s \n Couldn't be converted to User type.", xml));
		
		return user;
	}
	
    public static String readProperty(String property) {
        try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            return prop.getProperty(property);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
		throw new IllegalArgumentException("Please specify correct property to get from config.property.");
    }

}

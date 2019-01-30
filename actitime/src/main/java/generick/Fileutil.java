package generick;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class Fileutil {
	
	String pathOfxmlfile="C:\\Users\\TYSS\\Desktop\\punit\\actitime\\src\\main\\resources\\resource\\data.xml";
    String pathOfPropertyFile="C:\\Users\\TYSS\\Desktop\\punit\\actitime\\src\\main\\resources\\resource\\applicationdata.properties";
    
    public Properties getPropertyFileData() throws Exception
    {
    	FileInputStream fil = new FileInputStream(pathOfPropertyFile);
    	Properties pobj = new Properties();
    	pobj.load(fil);
    	return pobj;
    }
    public String getXmlData(String node) throws FileNotFoundException, Throwable
    {
    	FileInputStream fil = new FileInputStream(pathOfxmlfile);
    	SAXReader sax = new SAXReader();
    	Document doc =sax.read(fil);
    	String data=doc.selectSingleNode(node).getText();
		return data;
    	
    }
}

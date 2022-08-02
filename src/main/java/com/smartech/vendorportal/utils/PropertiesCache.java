package com.smartech.vendorportal.utils;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Properties;
import org.springframework.context.annotation.Configuration;
import com.smartech.vendorportal.entities.Config;
import java.io.InputStream;
import java.util.Set;
 
@Configuration
public class PropertiesCache
{
   private final Properties configProp = new Properties();
    
   public PropertiesCache()
   {
      //Private constructor to restrict new instances
      InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
      System.out.println("Reading all properties from the file");
      try {
          configProp.load(in);
      } catch (IOException e) {
          e.printStackTrace();
      }
   }
 
   //Bill Pugh Solution for singleton pattern
   private static class LazyHolder
   {
      private static final PropertiesCache INSTANCE = new PropertiesCache();
   }
 
   public static PropertiesCache getInstance()
   {
      return LazyHolder.INSTANCE;
   }
    
   public String getProperty(String key){
      return configProp.getProperty(key);
   }
    
   public Set<String> getAllPropertyNames(){
      return configProp.stringPropertyNames();
   }
    
   public boolean containsKey(String key){
      return configProp.containsKey(key);
   }
   
   
   public void setProperty(String key, String value){
	   configProp.setProperty(key, value);
	 }
	  
	 public void flush() throws FileNotFoundException, IOException {
	   try (final OutputStream outputstream 
	         = new FileOutputStream("application.properties");) {
	     configProp.store(outputstream,"File Updated");
	     outputstream.close();
	   }
	 }
	 
	 public void writeToProperties(Config config) throws FileNotFoundException, IOException {
		 
		 PropertiesCache cache = PropertiesCache.getInstance();
		 if(cache.containsKey("VendorPortal.app.email") == true){
		  cache.setProperty("VendorPortal.app.email", config.getEmail());
		 }
		 if(cache.containsKey("VendorPortal.app.password") == true){
			  cache.setProperty("VendorPortal.app.password", config.getPassword());
			 }
		 if(cache.containsKey("VendorPortal.app.urlmaximo") == true){
			  cache.setProperty("VendorPortal.app.urlmaximo", config.getMaximopath());
			 }
		 if(cache.containsKey("logging.file.name") == true){
			  cache.setProperty("logging.file.name", config.getLogpath());
			 }
		 if(cache.containsKey("VendorPortal.app.header.value") == true){
				String originalInput =config.getUsermaximo()+":"+config.getPasswordmaximo();
				String header = Base64.getEncoder().encodeToString(originalInput.getBytes());
				System.out.println(header);
			  cache.setProperty("VendorPortal.app.header.value", header);
			 }
		  
		 //Verify property
		 System.out.println(cache.getProperty("VendorPortal.app.email")); 
		 System.out.println(cache.getProperty("VendorPortal.app.password"));
		 System.out.println(cache.getProperty("VendorPortal.app.urlmaximo"));
		 System.out.println(cache.getProperty("logging.file.name"));
		  
		 //Write to the file
		 PropertiesCache.getInstance().flush(); 
		 
	 }
	 
	 
}
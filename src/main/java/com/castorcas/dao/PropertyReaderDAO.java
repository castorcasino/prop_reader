package com.castorcas.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class PropertyReaderDAO {

    String result = "";
    InputStream inputStream;

    public PropertyReaderDAO(){

    }

    public String getPropValues() throws IOException {

        try{
            Properties properties = new Properties();
            String filename = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(filename);

            if(inputStream != null){
                properties.load(inputStream);
            }
            else{
                throw new FileNotFoundException("Property file '" + filename + "' not found.");
            }

            Date time = new Date(System.currentTimeMillis());

            // GEt the property value and print it out
            String user = properties.getProperty("user");
            String company1 = properties.getProperty("company1");
            String company2 = properties.getProperty("company2");
            String company3 = properties.getProperty("company3");

            result = "User:["+ user +"] " + " company1[" + company1 + "]" + " company2[" + company2 + "]" + " company3[" + company3 + "]";
            System.out.println(result);
            System.out.println("Program ran successfully on " + time);
        }

        catch(Exception e){
            System.out.println("Exception: " + e);
        }
        finally{
            inputStream.close();
        }
        return result;
    }

    public static void main(String[] args){

        PropertyReaderDAO propertyReaderDAO = new PropertyReaderDAO();

        try {
            propertyReaderDAO.getPropValues();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

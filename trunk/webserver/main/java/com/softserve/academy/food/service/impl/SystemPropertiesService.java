package com.softserve.academy.food.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Service;

//need to keep system settings like patches,global site variables
@Service
public class SystemPropertiesService
{
    private Properties prop = new Properties();
    public String cfgfile;

    public SystemPropertiesService()
    {
    }
//constructor get inject from beans, string parameter with path to the setting file
    //bean example:
//    <bean id="systemPropertiesService" class="com.softserve.academy.food.service.SystemPropertiesService"  >
//    <constructor-arg index="0" type="java.lang.String" value="D:\\EclipseJunoWorkDir\\onlinerestaurent\\WebContent\\system.properties" />
//    </bean>

    public SystemPropertiesService(String str) throws FileNotFoundException, IOException
    {
	cfgfile = str;
	File fl = new File(str);
	prop.load(new FileInputStream(fl));
    }

    public Properties getProperties()
    {
	return prop;
    }

}

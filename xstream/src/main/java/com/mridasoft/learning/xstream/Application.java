package com.mridasoft.learning.xstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;

import com.mridasoft.common.web.menu.MenuItem;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class Application {
	
	public static void main(String[] args) {
		
		XStream xstream = new XStream(new StaxDriver());
		
		//xstream.setMode(XStream.XPATH_RELATIVE_REFERENCES);
		
		xstream.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		xstream.setMode(XStream.ID_REFERENCES);
		
		xstream.alias("menu", MenuItem.class);

		MenuItem dashboard = new MenuItem.Builder().withId("dashboard").
								withUrl("dashboard/index").build();
		
		MenuItem admin = new MenuItem.Builder().withId("admin").
								withUrl("admin/index").build();
		
		
		MenuItem root = new MenuItem.Builder().withId("ROOT").withUrl("menu").
							withChildMenu(dashboard).withChildMenu(admin).build();
		
		List<MenuItem> allmenus = new ArrayList<>();
		
		allmenus.add(root);
		allmenus.add(dashboard);
		allmenus.add(admin);
		
		String xml = xstream.toXML(allmenus);	
		System.out.println(xml);
		
		String xmlPath = "D:\\skakani\\mywork\\java\\learning\\corejava\\xstream\\src\\main\\java\\com\\mridasoft\\learning\\xstream\\menu.xml";
		
		try {
			Object o = xstream.fromXML(new FileInputStream(new File(xmlPath)));
			System.out.println(o.getClass().getName());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

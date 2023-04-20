package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mridasoft.learning.serialization.MyBO2;

public class TestExternalization {
	
	public static void main(String[] args) {
		
		try{
		
			MyBO2  toPersist = new MyBO2();
			toPersist.setCreditCardNumber(123456);
			
			File serFile = new File("TestExternalization.o");
			
			ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream(serFile));
			oStream.writeObject(toPersist);
			oStream.close();
			
			System.out.println("Reading object from stream");
			
			ObjectInputStream iStream = new ObjectInputStream(new FileInputStream(serFile));
			MyBO2 deSerilized = (MyBO2) iStream.readObject();
			iStream.close();
			
			System.out.println(deSerilized);
			System.out.println("Are ser/deser object ref equal="+(toPersist==deSerilized));
			System.out.println("Are ser/deser object equal="+toPersist.equals(deSerilized));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

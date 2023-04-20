package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mridasoft.learning.serialization.MyBusinessObject;

public class TestBasicSerialization {
	
	public static void main(String[] args) {
		
		try {
			
			MyBusinessObject toPersist =  new MyBusinessObject();
			
			toPersist.setFirstName("Sreedhara");
			toPersist.setLastName("kakani");
			toPersist.setAge(33);
			toPersist.setWealth(1.5);
			
			File serFile = new File("TestBasicSerialization.o");
			
			ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream(serFile));
			oStream.writeObject(toPersist);
			oStream.close();
			
			//293  bytes
			//code = MyBusinessObject = 16*2 = 32
			//vers = 4
			//fn = Sreedhara = 9*2 = 18 
			//ln = kakani = 6*2 = 12
			//age = 4 
			//wealth = 8
			//total data = 32+4+18+12+4+8
			//meta data is it 59*2 + 4*2+ 7*2 + 53*2 +  + 9*2 + 8*2 + 3*2 + 6*2
			//seems metadata is intelligent enough not to write everything about class, 
			//but payload is way more than data  
			
			System.out.println("Reading object from stream");
			
			ObjectInputStream iStream = new ObjectInputStream(new FileInputStream(serFile));
			MyBusinessObject deSerilized = (MyBusinessObject) iStream.readObject();
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

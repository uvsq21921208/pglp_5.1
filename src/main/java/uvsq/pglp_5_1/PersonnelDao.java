package uvsq.pglp_5_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersonnelDao extends DAO<Personnel>{

	@Override
	public Personnel create(Personnel obj) {
	      try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(obj.getNom()))) {
	            out.writeObject(obj);
	        }
	        catch(IOException ioe){
	        }
	        return obj;
	}

	@Override
	public Personnel find(String id) {
		Personnel personnel = null;
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(id))) {
            personnel = (Personnel) in.readObject();
        }
        catch(ClassNotFoundException  ioe){
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return personnel;
	}

	@Override
	public Personnel update(Personnel obj) {
		 String file = obj.getNom();
	     try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file, false))) {
	            out.writeObject(obj);
	       }
	        catch(IOException ioe){
	      }
	        return obj;
	}

	@Override
	public void delete(Personnel obj) {
		
	     File file = new File(obj.getNom());
	     file.delete();
	      
	}

}

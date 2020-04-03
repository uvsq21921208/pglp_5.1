package uvsq.pglp_5_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AnnuaireDao extends Dao<Annuaire> {


	@Override
	public Annuaire create(Annuaire obj) {
	      try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Annuaire"))) {
	            out.writeObject(obj);
	        }
	        catch(IOException ioe){
	        }
	        return obj;
	}

	@Override
	public Annuaire find(String id) {
		Annuaire annuaire = null;
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(id))) {
            annuaire = (Annuaire) in.readObject();
        }
        catch(ClassNotFoundException  ioe){
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return annuaire;
	}

	@Override
	public Annuaire update(Annuaire obj) {
		 String file = "Annuaire";
	     try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file, false))) {
	            out.writeObject(obj);
	       }
	        catch(IOException ioe){
	      }
	        return obj;
	}

	@Override
	public void delete(Annuaire obj) {
		
	     File file = new File("Annuaire");
	     file.delete();
	      
	}

}

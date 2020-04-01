package uvsq.pglp_5_1;

public class DaoFactory {

	
	

	   

	    public static DAO<Personnel> getPersonnelDao(){

	        return new PersonnelDao();
	    }
	
}

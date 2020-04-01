package uvsq.pglp_5_1;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class PersonnelDaoTest {
	
	
	DAO<Personnel> dao;
	@Test
	public void createTest(){
		File tmpDir = new File("Djekhaba");
		tmpDir.delete();
		dao = DaoFactory.getPersonnelDao();
		Personnel p1 = new Personnel.PersonelBuilder("Djekhaba", "Mouttie", "CS").build();
		assertFalse(tmpDir.exists());
		dao.create(p1);
		assertTrue(tmpDir.exists());
		
		
	}
    
	@Test
	public void updateTest(){
		dao = DaoFactory.getPersonnelDao();
		createTest();
		File tmpDir = new File("Djekhaba");
		Personnel p1 = dao.find("Djekhaba");
		assertEquals(p1.getFonction(),"CS");
		p1 = new Personnel.PersonelBuilder("Djekhaba", "Mouttie", "Design").build();
		dao.update(p1);
		p1 = dao.find("Djekhaba");
		assertEquals(p1.getFonction(),"Design");
		
		
		
	}
    
	@Test
	public void deleteTest(){
		File tmpDir = new File("Djekhaba");
		dao = DaoFactory.getPersonnelDao();
		Personnel p1 = new Personnel.PersonelBuilder("Djekhaba", "Mouttie", "CS").build();
		dao.create(p1);
		assertTrue(tmpDir.exists());
		dao.delete(p1);
		assertFalse(tmpDir.exists());
	}
	@Test
	public void findTest(){
		
		createTest();
		Personnel p1 = dao.find("Djekhaba");
		assertEquals(p1.getNom(), "Djekhaba");
	}
    
    
	
}

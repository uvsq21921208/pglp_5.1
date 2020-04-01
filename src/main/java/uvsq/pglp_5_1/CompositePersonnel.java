package uvsq.pglp_5_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * CompositePersonnel class.
 */
public class CompositePersonnel  extends TypePersonnel implements
       Iterable<TypePersonnel>, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Groupe de personnel.
     */
    private List<TypePersonnel> personnels;
    /**
    * id.
    */
    private int id;
   /**
       *
       * @param personnel personnel to be added.
       */
       public void add(final TypePersonnel personnel) {
              this.personnels.add(personnel);
          }
          /**
          *
          * @param idGroupe id du groupe.
          */
       public CompositePersonnel(final int idGroupe) {
              this.personnels = new ArrayList<TypePersonnel>();
              this.id = idGroupe;
       }
       /**
       *
       * @param personnel personnel to be removed.
       */
       public void remove(final TypePersonnel personnel) {
              this.personnels.remove(personnel);
       }
       /**
       * return all personnel.
       * @return les les personnel.
       */
    public List<TypePersonnel> getAllPersonnel() {
           return this.personnels;
    }
       /**
       *  @return groupe.
       */
       @Override
       public boolean isGroupe() {

              return true;
     }

       /**
       *  @return iterator.
       */
       public Iterator<TypePersonnel> iterator() {

              return personnels.listIterator();
       }
       /**
       *  @return groupe iteration.
       */
       public GroupeIteration groupeIteration() {
              return new GroupeIteration(this);
       }
       /**
       *  @return groupe.
       */
       public HierachicalIteration hierachical() {
              return new HierachicalIteration(this);
       }
       /**
       *  @return string representation of the object.
       */
       public String getID() {
              String str = "id " + this.id;
              return str;
       }
}

package uvsq.pglp_5_1;


import java.util.ArrayDeque;

/**
*
* groupe iteration class.
*
*/
public class GroupeIteration extends TypePersonnelIterator {
      /**
       *  @param compositePersonnel param.
       */
       public GroupeIteration(final CompositePersonnel compositePersonnel) {
              super(compositePersonnel, new ArrayDeque<TypePersonnel>());

       }
        /**
       *  @return les personnel.
       */
       @Override
       protected TypePersonnel getCollectionItems() {
         return ((ArrayDeque<TypePersonnel>) getPersonnelCollection()).remove();
       }

}

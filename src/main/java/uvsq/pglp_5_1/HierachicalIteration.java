package uvsq.pglp_5_1;



import java.util.Stack;
/**
*
* Hierachical iteration class.
*
*/
public class HierachicalIteration extends TypePersonnelIterator {
      /**
       *  @param compositePersonnel param.
       */
       public HierachicalIteration(
       final CompositePersonnel compositePersonnel) {
              super(compositePersonnel, new Stack<TypePersonnel>());

       }
        /**
       *  @return les personnel.
       */
       @Override
       protected TypePersonnel getCollectionItems() {
              // TODO Auto-generated method stub
              return ((Stack<TypePersonnel>) getPersonnelCollection()).pop();
       }

}

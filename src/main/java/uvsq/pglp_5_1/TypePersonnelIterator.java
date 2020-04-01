package uvsq.pglp_5_1;


import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author Mouttie
 * Type personnel iterator.
 */
public abstract class TypePersonnelIterator implements Iterator<TypePersonnel> {
    /**
    * collection des personnels.
    */
      private Collection<TypePersonnel> personnelCollection;
      /**
       * @return has next ou pas.
       */
      public boolean hasNext() {
            return !getPersonnelCollection().isEmpty();
      }
      /**
       * root.
       */
      private CompositePersonnel root;
      /**
       *
       * @param compositePersonnel composite personnel.
       * @param collection collection.
       */
      public TypePersonnelIterator(final CompositePersonnel compositePersonnel,
                   final Collection<TypePersonnel> collection) {
          this.root = compositePersonnel;
          this.setPersonnelCollection(collection);
          this.getPersonnelCollection().addAll(root.getAllPersonnel());
      }
      /**
      *
      * @param collection collection.
      */
      private void setPersonnelCollection(final Collection<TypePersonnel>
           collection) {
           this.personnelCollection = collection;
      }
      /**
      * @return next element.
      */
      public TypePersonnel next() {
            if (!hasNext()) {
                  throw new NoSuchElementException();
            }
    TypePersonnel typePersonnel = getCollectionItems();
    if (typePersonnel.isGroupe()) {
       getPersonnelCollection().addAll(((CompositePersonnel) typePersonnel).
                 getAllPersonnel());
    }
    return typePersonnel;
      }
    /**
     *
     * @return collection.
     */
    protected abstract TypePersonnel getCollectionItems();
    /**
    * @return root.
    */
    public TypePersonnel getRoot() {
          return this.root;
    }
      /**
       *
       * @return personnel collection.
       */
      public Collection<TypePersonnel> getPersonnelCollection() {
          return personnelCollection;
     }
}


public class JML {
  /**
   * Integerdevision, bei der aufgerundet wird.
   * @param value: Integerwert
   * @return Halbierung aufgewertet.
   */
  //@ ensures \result == value/2 + value%2;
  /*@pure*/public static int halfup(int value){
    return value/2 + value%2;
  }
}

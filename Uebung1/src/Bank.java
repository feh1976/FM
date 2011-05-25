import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Ein Objekt der Klasse Bank repräsentiert ein Bankinstitut.
 */
public class Bank extends AccountHolder {
  //@ public invariant 0 <= openCredits && openCredits <= max_credits;
  //@ public invariant 0 <= max_credits;
  
  /** Log-Datei */
  /*@non_null*/BufferedWriter log;
  /** Anzahl maximal vergebener Kredite */
  public int max_credits;
  /** Anzahl offener Kredite */
  public int openCredits;
  
  //@ requires limit <= 0;
  //@ requires max_credits >= 0;
  //@ ensures this.limit == limit;
  //@ ensures total == 0;
  //@ ensures openCredits == 0;
  //@ ensures this.log == log;
  public Bank(int limit, int max_credits, /*@non_null*/BufferedWriter log) {
    super(limit);
    this.max_credits = max_credits;
    openCredits = 0;
    this.log = log;
  }
  
  /**
   * Schreibt eine Nachricht in eine Datei.
   * @param msg: Nachricht
   */
  public void log(/*@non_null*/String msg){
    try {
      log.write(msg);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

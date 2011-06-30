-- -----------------
-- Aufgabe 2
-- Implementation des Banksystems
-- -----------------
-- Wirtschaft
sig Economy{
  bank: Bank, -- Model gilt für eine Bank
  person: set Person, -- Menge der Kunden
  konto: set Konto -- Menge aller Konten
}

-- Namen der Kunden
sig Name{}

-- Alle Kontobesitzer (inklusive der Bank)
abstract sig AccountHolder {
  limit : Int, -- Kontolimit, bis zu welchem Betrag der Kontostand sinken kann
  total : Int -- Summe aller Kontobeträge
}{
  all a:AccountHolder |  a.total >= a.limit
}

-- Menschliche Kontobesitzer
sig Person extends AccountHolder {
  name : Name, -- Name der Person
  partner : Person, -- Ehepartner der Person
  male : Int, -- Geschlecht der Person
  bank : Bank, -- Bankinstitut, bei dem die Person registriert ist
  bonitaet : Int -- Bonität
}{
  all p:Person | p.partner != p
  all p:Person | p.name != none
  all p:Person | p.male = 0 || p.male = 1 
  all p:Person | p.partner != none => p.male != p.partner.male
  all p:Person | p.partner != none => p = p.partner.partner  
  all p:Person | p.bank != none
}

-- Verheiratet Person p mit Person p'
fun marry[p:Person, p':Person, e:Economy] : one Economy {
  {q:Person | p.male != p'.male && p.partner = none && p'.partner = none 
  => q = p && q.partner = p'}
  +{q':Person | p.male != p'.male && p.partner = none && p'.partner = none 
  =>  q' = p' && q'.partner = p}
}

-- Scheidet Person p und Person p'
fun divorce[p:Person, p':Person, e:Economy] : one Economy {
  {q:Person | all g:GemeinschaftsKonto | g.owner != p && g.owner2 != p && 
   p.partner = p'.partner => q = p && q.partner = none}
  +{q':Person | all g:GemeinschaftsKonto | g.owner != p' && g.owner2 != p' &&  
  p.partner = p'.partner =>  q' = p' && q'.partner = none}
}

-- Die Bank als Kontobesitzer
sig Bank extends AccountHolder {
  maxCredits : Int, -- Maximale Anzahl gleichzeitig offener Kredite
  openCredits : Int -- Anzahl der momentan offenen Kredite
}{
  all b:Bank | 0 <= b.openCredits <= b.maxCredits 
  all b:Bank | 0 <= b.maxCredits 
}

-- Ein Konto
abstract sig Konto {
  balance : Int
}

-- Ein Konto, welches speziell einer Bank gehört
sig BankKonto extends Konto {
  owner : Bank
}{
  all b:BankKonto | b.owner != none
}

-- Gewährt einem Kunden einen Kredit
fun grantCredit[a:Int, p:PrivatKonto, e:Economy] : Economy {
{
	e' : Economy
}
}
-- Ein Konto, welches mindestens einer Person gehören muss
abstract sig PersonenKonto extends Konto{
  owner : Person -- Ein Kontoinhaber
}{
  all p:PersonenKonto | p.owner != none
}

-- Ein Gemeinschaftskonto, dass von 2 Personen besessen werden muss
sig GemeinschaftsKonto extends PersonenKonto {
  owner2 : Person -- zweiter Kontoinhaber
}{
  all g:GemeinschaftsKonto | g.owner2 != none
  all g:GemeinschaftsKonto | g.owner2 != g.owner
}

-- Ein Privatkonto
sig PrivatKonto extends PersonenKonto {}

run {}

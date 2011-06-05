-- -----------------
-- Aufgabe 2
-- Implementation des Banksystems
-- -----------------
sig Economic{
  bank: Bank,
  person: set Person,
  konto: set Konto
}

sig Name{}

abstract sig AccountHolder {
  limit : Int,
  total : Int
}{
  all a:AccountHolder |  a.total >= a.limit
}


sig Person extends AccountHolder {
  name : Name,
  partner : Person,
  male : Int,
  bank : Bank,
  bonitaet : Int
}{
  all p:Person | p.partner != p
  all p:Person | p.name != none
  all p:Person | p.male = 0 || p.male = 1 
  all p:Person | p.partner != none => p.male != p.partner.male
  all p:Person | p.partner != none => p = p.partner.partner  
  all p:Person | p.bank != none
}

fun marry[p:Person, p':Person]: set Person {
  {one q:Person | p.male != p'.male && p.partner = none && p'.partner = none 
  => q = p && q.partner = p'}
  +{one q':Person | p.male != p'.male && p.partner = none && p'.partner = none 
  =>  q' = p' && q'.partner = p}
}

fun divorce[p:Person, p':Person]: set Person {
  {one q:Person | all g:GemeinschaftsKonto | g.owner != p && g.owner2 != p && 
   p.partner = p'.partner => q = p && q.partner = none}
  +{one q':Person | all g:GemeinschaftsKonto | g.owner != p' && g.owner2 != p' &&  
  p.partner = p'.partner =>  q' = p' && q'.partner = none}
}


sig Bank extends AccountHolder {
  maxCredits : Int,
  openCredits : Int
}{
  all b:Bank | 0 <= b.openCredits <= b.maxCredits 
  all b:Bank | 0 <= b.maxCredits 
}

abstract sig Konto {
  balance : Int
}

sig BankKonto extends Konto{
  owner : Bank
}{
  all b:BankKonto | b.owner != none
}

fun grantCredit[a:Int, p:PrivatKonto, e:Economic]: Economic{
{e':Economic
}

abstract sig PersonenKonto extends Konto{
  owner : Person
}{
  all p:PersonenKonto | p.owner != none
}

sig GemeinschaftsKonto extends PersonenKonto {
  owner2 : Person
}{
  all g:GemeinschaftsKonto | g.owner2 != none
  all g:GemeinschaftsKonto | g.owner2 != g.owner
}

sig PrivatKonto extends PersonenKonto {}

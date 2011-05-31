-- -----------------
-- Aufgabe 1
-- Implementation einer Liste
-- -----------------
-- Marker für das Listenende
one sig NIL {}

-- Wert eines Knotens
sig Object{}

-- Knoten einer Liste
sig Node{
  value: Object,
  next: Node+NIL
}

sig List{
  first: Node,
  last: Node
}

-- Keine Kreise
fact {all n:Node | n not in n.^next}
-- Keine Listenzusammenführung
fact {all n:Node | all n':Node | n != n' => n.next != n'.next}


-- -----------------
-- Aufgabe 2
-- Implementation des Banksystems
-- -----------------
--sig Name{}

--sig Person {
--  name : Name,
--  partner : Person,
--  limit : Int,
--  total : Int
--}{
--  all x:total | all y:limit | x < y
--}


--sig Bank{
--  max_credits : Int,
--  openCredits : Int,
--  limit : Int,
--  total : Int
--}{
--  all x:total | all y:limit | x < y
--  all x:openCredits | all y:max_credits | x < y
--}

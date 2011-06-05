-- -----------------
-- Aufgabe 1
-- Implementation einer Liste
-- -----------------

module List

sig List { 
  anchor: lone Node } 

sig Node { 
  next: lone Node,
  value: one Int} 

-- Keine Kreise
fact {all n:Node | n not in n.^next}

-- Keine Listenzusammenführung
fact {all n:Node | all n':Node | n != n' => n.next != n'.next}

-- Jeder Knoten ist in genau einer Liste
fact{all n:Node | one l:List | n in l.anchor.*next} 

check {all n:Node | all n':Node | n != n' => n.next != n'.next}

fun sizeOfList [l:List]: Int{
  #l.anchor.^next
}

fun headOfList [l:List]: Node{
  l.anchor
}

fun tailOfList [l:List]: List{
  {l':List | l.anchor != none => l'.anchor = l.anchor.next && 
   l.anchor = none => l'.anchor = none}
}

fun contain[l:List, i:Int]: set Node{
  {n:Node | n.value = i && n in l.anchor + l.anchor.^next}
}

fun contain[l:List, n:Node]: set Node{
  {n':Node | n' = n && n' in l.anchor + l.anchor.^next}
}

fun max[l:List]: Node{
  {n':Node | all n:Node | n' in contain[l,n'] && n in contain[l,n] => n'.value >= n.value}
}

fun removeFromList[l:List, i:Int]: List{
{l':List | lone n:Node | n.next.value = i && n in contain[l,n] => n.next = n.next.next}
}

fun addToList [l:List, i:Int]: List{
  {l':List | one n:Node | l'.anchor = n && n.value = i && n.next = l.anchor}
}

fun sortList[l:List]: List{
{addToList[sortList[removeFromList[l,max[l].value]],max[l].value]}
}


-- -----------------
-- Aufgabe 1
-- Implementation einer Liste
-- -----------------

module List
open util/boolean as Bool

-- Einfachverkette Liste
-- Jede Liste einhält einen Wert und verweist auf eine neue Liste
-- Neue Elemente werde am Anfang eingefügt
sig List { 
  next: lone List,
  value: one Int
}

-- Keine Kreise
fact {all l:List | l not in l.^next}
-- Keine unendlichen Listen
fact {all l:List | one t:allSublists[l] | t.next = none}

-- Größe einer Liste ermitteln
fun size [l:List] : Int {
  1.plus[#l.^next]
}

-- Liefert den Wert des ersten Elementes
fun head [l:List] : one Int {
  l.value
}

-- Liefert die Liste nach dem 1. Listenelement
fun tail [l:List] : lone List {
  l.next
}

-- Liefert alle Teillisten der Liste
fun allSublists [l:List] : set List {
  l + l.^next
}

-- Liefert das letzte Element der Liste
fun last [l:List]: one List {
  {l':allSublists[l] | l'.next = none}
}

-- Liefert die Menge aller Werte aus der Liste
fun allElem [l:List] : set Int {
  l.*next.value
}

-- Liefert die Liste, wo der erste Wert der gesucht ist
fun contain[l:List, i:Int] : Bool {
  {b:Bool | l.value = i => b = True && l.value != i && l.^next.value = i =>b = True && (l.value != i && l.^next.value != i) => b = False}
}

-- Größten Wert der Liste ermitteln
fun max[l:List] : Int {
  {i:Int | all j:allElem[l] | i in allElem[l] && i >= j}
}

-- Ein einzelnes Element an die Liste anhängen
fun add [l:List, i:Int] : List {
  {l':List | l'.value = i && l'.next = l}
}

-- Hänge Liste l' an Liste l an
fun add[l:List, l':List] : List {
  --{r:List | all l'':(l' - last[l']) | one b:list l'' in r && l in allSublists[r] } -- TODO: l' vor l setzen
}

--fun removeFromList[l:List, i:Int]: List {
--  {l':List | i not in allElem[l] => l' = l && (i in allElem[l] => (l'.))}
-- l.value = i => l' = l.next || l'.next.value = i => l'.next.value = i && n in contain[l,n] => n.next = n.next.next}
--}

--fun sortList[l:List]: List{
--{addToList[sortList[removeFromList[l,max[l].value]],max[l].value]}
--}

-- Verhindert, dass das Universum leer ist
fact{some List}
--fact{one r:List | some l:List, l':List | r = add [l,l']}

-- Unendliches Universum = verboten
--check {all l:List | all i:Int| sizeOfList[addToList[l,i]] = 1.plus[sizeOfList[l]]}

run {}

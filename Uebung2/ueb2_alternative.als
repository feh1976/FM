-- -----------------
-- Aufgabe 1
-- Implementation einer Liste
-- -----------------

module List
open util/boolean as Bool

-- Einfachverkette Liste
-- Jede Liste einhält einen Wert und verweist auf eine neue Liste
-- Neue Elemente werde am Anfang eingefügt
-- [A] -> [B] -> [C] -> ... -> [N] ->
--  |         |          |                   |
--  v        v          v                  v
-- [a]      [b]       [c]                [n]
sig List { 
  next: lone List, -- Verweis auf ein nachfolgendes Listenelement
  value: one Int, -- Wert des Knotens
  add: Int -> lone List, -- Fügt einen Wert ans Listenende
  app: List -> lone List, -- Hängt eine Liste an die andere an
  remove: List -> lone List, -- Löscht Werte aus der Liste
  sort: lone List
}

-- add: Ein einzelnes Element an die Liste anhängen
-- Gehe die Liste bis zum Ende durch und hänge eine neue Liste mit Wert i an, die auf none zeigt
fact { -- add
  all l,r:List | all i:Int | r = add[l,i] => 
	(head[r] = head[l]) && 
	(tail[l] = none => head[tail[r]] = i && tail[tail[r]] = none) && 
	(tail[l] != none => add[tail[l],i] != none && tail[r] = add[tail[l],i])
}

-- app: Hängt eine Liste an die andere an
-- Die gemergte Liste fängt mit einer Liste an. Wenn diese Liste abgearbeitet ist, wird die andere angehangen.
fact { -- app
  all l,l',r:List | r = app[l,l'] => 
	head[r] = head[l] && 
	(tail[l] != none => app[tail[l],l'] != none && tail[r] = app[tail[l],l']) && 
	(tail[l]= none => tail[r] = l')
}

-- remove: Löscht ein Listenelement
-- Die Ausgangsliste wird übernommen. Wenn die zu löschende Liste enthalten ist, wird das eine Element übersprungen.
-- Löscht man eine Liste, die nicht enhalten ist, bleibt die Ursprungsliste erhalten.
fact { -- remove
  all l,l',r:List | r = remove[l,l'] => 
	(l = l' => r = l.next) && 
	(l != l' => (l.next = none => r = l) && 
	(l.next != none => r.value = l.value && r.next = remove[l.next,l'])
  )
}


-- Beim Sortieren bleibt die Länge der Liste gleich
fact { all l:List | sort[l] != none => size[l] = size[sort[l]] }
-- Elemente der Liste bleiben beim Sortieren gleich
fact { all l:List | sort[l] != none => allElem[l] = allElem[sort[l]] }
-- Elemente der Liste sind nach dem Sortieren aufsteigend
fact { all l:List | sort[l] != none => sort[l].value <= sort[l].^next.value }

-- sort: Sortiert die Liste
fact {
  all l,r:List | r = sort[l] => 
	(size[l] = 1 => r = l) && 
    lone l':List | 
	(l' in allSublists[l] && l'.value = min[l] => 
		(size[l] != 1 && remove[l,l'] != none && sort[remove[l,l']] != none => r.value = l'.value && r.next = sort[remove[l,l']]) && 
		(size[l] != 1 && (remove[l,l'] = none || sort[remove[l,l']] = none) => r = none)
	)
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

-- Kleinsten Wert der Liste ermitteln
fun min[l:List] : Int {
  {i:Int | all j:allElem[l] | i in allElem[l] && i <= j}
}

-- Größten Wert der Liste ermitteln
fun max[l:List] : Int {
  {i:Int | all j:allElem[l] | i in allElem[l] && i >= j}
}

-- Verhindert, dass das Universum leer ist
fact{some List}

run {} for 5 List

<h2> Comparator vs Comparable</h2>

- Object Comparison: Comparable Interface
- Natural Ordering for objects
- Implemented by class
- class can be modified to include comparison

<h3> Comparable</h3>

```
public class Player implements Comparable<Player> {
    @Override
    compareTo(Player player) {
        Integer.compare()    
    }
}
```

<h2> Comparator </h2>

```
Comparator<Player> age = Comparator.comparing(Player::getAge)
public class PlayerRankingComparator implements Comparator<Player>
@Override
public int compare(Player player1,Player player2) {
    return Integer.compare(player1.get, player2.get);
}
```

Inaction Comparator

PlayerRankingComparator

- `Collections.sort(team,playerComparator)`

Java 8:

- Lambda: `Comparator = (p1,p2) ->Integer.compare(p1.get,p2.get)`
- Factory: `Comparator.comparing(Player::getRanking)`

<h3> When to use</h3>

- Comparable: natural ordering and modify class
- Comparator: multiplke sorting and class cannot modify
- Benefits: 
  - Multiple sort strategies
  - Separation of Concern(Loose coupling because don't need class)
  - Runtime sorting(Depends on user input)




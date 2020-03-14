# Clean Strike Game
A new game in carrom-board called Clean Strike is played by 2 players with multiple turns. A
turn has a player attempting to strike a coin with the striker. Players alternate in taking turns.
The game is described as follows:
* There are 9 black coins, a red coin and a striker on the carrom-board.
* Strike - When a player pockets a coin he/she wins a point.
* Multi-strike - When a player pockets more than one coin he/she wins 2 points. All, but 2
coins, that were pocketed, get back on to the carrom-board.
* Red strike - When a player pockets red coin he/she wins 3 points. If other coins are
pocketed along with red coin in the same turn, other coins get back on to the
carrom-board.
* Striker strike - When a player pockets the striker he/she loses a point.
* Defunct coin - When a coin is thrown out of the carrom-board, due to a strike, the player
loses 2 points, and the coin goes out of play.
* When a player does not pocket a coin for 3 successive turns he/she loses a point.
* When a player fouls 3 times (a foul is a turn where a player loses, at least, 1 point),
he/she loses an additional point.
* A game is won by the first player to have won at least 5 points, in total, and, at least, 3
points more than the opponent.
* When the coins are exhausted on the board, if the highest scorer is not leading by, at
least, 3 points or does not have a minimum of 5 points, the game is considered a draw.

**Input Format:**
The input should be a file with one or more lines of space separated integers. Each line represents a test case (game).
Each integer in a line represents a turn. Turns alternate between Player A and Player B. Player A starts the game.

**Sample Input:**
```
3 1 5 2 3 4 1
```

**Sample Output:**
```
--------------------------
---------NEW GAME---------
--------------------------
Welcome to the Clean Strike game.
Choices of a player: 
1. Strike
2. Multi-Strike
3. Red Strike
4. Striker Strike
5. Defunct Coin
6. None

Choice of Player A: 3
Score (A - B): 3 - 0

Choice of Player B: 1
Score (A - B): 3 - 1

Choice of Player A: 5
Score (A - B): 1 - 1

Choice of Player B: 2
Score (A - B): 1 - 3

Choice of Player A: 3
Score (A - B): 4 - 3

Choice of Player B: 4
Score (A - B): 4 - 2

Choice of Player A: 1
Player A has won the game!
Final Score (A - B): 5 - 2
```

## Technology Stack
* JDK 1.8
* JUnit Jupiter 5.4.2
* Mockito 1.9.5
* Maven 3.6.1 (Plugins used: maven-compiler-plugin, maven-assembly-plugin, maven-surefire-plugin)
* Lombok 1.18.10

## Setting Up
* Make sure JDK and Maven are installed and configured properly. After installing JDK and Maven, run:
```
mvn –version
```
Make sure "Java home" refers to a JDK and not JRE. Refer [this](http://roufid.com/no-compiler-is-provided-in-this-environment/) guide for troubleshooting.
* Clone/download this repository.
```
git clone https://github.com/Bharat-Makhija/CleanStrike.git
```

## Running included Unit Tests
To execute unit tests, run:
```
mvn clean test
```

## Compilation and Execution
To run the program with a custom input file following the specified input format, run the following
commands:
```
mvn clean install 
java -jar <path_to_cloned_repository>/target/cleanstrike.jar <absolute_path_to_input_file>
```
A sample input file has been included for demonstration purposes.

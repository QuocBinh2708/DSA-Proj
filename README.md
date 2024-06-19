# Minesweeper
<h3 align="center">DSA PROJECT</h3>
<h4 align="center">Game: MINESWEEPER</h4>

### Team Members

| Order |        Name        |     ID      |                          Task                           | Contribution |
|:-----:|:------------------:|:-----------:|:-------------------------------------------------------:|:------------:|
|   1   |  Lê Kỳ Quốc Bình   | ITITIU20169 | GitHub manager, Code contributor, Leader, Idea planning |     20%      |
|   2   |   Lý Quang Thắng   | ITITIU20304 |      Resource manager, GUI, Demo, Code contributor      |     20%      |
|   3   |   Bùi Quang Khải   | ITDSIU20095 |           UI/UX contributor, Designer, Artist           |     20%      |
|   4   |   Vĩnh Bảo Phúc    | ITITIU20127 |                Report, Code contributor                 |     20%      |
|   5   | Phan Đình Hữu Phúc | ITDSIU20077 |                    Code contributor                     |     20%      |
|   3   |   Bùi Quang Khải   | ITDSIU20095 |  UI/UX contributor, Designer, Artist, Code contributor  |     20%      |
|   4   |   Vĩnh Bảo Phúc    | ITITIU20077 |                Report, Code contributor                 |     20%      |
|   5   | Phan Đình Hữu Phúc | ITITIU20127 |                    Code contributor                     |     20%      |

[//]: # (>>>>>>> 8333ba75931d407698e634ba254617263efbf8fe)


<!-- ABOUT THE PROJECT -->     
# Minesweeper 

One of the infamous childhood game: Minesweeper!
This version is similar to traditional Minesweeper, but remade with extend features


- The user can only undo moves after committed any moves, which is true even when the previous 
saved game status is reloaded, i.e, the user cannot undo moves made in that previous round 
For example, if the game is reloaded with 2 flagged cells from the previous round, the user cannot undo those 2 but can undo the 3rd flagged cell. 

- The game status is automatically saved when the user exits out the window, and is given the option of 
whether they want to restore previous status or start a new game when the game is reopened.

<!-- FEATURES -->
## Features

- Completed:
+ Ben 10
+ Adding user's name
+ "Save" game status
+ Undo any number of moves, stop, restart
- Incompleted:
+ Adjustable grid size for different levels like Beginner 9x9 and Advanced 16x30,...

## Technologies

- Language: [JAVA](https://www.java.com/en/)
- Framework: [IntelliJ](https://www.jetbrains.com/idea/) and [Visual Studio Code](https://code.visualstudio.com)
- Library: [JavaSwing](https://en.wikipedia.org/wiki/Swing_(Java)), [JavaAWS](https://en.wikipedia.org/wiki/Abstract_Window_Toolkit) and [JLayer](https://github.com/umjammer/jlayer)

## Rules: 
<div style="text-align:justify">
Goal: sweep all 40 bombs from a 16x16 mine field

Left click to uncover the cells, a cell with a number reveals the number of neighboring cells that contain bombs
If an empty cell and its neighbors are also empty they both will be revealed (the entire region of all empty cells) until a cell with a number appears. Use this information plus guess work to avoid the bombs. 

To mark a cell you think is a bomb, right-click on the cell and a flag will appear. You have 40 flags in total, one for each bomb. You will be notified when you have used up all your 40 flags with a count of how many flags you have left in the lower left corner. The user can “un-flag” a cell by right clicking the cell again. 

The game is won when the user has successfully identified all the cells that contain bombs and the game is lost when the player clicks on a cell which contains a bomb. 

The user can undo any number of moves for any type of move, which includes clicking on flagged cells, empty cells, and neighbor cells. 

To start a new game, the user just clicks anywhere on the board. The user can stop the game at any point by exiting the game. The game will automatically be saved. When re-loaded, the user will have the option of starting a new game or starting from the most recent version of the game when exited.

<!-- CHALLENGES -->
## Challenges

- Don't know how to start the project
- Undo feature
- Resource 
- Extract image content
- Project managing
- Working environment
  <br />

## Experience
<div style="text-align:justify">
When we started making this game, we did not how to begin from. During the project, there was a big problem because we did not know how to create undo feature without eror. Thanks to useful resources online, we finally finished this project
</div>

## UML
https://tinyurl.com/ymfw8j5x

## References

1. https://github.com/QuocBinh2708/DSA-Proj
2. https://zetcode.com/javagames/minesweeper/
3. https://www.youtube.com/playlist?list=PLlD_ilI9JDbBVYP5uQUII81Q3w_pxAKhB
4. https://www.youtube.com/playlist?list=PLGxHvpw-PAk6QvPw0fYe8bks31GRKvymK

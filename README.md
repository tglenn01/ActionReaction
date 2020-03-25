# My Personal Project
**Action Reaction**
## A subtitle
**Reaction Time Dual Adventure**

A *bulleted* list:
- My application is a reaction based adventure game where you fight in duals against computer opponents while enjoying
a heart pulling story.
- This application is for people who are looking to feel the **thrill** of being rewarded for their **intense** focus
 for an **emotional payoff**
- I've always wanted to make a game that *connected* with me and this is my first oppurtinity to be able to express some
 creative liberties and create something I personally find fun and hope other can too.

USER'S STORY (phase one):
- As a user, I want to be able to be prompted to draw my weapon when I should react.
- As a user, I want to be able to know whether I won the dual or not.
- As a user, I want to be able to add my times to a high score list.
- As a user, I want the game to select a difficulty and have harder duals to win.
(Phase two)
- As a user, I want to be able to save my list of high scores
- As a user, I want to be able to start the game with the same high scores with which I saved

Uses of the Program (for TA)
- The main point is to able able to test you reaction time and see a general improvement or if you are slipping
- Start by running main and then selecting your difficulty from 1 to 5, 5 being the hardest
- After hitting the button declaring you are ready the button will disappear until you are prompted to fire your weapon
- You will be shown your time after each dual and you can see all your high scores in the high scores tab
- Feel free to save your data as well and it will be stored in the highScores.txt file in the data package
Notes about reading the code: 
- All GUI elements have been abstracted to be within default Layout as to be able to change
small details without having to sort through the whole code
- the css style sheet is with the default layouts as they all are set to that style
Requirements for the stage:
- First event related to HighScoreList) if you press a key (enter) fast enough in the game you store a new high score
- Second event related to HighScoreList) You can click a button to clear your high score list if you desire
- Audio Component) Along with the Fire! prompt the game will play a noise telling you when to fire your weapon
- Save Component) You can click the save button on the main screen to save all the high scores and they load when you
restart the application every time.
Postscript:
- If you wanna try and win on the hardest difficulty it requires .2 second reaction time! Good luck!

Phase 4: Task 2 
- I have a type hierarchy with DefaultScene and all classes in the interface folder (except for ReactionTimerInterface
 which has different functionality from the rest). The abstract class DefaultScene has the abstract method 
 InitializeRegions which is called in the constructor for the class which is then implemented in different ways in 
 each interface. In each classes implementation they will call methods from the super class in order to create their
 scenes based on how each one needs to look in a uniform manner, and to avoid repeated code.
 - Character, NPC, and PlayableCharacter is another type hierarchy. Although it is less complex it should still be
 mentioned as it has abstract methods and overriding.
 
 Phase 4: Task 3
 - When I originally finished phase 3 I had noticed quite a bit of coupling where I had passed the GameUI into every
 single interface in order to be able to set the scene and it wasn't very efficient. With the combination of applying
 the singleton principle with GameUI as well as getting the primaryStage in the DefaultScene class I no longer had to
 pass in the GameUI. I also was passing the HighScoreList quite a bit so applying the singleton principle helped
 reduce that coupling. I also applied the singleton principle to the PlayableCharacter class so I could implement new
 functionality into it so a user can customize their character in the future without having to redo it each new dual.
 - My UML diagram is labeled UMLProjectPhase4.pdf and found just below the read me file
 



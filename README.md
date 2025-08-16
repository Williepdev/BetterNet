# BetterNet

## Project scope


### Motivation and Insperation
I am a Track & Field Thrower (discus throw, ShotPut, Hammer Throw)
and the current way of tracking results, stats, and everything else just never works
and is not easily acessabile to use, and the best features are priced behind a pay wall.
and the only good platform just does not go in depth enough or make it easy to get the
jist of a meet or athlete, and does not provide the extra info needed to help people improve


### Problems I encountered and how I got around them
I really did and didn't have a lot of problems in this project, but a huge long part of the project
was Implementing 34 classes, which is a ton on its own but especially when we have done 4 at most before this.
A major part of that was the heirarchy and deciding what is a what and how it will differ
but as well as getting stuck for probably near hours at this point because of how those classes will just
wrap eachother in a circle of encapsulation, with one being required to make another and so on and so fourth
which would effectivly make all of the classes imposible to use and this really got to me, but then I did some
reasearch found out this is a very common thing that happens with newer people, and that most of the time it
can be fixed by creating it with a new ArrayList of that object and adding it in after or
assigning the object with a null parameter and using a setter to change it once I make the object that
encapsulates the previous. Another huge problem I encountered was with file handling, I had to scrap
file handling from the project as Athletic.net actually lets you export files, but only for some coaches and meet
managers, and if you do it through a third party it puts your perticipation at risk in the sport, as this company really has a monopoly
and as my coach was not able to access it, but this could be a possible thing to add l


### Current features
athlete management
team management
stat viewing
team viewing
duel meet scoring
meets
live results (sort of)
Decathalon calculator(male only, womens heptathalon to be implemented)
invite scoring
Scanner UI
advanced status (sector foul, circle foul, other reasons)


### Scraped features(from original scope)
File importing/reading (due to the files not easily being acessable by coaches and putting perticipation at risk if I were to grab the files)
Enum implementation(replaced with in depth classes and inheirtence)


### Future features(to implement)
Goal tracking
Rankings by event, age, state, division, team
Standard tracking
Heptathalon calculator(if a DecethaAthlete object has the String gender "Female")


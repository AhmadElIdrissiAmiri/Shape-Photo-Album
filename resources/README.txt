In this last assignment. I started by setting up my controllers. I had to make two controllers for the views. One for the swing app and one for the webview. 
I added an interface for them that takes the go method. For my controllers. I used an array
 of string and file.split method to split each line and then remove the empty spaces. 
I then checked for each word seperate. Shape, snapshot, remove, move, color, resize. 
I passed the right methods to do them. I then chose the corresponding view for each controller. The view for the swing application had to take three parameters. 
the fileName and the dimensions of the application.In the other hand, the webview had to take
four parameters. The list of the snapshots, the outputfile and the dimensions of the SVG view. 
That was the reason why I decided to put two controllers instead of one. 
After that I did the main method. In this class I started by analysing the command line and then I used 
the args[] and started looping through it and parsing and getting the right words and then passing them to the actual
views. This helped me to start checking my views in the same time. 
For my webview, I chose to do three stringbuilders, each one takes care of one specific thing. 
The header takes in the header of the html. The body takes in the information from the list  of the snapshots
and draws the shapes. The footer closes the html. I then did the bufferedWriter.write to join 
all my stringbuilders and have them as a file. 
After that, I tested the webview to check if everything is alright.I then moved to the swing app.
Here I had to start learning some of the swing feautures as it is my first time ever working on swing. 
I chose to do three panels. One for the buttons, one for the Snapshot IDs and one for the shapes drawing. I set the coordinates for them.
I set the background color as well and sat them visible. 
For the menu. I decided to make a new separate frame for that. 
I had to set the panels in a right position. I moved on to set the buttons and their action listeners. 
I had a class for the panelDrawing. I passed to it the list of shape and I used drawOval and drawRect to draw the shapes. Intellji had me to cast the parameters to int.
I wrote a short main just to test the buttons and the overall swing app. 

While doing all of that. I had to do some small changes for my model as I added a method to return a list of shapes in the snapshot class and one small change in the color
class in the range of the rgb. from 0 to 255 instead 0 to 1.0. 

I would say I could have done better for the swing app. But overall , I'm happy with what I have achieved in this class. Special thanks to Pr.Keith for his ample amount of help
in this class. I would also thank ALL the TAs for their incredible job on tutoring us and being so so so helpful. This project reinforced a lot of learnings in this class. 
It was a great experience. 

Thank you so much.
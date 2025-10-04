# ColorSeek
HomeWork02

INSTRUCTIONS:

To select a color, slide each seek bar (Red, Green and Blue) until the desired background shade is 
achieved. As you slide each seekbar the background will change color accordingly; in addition, each
of the seekbars will display the currently selected integer value for each color channel. At the 
bottom of the seekbar section you will also be able to see your selected color in it's HEXIDECIMAL
value.

Once you've achieved the desired color you can save your color selection by clicking the SAVE button
at the center of the screen. The saved colors will appear in a list at the bottom of the screen where
each cell will display the selected color in the background as well as the RGB and HEX values for 
that color. 

To return to any of your saved colors, simply scroll through the list at the bottom of the page and
click on your desired color. Clicking the saved color will return the seekbars to the corresponding
positions as well as display the background color and it's corresponding RGB and HEX values.

CODING ISSUES:

Overall this project went relatively smoothly and I've included all the required functionality. 
The GUI and the seekbar functionality were easy to set up and event the changing background colors 
and text colors were relatively straightforward. 

The hardest part of this stage of the project was figuring out how to change the text colors with
the background and figuring out the hexidecimal values. It only took some quick research to find 
formulas for calculating the HEX values from the RGB values and implementing that into a function.
Initially trying to figure out how to convert an RGB value to Hex was frustrating because all I 
found was examples of what the hexidecimal value was. I eventually aske Gemini for Java help with
the hexidecimal value and I learned how to use the String.Format() method and a format specifier to
tell java to format each RGB value as a 2 character HEX string value.

As for determining the text colors I did some googling and found a simple equation for calculating
relative luminance or brightness based on each of the RGB values. After that I picked a midrange value
and told the program to flip from black/white or vise versa based on the luminance value.

Lastly I thought the listview was going to be a lot more complicated than it was, though I did 
struggle a bit at first with setting up the custom adapter. After re watching the first couple lectures
with the "PetData" example and following along with my color seek program it eventually clicked. My 
biggest problem at one point was where I was declaring/defining my ArrayList<> variable and not being able 
to access it correctly. Once I fixed that it all came together. 

# AC_UI
Object Oriented Programming Assignment programmed on Java along with Processing libraries and Minim sound libraries. The theme this year is futuristic user interfaces. I picked a user interface that I always loved since day one, and that is the Assassin's Creed 1 Animus menu. Although slim in terms of interaction, the menu itself does have some complexity in its design.

This assignment is meant to test and improve our understanding of Java, OOP fundamentals and version control with Git and GitHub.

> Project designed on a MacBook Pro laptop with latest version of macOS Mojave, it does not include libraries for any other operating systems.

> IDE: IntelliJ IDEA Ultimate by JetBrains

[Demo on YouTube](https://youtu.be/8lp-x6DPZnM)

## Details

| Category | Description |
| -------- | ----------- |
| Name | Alexandru Cardas |
| ID | C17504869 |
| Class | DT228 |
| Year | 2 |

# Instructions

**No keyboard required**

Wait for setup animations to finish and then the main menu is displayed. The first part consists of a typewriter effect that displays the current location and the current date. The second one is a loading screen with the Abstergo logo in the middle of the screen and a loading text with changing alpha levels.

## Main

This is the default option for the menu. When it is active, the double helix is displayed in the middle of the screen until a different menu option is chosen.

## Options

This option is used to control the volume of the music. Once the button for options is clicked, two other buttons will appear on the screen, one for increasing and one for decreasing the volume. To go back to the main menu, simply click the main button.

## Exit

This option is self explanatory. Once clicked, it will exit and terminate the program instantly.

# Behind the Scenes

There is magic involved. Just kidding. Every element on the screen is an object unless it represents only the text. Coordinates are being passed to each object and they all posses a render and update method in order to first initialize them and then animate different parts. I used seconds, `millis()` function to animate my objects. The 3D parts are translated and rotated so that they remain on the same X coordinate while rotating around the X axis, changing their Y coordinate.

The typewriter was implemented using `substring` function and increasing the counter for the loop printing the letters using the time elapsed.Events are synchronized using a timer that is being passed around and to which we can add more seconds and increase the length of the loading sequence.

# Pride Points

## 3D

One of the aspects of project that was not covered in class is the 3D implementation. I use P3D to create spheres and boxes for my double helix DNA representation. I wanted to implement a 3D camera as well but it interfered with the coordinates of the buttons and it made them unreliable and so I had to remove it.

## Buttons

Mouse clicking was very easy to implement since each button can have its coordinates requested with the getter methods implemented inside the class. Once clicked, we then check which index that button holds inside the array list of buttons of a specific type and then we can record that index and use it accordingly. Buttons also get their text from .csv files.

## Learning

I did learn a great deal of Java while building this small project. I also learned a lot about myself, I discovered what I am good at and what I need to improve on.

## Code

My main focus was on the cleanliness of the code and its simplicity. There are no redundant lines of code and the same goes for DRY code. There are no hard-coded values, everything is relative to either the width or height of the screen, even the text.

## Design

Everything displayed on the screen is responsive. I spent a great deal of time making each element symmetric and engineered the parameters in such a way that regardless of the screen size, everything will scale accordingly and look consistent across any device.

## Bugs

None that meets the eye since there isn't much that the user can do to screw with my defenseless interface.

# Regretful Moments

## Time Management

I started working on this project relatively early but I had periods of time where I did not even look at the code. This resulted in bursts of code periods where a lot of code was written but the it did not feel consistent or that it had continuity. Most commits are made on a very few days of work rather than spanning across multiple days.

## Unfinished Business

I wanted to implement two other features to the interface, one being a fading in-and-out chemical formula across the screen and the other was a DNA inspector. I spent most of my time in improving the code that I already had and so I decided that scraping these two elements was a necessary sacrifice to do due to time limitations. Moreover I a wanted to use more vectors instead of only having one.

# Examples

## Grid

Took inspiration from the grid system in CSS, where you divide the screen in equal amounts and then you allocate these parts to individual divisions and make them have equal sizes and equal spacing in between.

![Grid](https://github.com/AlexandruCardas/AC_UI/blob/master/images/Grid.png)

## Inheritance

![Inheritance](https://github.com/AlexandruCardas/AC_UI/blob/master/images/Inheritance.png)

## Abstraction

![Abstract](https://github.com/AlexandruCardas/AC_UI/blob/master/images/Abstract.png)

## Interface

![Interface](https://github.com/AlexandruCardas/AC_UI/blob/master/images/Interface.png)

## Timer

These timers are used to precisely control the events happening on the screen. The transitions from the typewriter into the loading screen and then into the main menu.

![Timer 1](https://github.com/AlexandruCardas/AC_UI/blob/master/images/Timer1.png)
![Timer 2](https://github.com/AlexandruCardas/AC_UI/blob/master/images/Timer2.png)

## Flow

This refers to the menu selection. I made it impossible for the user to click on the buttons unless the loading animation is finished.

![Flow](https://github.com/AlexandruCardas/AC_UI/blob/master/images/Flow.png)

## Map

Used for creating the volume bar.

![Map](https://github.com/AlexandruCardas/AC_UI/blob/master/images/Map.png)

## Mouse

![Logo](https://github.com/AlexandruCardas/AC_UI/blob/master/images/Mouse.png)

## Logo

Created with mathematics and there is a equilateral triangle in the middle of the logo.

![Logo](https://github.com/AlexandruCardas/AC_UI/blob/master/images/Abstergo.png)

## DNA

![DNA](https://github.com/AlexandruCardas/AC_UI/blob/master/images/DNA.png)

## Constructor

Similar implementation to the one we learned to do for the in-class test.

![Constructor](https://github.com/AlexandruCardas/AC_UI/blob/master/images/Constructor.png)

## Vector

![Vector](https://github.com/AlexandruCardas/AC_UI/blob/master/images/Vector.png)

## File I/O

Importing the data from the files.

![IO](https://github.com/AlexandruCardas/AC_UI/blob/master/images/IO1.png)

Loading the data into the class.

![IO](https://github.com/AlexandruCardas/AC_UI/blob/master/images/IO2.png)

Rendering the buttons with the loaded data.

![IO](https://github.com/AlexandruCardas/AC_UI/blob/master/images/IO3.png)

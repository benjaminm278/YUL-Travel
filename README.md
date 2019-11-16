# YUL Travel: Le perfect recipe pour un bon voyage

## Description
YUL Travel is a travelling application for travellers who want to travel to 
Montreal. It is an all-in-one app that allows users to retrieve convenient 
information about Montreal as well as placing all trip information into one app.

## Usage
This app would provide different features that will make the trip a success. 

One of the features would be having a list of hot spots in Montreal that the 
traveller (user) could look through to determine a place to visit. The hot spots
would most likely be defined in a local database. The app can also suggest 
activities and places that the user might be interested in. In addition, the app 
could also suggest activities within the user’s free time (if the user lets the 
app send notifications).

Another feature would be providing weather information for the next 3 days. With
the weather information, the app would propose suggestions about what the 
traveller should bring outside. Weather information would be obtainable through 
Open Weather API and suggestions would be defined in a local database.
There would also be a feature that allows travellers to get directions to key 
locations such as the airport or metro in just a few clicks.

One other feature would be the plan feature, which allows the traveller to put 
‘tasks’ such as eating at a particular restaurant for breakfast or perhaps 
visiting the Mont-Royal mountain. These tasks in the plan would be stored in a 
local database. The traveller (user) can decide what to do. Also the user can 
enter a list of activities/events that they would like to do. Depending on the 
activity/event, they can put in the time. This can give them a notification in 
advance (30 minutes before the activity).

The app would also have a settings activity. Some of the features would include 
night mode, notifying the user of events (toggle on/off), account modification, 
change interests (preferences).

This app is the perfect recipe for a happy and satisfied traveller!

## Target
The app is targeted for anyone traveling to Montreal. Ideally, the users would 
be anyone above the age of 13.

## Alternatives:
1.  	So Montreal
2.  	Mon guide officiel de Montreal

## Visuals
### Home Screen:
![Home_Screen](/uploads/6cc507dd07f5a63a1a1a0d40be46c20f/Home_Screen.PNG)
### Spots Activity:
![HotSpots](/uploads/bcc66a80ddf1dfee7488334352c0955b/HotSpots.PNG)
### Plan Activity:
![Plan_Activity](/uploads/ec9de3fc003f2ea3e07bbaccee84fae4/Plan_Activity.PNG)

## Roadmap
**1st milestone:** The first milestone focuses on creating the layouts of all
screens of the application.
* Home screen: ImageButtons (no set images) take the user to other activities.
Rough layout of screen would be developed.
* Setup: Contains a form with labels, edittexts, spinners and button.
* Directions: Layout of categories for directions. Category buttons successfully
trigger a toast or log event.
* Plan: Create layout of plan activity
* Weather: Create layout of weather activity

**2nd milestone:** The second milestone will continually add more design
elements to the screens, as well as calling various APIs.
* Determine colors to use for various elements of the application
* Home screen: Place actual images on the image buttons
* Setup: Contains imageview at top; edittexts, spinners and checkboxes have 
their data saved successfully
* Directions: Use the Google Maps intent to plot out directions
* Plan: Successful call to Eventful API.
* Weather: Successful call to weather API
* ImageView headers implementation

**3rd milestone:** The third milestone will implement a local database,
fine-tune the aesthetics and design of the application, and modify the
behavior of the application based on certain conditions.
* Home screen: Detect if the app has been setup. If it hasn’t, display setup 
application button. Utilize Sharedpreferences.
* Setup: Store data in database
* Directions: Display map, from/to boxes, methods of transportation and 
instructions
* Plan: Store plan in database (with dialog implemented)
* Weather: Provides suggestions based on weather

## Authors
Sidney Gadosy, Abid Hussain, Benjamin Mah 

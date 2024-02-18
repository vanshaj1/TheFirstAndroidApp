# The First Android App
# Component Structure
   * **Main Activity**
     * [**App**](#App)
        * [**ProgressTrackComponent**](#ProgressTrackComponent)
        * [**OutputScreenComponent**](#OutputScreenComponent)
        * [**UtilitiesComponent**](#UtilitiesComponent)


# App
 - This having :- 
    - Mutable States 
      * [states](#states) 
    - Composables
      * [**ProgressTrackComponent**](#ProgressTrackComponent)
      * [**OutputScreenComponent**](#OutputScreenComponent)
      * [**UtilitiesComponent**](#UtilitiesComponent)
 - This have arranged all components inside in **Column** composable
 - This is passing all the states and functions that are changing these states to these composables. According to each component functionality

# Stops Data Class
 - This class objects are having two properties:-
    * Name
    * Distance
 
# States
- On change of these states recomposition happens and composable functions which are dependent on these states will get _**re-composed / re-rendered**_.
 * **stopsList**
    - StopsLists are populated using functions either _getTenStops_ or _getTwentyStops_ :-
        * _getTenStops_ : This return List of Objects of stops data class of size 10
        * _getTwentyStops_ : This return List of Objects of stops data class of size 20
 * **Mutable States**
    * distanceTravelled:
      This is of type Integer, On every calling of Lambda function onNextStop by the UtilitiesComponent's Button NextStop Click.This will be increamented by 1,
      It is by default unit is KM.
    * distanceInKm:
      - This is of Type Boolean, On every calling of Lambda function onConvert by the UtilitiesComponent's Button Converter Click, Its value will be toggled.
        Its by Default value is false.
      - Its value defines that _what is measurement unit now ?_. If It's value is false then Unit is miles and if it's value is true then Unit is KiloMeter
    
# ProgressTrackComponent
  * Parameters
    * stopsListSize
    * distanceTravelled
  - This Composable function have _LinearProgressIndicator_ composable function which render the _progress bar_. It's progress depend on the value of stopsListSize and distanceTravelled
  - If the stopListSize is 10 then one step in progress bar will be of 0.0222f 
  - Else if the stopListSize is 20 then one step in progress bar will be of 0.0106f
  - How much the progress is there in progress bar is defined by value of distanceTravelled. we multiply distanceTravelled with the one step that is determined by value of stopsListSize to show the progress.
  - In every increase of the value of distanceTravelled progress bar's progress increases

# OutputScreenComponent
   - It is Composable function and having parameters :-
     * stopsList: 
         It is of type List<Stops>, passed from App Component. It will help in showing all the stop with distances
     * distanceTravelled: 
         It is of type Int, passed from App Component. It will help in identifying at which distance the user is. 
     * distanceInKm: 
         It is of type Boolean, passed from App Component. It will help in identifying the current Unit of measurement
   - Internal Component structure:
     * Text
        - This will display the current Unit of measurement of the distances
     * BOX
       * Lazy Column
        - In this we loop over the stopsList items and for each item we print the Text
          * Text
             - This will show the _item.name_ (Stop No) and _item.distance_ (Stop Distance) of the stop from **stop 0** i.e _Source point_
             - According to the _distanceTravelled_ value,if the _item.distance_ equal to _distanceTravelled_ then this Text will be highlighted with Cyan Color
             - According to the distanceInKm value, if distanceInKm is true then _item.distance_ will be shown in KM.
               Else if distanceInKm is false then **_item.distance_ * 0.621371** will shown to show the distance in miles
       * Column
         * Text (**covered**)
            - This show the how much distance is **covered** by the user till now by showing the value of distanceTravelled
            - According to the distanceInKm value, if distanceInKm is true then **covered** will be shown in KM.
              Else if distanceInKm is false then **distanceTravelled * 0.621371** will shown as **covered** to show the distance in miles
         * Text (**Left**)
            - This show the how much distance is **Left** by the user till now by showing the value of **_(stopsList.size - 1) * 5 - distanceTravelled_**
            - According to the distanceInKm value, if distanceInKm is true then **Left** will be shown in KM.
              Else if distanceInKm is false then _**(stopsList.size - 1) * 5 - distanceTravelled * 0.621371**_ will shown as **Left** to show the distance in miles
       * Text
         - This will Show instruction to the user that pressing next Stop button distance travelled will be incremented by 1 with respect to unit chosen by the user 

# UtilitiesComponent
  - This is composable function which is used to change the states of the App
  - This takes Three Arguments 
     * onConvert: 
       This is of type **() -> Unit**, This is the function which Toggle the value of the _**distanceInKm**_ Mutable state of the App component.
     * onNextStop:
       This is of type **() -> Unit**, This is the function which increment by one the _**distanceTravelled**_ Mutable state of the App component.
     * onLoadStops:
       This is of type **() -> Unit**, his is the function which initialize the value to 0 of the _**distanceTravelled**_ Mutable state of the App component
    - Internal Structure
      * Box
        * Button (_Coverter_) 
          - This is having onClick Listener which is pointing to onConvert. So when this button gets clicked then onConvert function will be called.
        * Button (_NEXT Stop_)
          - This is having onClick Listener which is pointing to onNextStop. So when this button gets clicked then onNextStop function will be called.
        * Button (_Load Stops_)
          - This is having onClick Listener which is pointing to onLoadStops. So when this button gets clicked then onLoadStops function will be called.

# OutputScreenWithNormalListComponent 
   - This is same as OutputScreenComponent but instead of lazy column it is using Normal Column
   - This is used to show the difference between Lazy column and Normal Column, just my commenting it and uncommenting it. 

# Output
    ![](D:\Assignments M.Tech 2nd Semester\TheFirstAndroidApp\TheFirstAndroidAppOutput.jpeg)
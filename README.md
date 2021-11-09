# Instructions

You are tasked with creating a graphical Weather app
which displays various data items to the user. Below is
the information you will need to display:

| Day Names | Sunday | Monday | Tuesday | Thursday | Friday | Saturday |
|---|---|---|---|---|---|---|
| Temperature | 59 | 70 | 64 | 84 | 65 | 70 | 80 |
| Chance of Rain | 90% | 50% | 0% | 0% | 60% | 30% | 0% |
| Weather Type | Rain | Partly Cloudy | Cloudy | Sunny | Cloudy | Partly Cloudy | Sunny |

1. Create an array for each row in the table, including "Day Names".
    - Make "Day Names" an Array of `String`s
    - Make "Weather Type" an `enum`
1. Create the `drawGraphNode` method
    - First plot an ellipse for each day based on the temperature.
    - The y-position for each node should be `450 - temperature * 5`
    - The x-position should start 1/14th of the width across the canvas,
    and each node should be spaced 1/7th the width of the canvas apart.
1. Next connect each node in the graph to the next node with a line
1. Create the `drawWeather` method
    - This method should display in each day box:
        - an image corresponding to the weather type.
        - the temperature plus the `°` symbol (you can copy the symbol from here).
        - the change of rain followed by `%`.
    - the call to `textMode` in the `setup` method has set it to CENTER
    so you can place the text directly in the center of each box for the
    corresponding day.
    - imageMode has also been set to CENTER
1. Create the `drawDayOfWeek` method
    - This method should write the name of each day underneath each day box
1. Create the `drawAverageTemperature` method
    - This method first calculates the average temperature of the `temperatures`
    array
    - Then displays the text "Average Temperature: " followed by that value
    - You can place this text at position `(width - 150, 170)`
    
## A Completed Project Will:

Display all of the above information using the data types requested in the first
step.
Display a proper line graph of the temperatures.
Make use of for loops to traverse the arrays (not copy and paste).
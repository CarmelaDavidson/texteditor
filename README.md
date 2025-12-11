# CSC 207: Text Editor

**Author**: Carmela Davidson

## Resources Used

+ Prof Osera
+ TTAP
+ 
## Changelog

+ Added README
+ updated all of gapbuffer to work as intended


## Part 2

-The relevant input(s) to the method is str.length
-The critical operation(s) are str.substring() statements
-A mathematical model of the runtime of insert is t(n) = n
-insert is O(n).
Since strings are immutable in java, we have to duplicate the string, meaning we touch each 
character of the string once, giving us a model of T(n) = n
# DateUtil
Problem set:  To add number of days to a given date (where a date exposes its day, month and year) without using date helper functions.

# Solution:

# There can be two approach for the problem set.

# Approach 1:
1. To take a base year and break down the current days into number of days from an epoch day. Then adding the number of days required to be added to this number.
2. Then converting the number of days back to the date.
3. This is the approach taken in the LocalDate class introduced in Java 8.
4. Since this code is readily visible, I decided to go with the primitive alogorithm I thought of during my interview.

# Approach 2:
To recursively keep adding days, months and years.

# 2.a
1. One approach which results in all my test cases getting passed is to take a data structure to define number of days for each month. A single dimesion array is fine.
2. Have a logic for determining whether a year is leap or not. I have gone with the understanding that a leap year is the one which is either divisble wholly by 400 or is divisible by 4 but not by 100.
3. Go recursively or using a looping mechanism to keep adding days to current day of the date and checking if it has exceeded the number of days for the month, and then for the year.
4. This is implemented in DateUtils Class as attached by me.
5. Problem with this approach is that it is not the most efficient approach. If number of days is very big, the number of iterations might increase as we are going on iterations at month level

# 2.b
1. I decided to then chop off the number of years  beforehand and then taking 2.a path
2. In this I would have to take care of the number of leap days as I have taken a standard 365 day year.
3. I was able to achieve most of the test cases, but one boundary case do remain where in addition of 365 or more days don't tip over 29-Feb of the following leap year.
4. I will work on this specific probem now. Probably, deciding on a block which remains constant.

In the meantime, I have committed the files at following github repo.







# EditDistance
Edit Distance is finding the similarities in two given strings. The lower the number the more similar the two strings are.
We pay a penalty of +2 if we have to insert a gap in order to align the strings for better matching, and a +1 if two characters are
mismatched and we need to insert one. If the characters match then we can take the character with no cost at all.
- This code implements a Dynamic Programming Approach to this problem where a recursive solution could work but would take too long
- Implemented a 1D Array with Dynamic Programming and proper backtracing to get the values and their costs
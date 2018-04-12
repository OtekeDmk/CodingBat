/*
word0 
Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, always with the value 0. For example the string "hello" makes the pair "hello":0. We'll do more complicated counting later, but for this problem the value is simply 0.
word0(["a", "b", "a", "b"]) → {"a": 0, "b": 0}
word0(["a", "b", "a", "c", "b"]) → {"a": 0, "b": 0, "c": 0}
word0(["c", "b", "a"]) → {"a": 0, "b": 0, "c": 0}
*/
public Map<String, Integer> word0(String[] strings) {
  Map<String, Integer> map = new HashMap<>();
  for (String s:strings) {
    map.put(s, 0);
  }
  return map;
}

/*
wordLen
Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, and the value is that string's length.


wordLen(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 1}
wordLen(["this", "and", "that", "and"]) → {"that": 4, "and": 3, "this": 4}
wordLen(["code", "code", "code", "bug"]) → {"code": 4, "bug": 3}
*/
public Map<String, Integer> wordLen(String[] strings) {
  Map<String, Integer> map = new HashMap<>();
  for (String s:strings) 
    map.put(s, s.length());
  
  return map;
}

/*
pairs 
Given an array of non-empty strings, create and return a Map<String, String> as follows: for each string add its first character as a key with its last character as the value.


pairs(["code", "bug"]) → {"b": "g", "c": "e"}
pairs(["man", "moon", "main"]) → {"m": "n"}
pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
*/
public Map<String, String> pairs(String[] strings) {
  Map<String, String> map = new HashMap<>();
  for (String s:strings) 
  map.put (s.substring(0,1), s.substring(s.length()-1));
  
  return map;
}

/*
wordCount
The classic word-count algorithm: given an array of strings, return a Map<String, Integer> with a key for each different string, with the value the number of times that string appears in the array.


wordCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
wordCount(["c", "b", "a"]) → {"a": 1, "b": 1, "c": 1}
wordCount(["c", "c", "c", "c"]) → {"c": 4}
*/

public Map<String, Integer> wordCount(String[] strings) {
   Map<String, Integer> map = new HashMap<>();

  for (String s : strings) 
  {
   if (!map.containsKey(s)) 
   {
    map.put(s, 1);
   } 
   else {
      int c = map.get(s);
      map.put(s, c + 1);
        }
  }
  return map;
}

/*
 firstChar
 Given an array of non-empty strings, return a Map<String, String> with a key for every different first character seen, with the value of all the strings starting with that character appended together in the order they appear in the array.

firstChar(["salt", "tea", "soda", "toast"]) → {"s": "saltsoda", "t": "teatoast"}
firstChar(["aa", "bb", "cc", "aAA", "cCC", "d"]) → {"a": "aaaAA", "b": "bb", "c": "cccCC", "d": "d"}
firstChar([]) → {}
*/
public Map<String, String> firstChar(String[] strings) {
  Map<String, String> map = new HashMap<>();
  for (String s:strings)
  {
    String a = s.substring(0,1);
    if(!map.containsKey(s.substring(0,1)))
    map.put(s.substring(0,1),s);
    else  map.put(s.substring(0,1), map.get(a) + s);
    
  }
    return map;
}
/*
wordAppend 

Loop over the given array of strings to build a result string like this: when a string appears the 2nd, 4th, 6th, etc. time in the array, append the string to the result. Return the empty string if no string appears a 2nd time.

wordAppend(["a", "b", "a"]) → "a"
wordAppend(["a", "b", "a", "c", "a", "d", "a"]) → "aa"
wordAppend(["a", "", "a"]) → "a"
*/
public String wordAppend(String[] strings) {

  String res = "";
  Map<String, Integer> map=new HashMap<>();
  
  for (String s:strings) 
  {
    int i = 1;
    if (map.containsKey(s)) 
    {
      i = map.get(s) + 1;
      map.put(s, i);
      if (i%2 == 0) {   
            res=res + s;
                  }
    } else map.put(s, i); // the first operation
  }
  return res;
}

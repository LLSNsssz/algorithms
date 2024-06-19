class Solution {
  public String solution(String myString) {
    for(int i = 0; i < myString.length(); i++) {
      if(String.valueOf(myString.charAt(i)).compareTo("l") < 0) {
        myString = myString.replace("" + myString.charAt(i), "l");
      }
    }
    return myString;
  }
}
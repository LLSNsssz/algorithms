class Solution {
  static int count = 0;

  public static int solution(String myString, String pat) {

    if(myString.contains(pat)) {
      count++;
      int index = myString.indexOf(pat);
      String newStr = myString.substring(index + 1);
      solution(newStr, pat);
    }
    return count;
  }

}
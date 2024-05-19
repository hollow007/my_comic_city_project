package za.ac.cput.util;

/* ReviewHelper.java
   Review helper class
   Author: Cavan Ramone Swartz (221055835)
   Date: 17 May 2024
   https://github.com/hollow007/my_comic_city_project
 */
public class ReviewHelper {
    public static boolean isNullOrEmpty(String s){
        if(s == null || s.isEmpty()){
            return true;
        }
        return false;
    }

}

import java.util.Queue;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        if(str.length==1){
            if(pattern.length==1&&(pattern[0]==str[0]||pattern[0]=='.'))
                return true;
            if(pattern.length==2&&pattern[0]==str[0]&&pattern[1]=='*')
                return true;
            return flase;
        }
        if(str.length==2){
            if(pa)
        }
    }
}
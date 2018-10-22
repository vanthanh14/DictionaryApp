
package javaapplication6;

import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> listWord = new ArrayList<Word>();

    public Dictionary() {
       // Dictionary myDic = new Dictionary() ;
    }
    public Dictionary(ArrayList<Word> _listWord) {
        this.listWord = _listWord;
    }

    public ArrayList<Word> getListWord() {
        return this.listWord;
    }

    public void addNewWord (Word newWord){
        this.listWord.add(newWord);
    }
}

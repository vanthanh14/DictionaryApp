
package javaapplication6;

import java.util.ArrayList;

public class DictionaryCommandline {
    private DictionaryManagement myDicManger;

    public DictionaryCommandline(){
        myDicManger = new DictionaryManagement();
    }
    public DictionaryCommandline(DictionaryManagement x){
        myDicManger = x;
    }

    private void showAllWords(){
        System.out.println("No  | English       | Vietnamese ");
        ArrayList<Word> myArr = this.myDicManger.getMyDicData();

        for (int i=0; i<myArr.size() ;i++)
        {
            Word word = myArr.get(i);
            int number = i+1;
            System.out.println(number + "  | " + word.getWord_target() + "             | " + word.getWord_explain());
        }
    }

    public void dictionaryBasic(){
        myDicManger.insertFromCommandline();
        showAllWords();
    }

    //cai tien lan 1
    public void dictionaryAdvanced(){
        myDicManger.insertFromFile();
        myDicManger.dictionaryLookup();
        showAllWords();        
    }


    //Tim tu gan dung (danh sach )
    public void dictionarySearcher(String searchWord){
        ArrayList<Word> resultList = this.myDicManger.searchPrefix(searchWord);
        for (int i=0; i<resultList.size(); i++)
        {
            System.out.print(resultList.get(i).getWord_target()+ ", ");
        }
    }
}


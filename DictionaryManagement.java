
package javaapplication6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary myDic;

    public DictionaryManagement() {
        this.myDic = new Dictionary();
    }

    public ArrayList<Word> getMyDicData() {
        return this.myDic.getListWord();
    }

    public void insertFromCommandline() {
        System.out.println("Enter number of words");
        Scanner myScanner = new Scanner(System.in);

        int numberWord = myScanner.nextInt();
        String t = myScanner.nextLine();
        for (int i=0; i<numberWord; i++)
        {
            String eWord, vWord;
            System.out.println("Enter English word: ");
            eWord = myScanner.nextLine();

            System.out.println("Enter Vietnamese word: ");
            vWord = myScanner.nextLine();

            Word newWord = new Word(eWord, vWord);
            myDic.addNewWord(newWord);
        }
    }

    // cai tien lan 1
    public void  insertFromFile(){
        try{
            File inFile = new File("dictionaries.txt ");
            FileReader fileReader = new FileReader(inFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line= reader.readLine()) !=null){
                String [] sepa= line.split("\t");
                Word word = new Word(sepa[0],sepa[1]);
                myDic.addNewWord(word);
            }
            reader.close();
        }
        catch (Exception e){
        }
    }

    // tra cuu tu dien bang dong lenh
    public void dictionaryLookup(){
        System.out.print("Tu ban muon tra la: ");
        Scanner myScanner = new Scanner(System.in);
        String n = myScanner.nextLine();
        for(int i=0; i<getMyDicData().size(); i++){
            if(n.equals(getMyDicData().get(i).getWord_target())){
                System.out.print("nghia cua tu do la: ");
                System.out.println(getMyDicData().get(i).getWord_explain());
                break;
            }
        }
    }

    //Tim tu gan dung (list tu )
    public ArrayList<Word> searchPrefix (String searchWord){
        ArrayList<Word> curList = this.myDic.getListWord();
        ArrayList<Word> resultList = new ArrayList<Word>();
        for (int i=0; i<curList.size(); i++)
        {
            if(curList.get(i).getWord_target().substring(0, searchWord.length()).equals(searchWord)){
               resultList.add(curList.get(i));
            }
        }
        return resultList;
    }
}

    



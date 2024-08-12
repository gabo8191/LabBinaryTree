package co.edu.uptc.model;

import java.util.ArrayList;

public class Translator {

  private ArrayList<Dictionary> dictionaries;

  public Translator() {
    dictionaries = new ArrayList<>();
  }

  public void addDictionary(Dictionary dictionary) {
    dictionaries.add(dictionary);
  }

  public void addTranslation(String word, String translate, int dictionary) {
    Word auxWord = dictionaries.get(dictionary).searchWord(word);
    if (auxWord != null) {
      auxWord.setTranslation(translate);
    } else {
      dictionaries.get(dictionary).addWord(new Word(word, translate));
    }
  }

  public String searchTranslation(String word, int dictionary) {
    Word auxWord = dictionaries.get(dictionary).searchWord(word);

    if (auxWord != null) {
      return auxWord.getTranslation();
    }
    return null;
  }

  public void deleteWord(String word, int dictionary) {
    dictionaries.get(dictionary).deleteWord(word);
  }

  public String showWords(int dictionary) {
    return dictionaries.get(dictionary).showWords();
  }

  public int countAllWords(int dictionary) {
    return dictionaries.get(dictionary).countAllWords();
  }

}

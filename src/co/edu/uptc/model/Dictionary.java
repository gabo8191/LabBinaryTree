package co.edu.uptc.model;

import java.util.ArrayList;

import co.edu.uptc.structures.BinaryTree;

public class Dictionary {
  private BinaryTree<Word> words;

  public Dictionary() {
    words = new BinaryTree<>((x, y) -> x.getWord().compareToIgnoreCase(y.getWord()));
  }

  public void addWord(Word word) {
    words.insert(word);
  }

  public void deleteWord(String word) {
    try {
      words.delete(new Word(word, ""));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Word searchWord(String word) {
    return words.search(new Word(word, ""));
  }

  public void updateWord(String word, String translation) {
    Word auxWord = searchWord(word);
    if (auxWord != null) {
      auxWord.setTranslation(translation);
    }
  }

  public String showWords() {
    StringBuilder sb = new StringBuilder();
    ArrayList<Word> list = words.inOrder();
    for (Word word : list) {
      sb.append(word.getWord()).append(" - ").append(word.getTranslation()).append("\n");
    }
    return sb.toString();
  }

  public int countAllWords() {
    return words.size();
  }

}

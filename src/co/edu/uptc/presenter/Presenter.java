package co.edu.uptc.presenter;

import co.edu.uptc.model.Dictionary;
import co.edu.uptc.model.Translator;
import co.edu.uptc.model.Word;
import co.edu.uptc.view.View;

public class Presenter {

	private Translator translator;
	private View view;

	public Presenter() {
		translator = new Translator();
		view = new View();
		loadData();
	}

	public void loadData() {
		Dictionary dicEn = new Dictionary();
		dicEn.addWord(new Word("hola", "hi"));
		dicEn.addWord(new Word("carro", "car"));
		dicEn.addWord(new Word("mariposa", "butterfly"));
		dicEn.addWord(new Word("mantequilla", "butter"));
		dicEn.addWord(new Word("lapiz", "pencil"));
		dicEn.addWord(new Word("perro", null));
		dicEn.addWord(new Word("casa", "house"));
		translator.addDictionary(dicEn);

		Dictionary dicFr = new Dictionary();
		dicFr.addWord(new Word("almohada", "oreiller"));
		dicFr.addWord(new Word("gato", "chat"));
		dicFr.addWord(new Word("hola", "salut"));
		dicFr.addWord(new Word("maleta", "sac"));
		dicFr.addWord(new Word("computador", "l'ordinateur"));
		dicFr.addWord(new Word("casa", "maison"));
		dicFr.addWord(new Word("cortina", "rideau"));
		dicFr.addWord(new Word("sapo", null));
		dicFr.addWord(new Word("amigo", "mec"));
		dicFr.addWord(new Word("zapato", null));
		dicFr.addWord(new Word("cuaderno", "cahier"));
		dicFr.addWord(new Word("alma", null));
		translator.addDictionary(dicFr);
	}

	public int showMenu() {
		view.showMessage("=====================================");
		view.showMessage("SISTEMA DE DICIONARIOS MULTILINGÜES");
		view.showMessage("=====================================");
		view.showMessage("1. DICCIONARIO ESPAÑOL - INGLÉS");
		view.showMessage("2. DICCIONARIO ESPAÑOL - FRANCÉS");

		int option = Integer.parseInt(view.readData());
		return option;
	}

	public void ESENDictionary() {
		int dictionaryIndex = 0;
		int option = 0;
		do {
			option = subMenu();
			switch (option) {
				case 1:
					addWord(dictionaryIndex, "inglés");
					break;
				case 2:
					searchWord(dictionaryIndex);
					break;
				case 3:
					deleteWord(dictionaryIndex);
					break;
				case 4:
					showWords(dictionaryIndex);
					break;
				case 5:
					countWords(dictionaryIndex);
					break;
				case 6:
					view.showMessage("Regresando al menú principal");
					break;
				default:
					view.showMessage("Opción no válida");
					break;
			}
		} while (option != 6);
	}

	public void ESFRDictionary() {
		int dictionaryIndex = 1;
		int option = 0;
		do {
			option = subMenu();
			switch (option) {
				case 1:
					addWord(dictionaryIndex, "francés");
					break;
				case 2:
					searchWord(dictionaryIndex);
					break;
				case 3:
					deleteWord(dictionaryIndex);
					break;
				case 4:
					showWords(dictionaryIndex);
					break;
				case 5:
					countWords(dictionaryIndex);
					break;
				case 6:
					view.showMessage("Regresando al menú principal");
					break;
				default:
					view.showMessage("Opción no válida");
					break;
			}
		} while (option != 6);
	}

	public void addWord(int dictionaryIndex, String language) {
		view.showMessage("Ingrese la palabra en español");
		String spanishWord = view.readData();
		view.showMessage("Ingrese la palabra su traducción en: " +
				language);
		String translation = view.readData();
		try {
			translator.addTranslation(spanishWord, translation, dictionaryIndex);
		} catch (Exception e) {
			view.showMessage(e.getMessage());
		}
	}

	public void searchWord(int dictionaryIndex) {
		view.showMessage("Ingrese la palabra en español");
		String spanishWord = view.readData();
		try {
			String translation = translator.searchTranslation(spanishWord, dictionaryIndex);
			if (translation != null) {
				view.showMessage("La traducción de " + spanishWord + " es: " + translation);
			} else {
				view.showMessage("La palabra no se encuentra en el diccionario");
			}
		} catch (Exception e) {
			view.showMessage(e.getMessage());
		}
	}

	public void deleteWord(int dictionaryIndex) {
		view.showMessage("Ingrese la palabra en español");
		String spanishWord = view.readData();
		try {
			translator.deleteWord(spanishWord, dictionaryIndex);
			view.showMessage("La palabra ha sido eliminada");
		} catch (Exception e) {
			view.showMessage(e.getMessage());
		}
	}

	public void showWords(int dictionaryIndex) {
		view.showMessage(translator.showWords(dictionaryIndex));
	}

	public void countWords(int dictionaryIndex) {
		view.showMessage("El diccionario tiene " + translator.countAllWords(dictionaryIndex) + " palabras");
	}

	public int subMenu() {
		view.showMessage("=====================================");
		view.showMessage("SISTEMA DE DICIONARIOS MULTILINGÜES");
		view.showMessage("=====================================");
		view.showMessage("1. Agregar palabra");
		view.showMessage("2. Buscar palabra");
		view.showMessage("3. Eliminar palabra");
		view.showMessage("4. Mostrar palabras");
		view.showMessage("5. Contar palabras");
		view.showMessage("6. Regresar al menú principal");

		int option = Integer.parseInt(view.readData());
		return option;
	}

	public void run() {
		int option = 0;
		do {
			option = showMenu();
			switch (option) {
				case 1:
					ESENDictionary();
					break;
				case 2:
					ESFRDictionary();
					break;
				case 3:
					view.showMessage("Gracias por usar el sistema");
					break;
				default:
					view.showMessage("Opción no válida");
					break;
			}
		} while (option != 3);
	}

	public static void main(String[] args) {
		Presenter presenter = new Presenter();
		presenter.run();

	}
}

package main;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryManagement {
    protected Map<String, Pair<String, Integer>> mp = new HashMap<>();
    protected Trie trie = new Trie();

    public void addAllTrie(Dictionary dictionary) {
        try {
            for (Word w : dictionary) {
                trie.insert(w.getWord_target());
            }
        } catch (NullPointerException e) {
            System.out.println("Rỗng!");
        }
    }

    public void insertFromFile(String path ,Dictionary dictionary) {
        File f = new File(path);
        try {
            List<String> allText = Files.readAllLines(f.toPath(), StandardCharsets.UTF_8);
            for (String line : allText) {
                String[] word = line.split(" : ");
                String eng = word[0];
                String vie = word[1];
                Word w = new Word(eng, vie);
                mp.put(eng, new Pair<>(vie, dictionary.size()));
                dictionary.add(w);
            }
            addAllTrie(dictionary);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String dictionaryLookup(String a) {
        if (!mp.containsKey(a)) {
            return null;
        }
        return mp.get(a).getKey();
    }

    public void dictionaryAdd(Dictionary dictionary, String eng, String vie, String path) {
        mp.put(eng, new Pair<>(vie, dictionary.size()));
        Word w = new Word(eng, vie);
        dictionary.add(w);
        trie.insert(eng);
        dictionaryExportToFile(path, dictionary);
    }

    public void dictionaryUpdate_replace(Dictionary dictionary, String eng, String vie, String path) {
        int tmp = mp.get(eng).getValue();
        mp.replace(eng, new Pair<>(vie, tmp));
        dictionary.get(tmp).setWord_explain(vie);
        dictionaryExportToFile(path, dictionary);
    }

    public void dictionaryUpdate_add(Dictionary dictionary, String eng, String vie, String path) {
        int tmp = mp.get(eng).getValue();
        String oldExplain = dictionary.get(tmp).getWord_explain();
        dictionary.get(tmp).setWord_explain( oldExplain + vie);
        mp.replace(eng, new Pair<>(STR."\{oldExplain}, \{vie}", tmp));

        dictionaryExportToFile(path, dictionary);
    }

    public void dictionaryRemove(Dictionary dictionary, String eng, String path) {
        int tmp = mp.get(eng).getValue();
        dictionary.remove(dictionary.get(tmp));
        mp.remove(eng);
        dictionaryExportToFile(path, dictionary);
    }

    public void dictionaryExportToFile(String path, Dictionary dictionary) {
        try {
            PrintWriter pw = new PrintWriter(path, StandardCharsets.UTF_8);
            for (Word w:dictionary) {
                pw.println(STR."\{w.getWord_target()} : \{w.getWord_explain()}");
            }
            pw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}

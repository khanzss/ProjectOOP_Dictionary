package main;

import java.util.*;

public class DictionaryCommandline {

    public void showAllWords(DictionaryManagement dictionaryManagement, Dictionary dictionary) {
        String str= "";
        str += "No\t|\t\tEnglish\t\t|\t\tVietnamese \n";
        int n = 1;
        TreeMap<String, Pair<String, Integer>> sorted = new TreeMap<String, Pair<String, Integer>>(dictionaryManagement.mp);
        Set<Map.Entry<String, Pair<String, Integer>>> mappings = sorted.entrySet();
        for (Map.Entry<String, Pair<String, Integer>> mapping : mappings) {
            str += n + "\t|\t\t" + mapping.getKey() + "\t\t|\t\t" + mapping.getValue().getKey() + "\n";
            n++;
        }
        System.out.println(str);
    }
    public void dictionaryBasic(DictionaryManagement dictionaryManagement, Dictionary dictionary, String path) {
        dictionaryManagement.insertFromFile(path,dictionary);
        showAllWords(dictionaryManagement, dictionary);
    }

    public List<String> dictionarySearcher(DictionaryManagement dictionaryManagement, Dictionary dictionary, String t) {
        List<String> list = dictionaryManagement.trie.searchWithPrefix(t);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            result.add(list.get(i));
        }
        return result;
    }


    public void dictionaryAdvanced(DictionaryManagement dictionaryManagement, Dictionary dictionary, String path) {
        while (true) {
            System.out.println("Welcome to My Application!");
            System.out.println("[0] Exit");
            System.out.println("[1] Add");
            System.out.println("[2] Remove");
            System.out.println("[3] Update");
            System.out.println("[4] Display");
            System.out.println("[5] Lookup");
            System.out.println("[6] Search");
            System.out.println("[7] Game");
            System.out.println("[8] Import from file");
            System.out.println("[9] Export to file");
            System.out.println("Your action:");
            Scanner sc5 = new Scanner(System.in);
            int choice = sc5.nextInt();
            if (choice == 0) {
                break;
            }
            else if (choice == 1) {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Nhập từ tiếng anh: ");
                String eng = sc1.nextLine();
                System.out.println("Nhập từ tiếng việt: ");
                String vie = sc1.nextLine();
                dictionaryManagement.dictionaryAdd(dictionary, eng, vie, path);
            }
            else if (choice == 2) {
                Scanner sc3 = new Scanner(System.in);
                System.out.println("Nhập từ tiếng anh cần xóa: ");
                String eng = sc3.nextLine();
                dictionaryManagement.dictionaryRemove(dictionary, eng, path);
            }
            else if (choice == 3) {
                Scanner sc2 = new Scanner(System.in);
                System.out.println("Nhập từ tiếng anh cần sửa: ");
                String eng = sc2.nextLine();
                System.out.println("Nhập từ tiếng việt sửa thành: ");
                String vie = sc2.nextLine();
                System.out.println("[1] Thêm");
                System.out.println("[2] Sửa");
                int total = sc2.nextInt();
                if (total == 1) dictionaryManagement.dictionaryUpdate_add(dictionary, eng, vie, path);
                else dictionaryManagement.dictionaryUpdate_replace(dictionary, eng, vie, path);
            }
            else if (choice == 4) {
                showAllWords(dictionaryManagement, dictionary);
            }
            else if (choice == 5) {
                Scanner sc0 = new Scanner(System.in);
                System.out.println("Nhập từ tiếng anh cần tìm: ");
                String t = sc0.next();
                System.out.println(dictionaryManagement.dictionaryLookup(t));
            }
            else if (choice == 6) {
                Scanner sc0 = new Scanner(System.in);
                System.out.println("Nhập tiền tố của từ: ");
                String eng = sc0.next();
                System.out.println(dictionarySearcher(dictionaryManagement, dictionary, eng));
            }
            else if (choice == 7) {
                ListQuestion listQuestion = new ListQuestion();
                listQuestion.insertFromFile();
                for (int i =0 ; i< listQuestion.size(); i++) {
                    Question q = listQuestion.get(i);
                    System.out.println(q.getContent());
                    System.out.println(q.getChoices().get(0));
                    System.out.println(q.getChoices().get(1));
                    System.out.println(q.getChoices().get(2));
                    System.out.println(q.getChoices().get(3));
                    Scanner sc0 = new Scanner(System.in);
                    String c = sc0.next();
                    switch (q.getAnswer()) {
                        case "A" -> {
                            if (c.equals("A")) {
                                System.out.println("Đúng!");
                            } else {
                                System.out.println("Sai!");
                            }
                        }
                        case "B" -> {
                            if (c.equals("B")) {
                                System.out.println("Đúng!");
                            } else {
                                System.out.println("Sai!");
                            }
                        }
                        case "C" -> {
                            if (c.equals("C")) {
                                System.out.println("Đúng!");
                            } else {
                                System.out.println("Sai!");
                            }
                        }
                        case "D" -> {
                            if (c.equals("D")) {
                                System.out.println("Đúng!");
                            } else {
                                System.out.println("Sai!");
                            }
                        }
                    }
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("[1] Thoát khỏi Game");
                    System.out.println("[2] Làm lại");
                    System.out.println("[3] Câu tiếp");
                    int x = sc1.nextInt();
                    if ( x == 1) break;
                    else if (x == 2) i--;
                }
            }
            else if (choice == 8) {
                dictionaryManagement.insertFromFile(path, dictionary);
            }
            else if (choice == 9) {
                dictionaryManagement.dictionaryExportToFile(path, dictionary);
            }
            else {
                System.out.println("Action not supported");
                break;
            }
        }
    }
}

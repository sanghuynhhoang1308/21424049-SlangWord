/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg21424049_slangword;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Huynh Hoang Sang
 */
public class SlangWordDetail {

    private static SlangWordDetail obj = new SlangWordDetail();
    private TreeMap<String, List<String>> map = new TreeMap<>();
    private int sizeMap;
    private String file_slangword = "slang.txt";
    private String file_slangwordedit = "slangedit.txt";
    private String fils_historyfind = "historyfind.txt";

    private SlangWordDetail() {
        try {
            String current = new java.io.File(".").getCanonicalPath();
            System.out.println("Current dir:" + current);
            file_slangword = current + "\\" + file_slangword;
            file_slangwordedit = current + "\\" + file_slangwordedit;
            fils_historyfind = current + "\\" + fils_historyfind;
            readFile(file_slangword);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static SlangWordDetail getInstance() {
        if (obj == null) {
            synchronized (SlangWordDetail.class) {
                if (obj == null) {
                    SlangWordDetail obj = new SlangWordDetail();
                }
            }
        }
        return obj;
    }

    void readFile(String file) throws Exception {
        map.clear();
        String slang = null;
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter("`");
        scanner.next();
        String temp = scanner.next();
        String[] part = temp.split("\n");
        int i = 0;
        int flag = 0;
        sizeMap = 0;
        while (scanner.hasNext()) {
            List<String> meaning = new ArrayList<String>();
            slang = part[1].trim();
            temp = scanner.next();
            part = temp.split("\n");
            if (map.containsKey(slang)) {
                meaning = map.get(slang);
            }
            if (part[0].contains("|")) {
                System.out.println(part[0]);
                String[] d = (part[0]).split("\\|");
                for (int ii = 0; ii < d.length; ii++) {
                    System.out.println(d[ii]);
                }
                Collections.addAll(meaning, d);
                sizeMap += d.length - 1;
            } else {
                meaning.add(part[0]);
            }
            // map.put(slang.trim(), meaning);
            map.put(slang, meaning);
            i++;
            sizeMap++;
        }
        scanner.close();
    }

    void luuFile(String file) {
        try {
            PrintWriter printWriter = new PrintWriter(new File(file));
            StringBuilder strbuild = new StringBuilder();

            strbuild.append("Slag`Meaning\n");
            String slang[][] = new String[map.size()][3];
            Set<String> keySet = map.keySet();
            Object[] arraytemp = keySet.toArray();
            for (int i = 0; i < map.size(); i++) {
                Integer in = i + 1;
                slang[i][0] = in.toString();
                slang[i][1] = (String) arraytemp[i];
                List<String> meaning = map.get(arraytemp[i]);
                strbuild.append(slang[i][1] + "`" + meaning.get(0));
                for (int j = 1; j < meaning.size(); j++) {
                    strbuild.append("|" + meaning.get(j));
                }
                strbuild.append("\n");
            }

            printWriter.write(strbuild.toString());
            printWriter.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public String[][] getData() {
        String slang[][] = new String[sizeMap][3];
        Set<String> slangListSet = map.keySet();
        Object[] slangList = slangListSet.toArray();
        int index = 0;
        for (int i = 0; i < sizeMap; i++) {
            slang[i][0] = String.valueOf(i);
            slang[i][1] = (String) slangList[index];
            List<String> meaning = map.get(slangList[index]);
            slang[i][2] = meaning.get(0);

            for (int j = 1; j < meaning.size(); j++) {
                if (i < sizeMap) {
                    i++;
                }
                slang[i][0] = String.valueOf(i);
                slang[i][1] = (String) slangList[index];
                slang[i][2] = meaning.get(j);

            }
            index++;
        }
        return slang;
    }

    public String[] RandomSlang() {
        // Random a number
        int minimun = 0;
        int maximun = map.size() - 1;
        int rmath = randommath(minimun, maximun);
        // Get slang meaning
        String s[] = new String[2];
        int index = 0;
        for (String key : map.keySet()) {
            // System.out.println(key);
            if (index == rmath) {
                s[0] = key;
                s[1] = map.get(key).get(0);
                break;
            }
            index++;
        }
        return s;
    }

    public static int randommath(int minimum, int maximum) {
        return (minimum + (int) (Math.random() * maximum));
    }

    String[][] setText(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void delete(String slang, String value) {
        List<String> mean = map.get(slang);
        int index = mean.indexOf(value);
        if (mean.size() == 1) {
            map.remove(slang);
        } else {
            mean.remove(index);
            map.put(slang, mean);
        }
        sizeMap--;
        this.luuFile(file_slangwordedit);
    }
    public void add(String slang, String meaning) {
		List<String> mean = new ArrayList<>();
		mean.add(meaning);
		sizeMap++;
		map.put(slang, mean);
		this.luuFile(file_slangwordedit);
	}
    public String[][] getMean(String key) {
        
		List<String> lstMean = map.get(key);
		if (lstMean == null)
			return null;
		int size = lstMean.size();
		String s[][] = new String[size][3];
		for (int i = 0; i < size; i++) {
			s[i][0] = String.valueOf(i);
			s[i][1] = key;
			s[i][2] = lstMean.get(i);
		}
		return s;
	}
    public String[][] defintion(String query) {
		
		List<String> keyList = new ArrayList<>();
		List<String> listmean = new ArrayList<>();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			List<String> meaning = entry.getValue();
			for (int i = 0; i < meaning.size(); i++) {
				if (meaning.get(i).toLowerCase().contains(query.toLowerCase())) {
					keyList.add(entry.getKey());
					listmean.add(meaning.get(i));
				}
			}
		}
		int size = keyList.size();
		String slang[][] = new String[size][3];

		for (int i = 0; i < size; i++) {
			slang[i][0] = String.valueOf(i);
			slang[i][1] = keyList.get(i);
			slang[i][2] = listmean.get(i);
		}
		return slang;
	}
    public void reset() {
		try {
			readFile(file_slangword);
			this.luuFile(file_slangwordedit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
     public void edit(String slang, String value)  {
        
        List<String> mean = map.get(slang);
        int index = mean.indexOf(value);
        if (mean.size() == 1) {
            map.get(slang);
        } else {
            mean.get(index);
            map.put(slang, mean);
        }
        
        this.luuFile(file_slangwordedit);
        
    }
     
     
     
      public void edittest(String slang, String value)  {
        
        List<String> mean = map.get(slang);
        int index = mean.indexOf(value);
        if (mean.size() == 1) {
            map.get(slang);
        } else {
            mean.get(index);
            map.put(slang, mean);
        }
        
        this.luuFile(file_slangwordedit);
        
    }
      public void saveHistoryFind(String slag, String meaning) throws Exception {
		File filehistory = new File(fils_historyfind);
		FileWriter fr = new FileWriter(filehistory, true);
		fr.write(slag + "`" + meaning + "\n");
		fr.close();
	}

      public String[][] readHistoryFind() {
		List<String> historySlang = new ArrayList<>();
		List<String> historyMean = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(new File(fils_historyfind));
			scanner.useDelimiter("`");
			String temp = scanner.next();
			String[] part = scanner.next().split("\n");
			historySlang.add(temp);
			historyMean.add(part[0]);
			while (scanner.hasNext()) {
				temp = part[1];
				part = scanner.next().split("\n");
				historySlang.add(temp);
				historyMean.add(part[0]);
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int size = historySlang.size();
		String s[][] = new String[size][3];
		for (int i = 0; i < size; i++) {
			s[size - i - 1][0] = String.valueOf(size - i);
			s[size - i - 1][1] = historySlang.get(i);
			s[size - i - 1][2] = historyMean.get(i);
		}
		return s;
	}
      public String[] quizSlang(int type) {
		String s[] = new String[6];
		if (type == 1) {
			// Random a number
			String[] slangRandom = this.RandomSlang();
			s[0] = slangRandom[0];
			int rand = randommath(1, 4);
			s[rand] = slangRandom[1];
			s[5] = slangRandom[1];
			for (int i = 1; i <= 4; i++) {
				if (rand == i)
					continue;
				else {
					String[] slangRand = this.RandomSlang();
					while (slangRand[0] == s[0]) {
						slangRand = this.RandomSlang();
					}
					s[i] = slangRand[1];
				}
			}
		} else {
			// Random a number
			String[] slangRandom = this.RandomSlang();
			s[0] = slangRandom[1];
			int rand = randommath(1, 4);
			s[rand] = slangRandom[0];
			s[5] = slangRandom[0];
			for (int i = 1; i <= 4; i++) {
				if (rand == i)
					continue;
				else {
					String[] slangRand = this.RandomSlang();
					while (slangRand[0] == s[0]) {
						slangRand = this.RandomSlang();
					}
					s[i] = slangRand[0];
				}
			}
		}

		return s;
	}
     
}

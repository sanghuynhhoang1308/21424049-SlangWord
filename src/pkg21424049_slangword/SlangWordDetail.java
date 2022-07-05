/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg21424049_slangword;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    private SlangWordDetail() {
        try {
            String current = new java.io.File(".").getCanonicalPath();
            System.out.println("Current dir:" + current);
            file_slangword = current + "\\" + file_slangword;

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
        String slag = null;
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
            slag = part[1].trim();
            temp = scanner.next();
            part = temp.split("\n");
            if (map.containsKey(slag)) {
                meaning = map.get(slag);
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
            // map.put(slag.trim(), meaning);
            map.put(slag, meaning);
            i++;
            sizeMap++;
        }
        scanner.close();
    }

    public String[][] getData() {
        String slang[][] = new String[sizeMap][3];
        Set<String> slagListSet = map.keySet();
        Object[] slagList = slagListSet.toArray();
        int index = 0;
        for (int i = 0; i < sizeMap; i++) {
            slang[i][0] = String.valueOf(i);
            slang[i][1] = (String) slagList[index];
            List<String> meaning = map.get(slagList[index]);
            slang[i][2] = meaning.get(0);

            for (int j = 1; j < meaning.size(); j++) {
                if (i < sizeMap) {
                    i++;
                }
                slang[i][0] = String.valueOf(i);
                slang[i][1] = (String) slagList[index];
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
}

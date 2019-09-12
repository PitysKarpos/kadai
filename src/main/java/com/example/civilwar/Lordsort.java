package com.example.civilwar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lordsort {
	private String lt;
	private String lord;

	public void sort(int i, int i2, int i3) {

		List<String> list = new ArrayList<>();
		Collections.addAll(list, "真田幸村", "武田信玄", "徳川家康", "黒田官兵衛", "伊達政宗", "片倉景綱(小十郎)", "石田三成", "毛利元就");
		Lordtext lordtext = new Lordtext();

		if (i == 1) {
			if (i2 == 1) {
				if (i3 == 1) {
					lord = list.get(0);
					lordtext.setSanada();
					lt = lordtext.getSanada();
				} else {
					lord = list.get(1);
					lordtext.setTakeda();
					lt = lordtext.getTakeda();
				}
			} else {
				if (i3 == 1) {
					lord = list.get(2);
					lordtext.setIeyasu();
					lt = lordtext.getIeyasu();
				} else {
					lord = list.get(3);
					lordtext.setKuroda();
					lt = lordtext.getKuroda();
				}
			}

		} else {
			if (i2 == 1) {
				if (i3 == 1) {
					lord = list.get(4);
					lordtext.setDate();
					lt = lordtext.getDate();
				} else {
					lord = list.get(5);
					lordtext.setKatakura();
					lt = lordtext.getKatakura();
				}
			} else {
				if (i3 == 1) {
					lord = list.get(6);
					lordtext.setIshida();
					lt = lordtext.getIshida();
				} else {
					lord = list.get(7);
					lordtext.setMouri();
					lt = lordtext.getMouri();
				}
			}
		}
	}

	public String lord() {
		return lord;
	}

	public String lt() {
		return lt;
	}
}

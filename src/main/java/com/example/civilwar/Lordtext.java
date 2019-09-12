package com.example.civilwar;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lordtext {

	private Map<String, String> selectMap = new LinkedHashMap<String, String>();
	private Map<String, String> selectMap2 = new LinkedHashMap<String, String>();
	private Map<String, String> selectMap3 = new LinkedHashMap<String, String>();

	private String sanada;
	private String ieyasu;
	private String kuroda;
	private String takeda;
	private String date;
	private String ishida;
	private String mouri;
	private String katakura;

	LordCommentary lc = new LordCommentary();

	public void putRadio() {
		selectMap.put("1", "熱血");
		selectMap.put("0", "クール");
	}

	public void putRadio2() {
		selectMap2.put("0", "頭");
		selectMap2.put("1", "体");
	}

	public void putRadio3() {
		selectMap3.put("0", "はい");
		selectMap3.put("1", "いいえ");
	}

	public Map<String, String> getRadio() {
		return selectMap;
	}

	public Map<String, String> getRadio2() {
		return selectMap2;
	}

	public Map<String, String> getRadio3() {
		return selectMap3;
	}

	public String getSanada() {
		return sanada;
	}

	public void setSanada() {
		lc.sanada();
		this.sanada = lc.name();
	}

	public String getIeyasu() {
		return ieyasu;
	}

	public void setIeyasu() {
		lc.ieyasu();
		this.ieyasu = lc.name();
	}

	public String getKuroda() {
		return kuroda;
	}

	public void setKuroda() {
		lc.kuroda();
		this.kuroda = lc.name();
	}

	public String getTakeda() {
		return takeda;
	}

	public void setTakeda() {
		lc.takeda();
		this.takeda = lc.name();
	}

	public String getDate() {
		return date;
	}

	public void setDate() {
		lc.date();
		this.date = lc.name();
	}

	public String getIshida() {
		return ishida;
	}

	public void setIshida() {
		lc.ishida();
		this.ishida = lc.name();
	}

	public String getMouri() {
		return mouri;
	}

	public void setMouri() {
		lc.mouri();
		this.mouri = lc.name();
	}

	public String getKatakura() {
		return katakura;
	}

	public void setKatakura() {
		lc.katakura();
		this.katakura = lc.name();
	}

}

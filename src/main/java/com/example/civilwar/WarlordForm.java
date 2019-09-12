package com.example.civilwar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class WarlordForm {
	private int id;
	@NotNull
	@Size(min = 1, max = 30)
	private String name;
	@NotNull
	@Size(max = 140) // n文字数の制限は@Sizeをつける
	private String text;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

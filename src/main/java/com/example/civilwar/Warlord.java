package com.example.civilwar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

@Entity // @EntityをつけることでDBのテーブルと紐づく
@Table(name = "date")
public class Warlord {
	@Id // @Idを付けた変数がテーブルのプライマーキーになる
	@GeneratedValue(strategy = GenerationType.AUTO) // @GeneratedValueをつけると連番が自動で振られるようになる
	// entityにバリデーションの設定を追加する
	@Column(name = "id")
	private int id;
//	@NotEmpty // @NotEmptyをつけるとnullと空文字を許容しなくなる
	@Column(name = "name")
	private String name;
	@Column(name = "text")
	private String text;

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

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

//	@Override
//	public String toString() {
//		return "Warlord [id=" + id + ", name=" + name + ", text=" + text + "]";
//	}

}

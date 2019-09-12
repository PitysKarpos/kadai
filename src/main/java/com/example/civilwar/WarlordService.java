package com.example.civilwar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class WarlordService implements RowMapper<List<Warlord>> {
	@Autowired
	private WarlordRepository warlordRepository;
	private List<Warlord> list = new ArrayList<>();

//	public List<Warlord> findAll() {
//		return warlordRepository.findAll();
//	}

//	public Warlord findOne(Long id) {
//		// mメソッド名がfindOneからfindByIdに変わった
//		// Optionalを返すようになったので取得できなかった場合の処理`.orElse(null)`を追加
//		return warlordRepository.findById(id).orElse(null);
//	}

//	public Warlord save(Warlord warlord) {
//		return warlordRepository.save(warlord);
//	}

	public Warlord saveRadio(Warlord lordRadio) {
		return warlordRepository.save(lordRadio);
	}

//	public void delete(Long id) {
//		warlordRepository.deleteById(id);
//	}

	public List<Warlord> mapRow(ResultSet rs, int rowNum) throws SQLException {
		Warlord tmp_user = new Warlord();
		tmp_user.setId(rs.getInt("id"));
		tmp_user.setName(rs.getString("name"));
		tmp_user.setText(rs.getString("text"));
		list.add(tmp_user);
		while (rs.next()) {
			Warlord user = new Warlord();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setText(rs.getString("text"));
			list.add(user);
		}
		return list;
	}
}

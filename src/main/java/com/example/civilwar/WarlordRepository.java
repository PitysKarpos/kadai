package com.example.civilwar;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.civilwar.Warlord;

@Repository
public interface WarlordRepository extends JpaRepository<Warlord, Long> {
	public List<Warlord> findById(int id);
}

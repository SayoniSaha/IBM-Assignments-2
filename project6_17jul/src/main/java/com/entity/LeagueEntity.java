package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "league_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LeagueEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int leagueId;
	private int year;
	private String season;
	private String title;
	public LeagueEntity(int year, String season, String title) {
		super();
		this.year = year;
		this.season = season;
		this.title = title;
	}
}

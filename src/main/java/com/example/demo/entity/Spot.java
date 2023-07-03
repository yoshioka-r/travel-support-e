package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "spots")
public class Spot{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Getter
		private Integer id; // ID

		@Getter
		@Column(name="pref_id")
		private Integer prefId;
		
		@Getter
		private String img; 
		
		@Getter
		private String name; 
		 
		@Getter
		private String location; 


		@Getter
		private String outline; 
		

		// コンストラクタ
		public Spot() {
			
		}

		public Spot(Integer prefId,String img, String name, String location, String outline) {
			this.prefId = prefId;
			this.img = img;
			this.name = name;
			this.location = location;
			this.outline = outline;
		}
		
}

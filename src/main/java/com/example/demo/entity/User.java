package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "users")
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Getter
		private Integer id; // ID

		@Getter
		private String name; // 名前

		@Getter
		private String address; // 住所

		@Getter
		private String tel; // 電話番号

		@Getter
		private String email; // メールアドレス
		
		@Getter
		private String password;

		// コンストラクタ
		public User() {
			
		}

		public User(String name, String address, String tel, String email, String password) {
			this.name = name;
			this.address = address;
			this.tel = tel;
			this.email = email;
			this.password = password;
		}
		
}

package com.tfseven.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Address {
		
		private Integer id;
		@NotNull
		private String city;
		@NotNull
		private String state;
		@NotNull
		private String country;

		private Employee user;
		private Phone myPhone;

		public Address() {
			// TODO Auto-generated constructor stub
		}

		public Address(String city, String state, String country) {
			super();
			this.city = city;
			this.state = state;
			this.country = country;
		}

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		@Column(length = 20)
		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		@Column(length = 20)
		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		@Column(length = 20)
		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		@OneToOne
		@JoinColumn(name="user_id")
		public Employee getUser() {
			return user;
		}

		public void setUser(Employee user) {
			this.user = user;
		}
		
		@Embedded
		public Phone getMyPhone() {
			return myPhone;
		}

		public void setMyPhone(Phone myPhone) {
			this.myPhone = myPhone;
		}

		

		@Override
		public String toString() {
			return "RegUserAddress [id=" + id + ", city=" + city + ", state=" + state + ", country=" + country
					+ ", user=" + user + ", myPhone=" + myPhone + "]";
		}

		
	}



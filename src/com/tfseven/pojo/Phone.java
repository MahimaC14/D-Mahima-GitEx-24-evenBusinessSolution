package com.tfseven.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Embeddable //mandatory
public class Phone {


		@NotNull
		private String type;
		@NotNull
		private long number;
		
		public Phone() {
			// TODO Auto-generated constructor stub
		}
		public Phone(String type, long number) {
			super();
			this.type = type;
			this.number = number;
		}
		@Column(length=15)
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		@Column(name="phone_no")
		public long getNumber() {
			return number;
		}
		public void setNumber(long number) {
			this.number = number;
		}
		@Override
		public String toString() {
			return "Phone [type=" + type + ", number=" + number + "]";
		}
		

	}



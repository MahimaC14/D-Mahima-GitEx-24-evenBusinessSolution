	package com.tfseven.pojo;

	import javax.validation.constraints.NotNull;

	import org.hibernate.validator.constraints.NotEmpty;
	import org.hibernate.validator.constraints.Range;




	public class BankAccountClient {
		@NotNull(message="Bank Account ID must be supplied")
		private Integer acctId;
		@NotEmpty(message="PIN must be supplied")
		private String pin;
		@NotEmpty(message="Type must be supplied")
		private String type;
		@NotNull
		@Range(min=1000)
		private double balance;
		

		public BankAccountClient() {
			System.out.println("bank acct cnstr");
		}

		public BankAccountClient(String type, double balance) {
			super();
			this.type = type;
			this.balance = balance;
		}
		public Integer getAcctId() {
			return acctId;
		}

		public void setAcctId(Integer acctId) {
			this.acctId = acctId;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}


		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}
		public String getPin() {
			return pin;
		}

		public void setPin(String pin) {
			this.pin = pin;
		}

		@Override
		public String toString() {
			return acctId + " type=" + type + " balance=" + balance;
		}

		

	}



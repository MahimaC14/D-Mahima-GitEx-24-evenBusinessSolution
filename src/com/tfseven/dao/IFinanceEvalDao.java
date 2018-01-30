package com.tfseven.dao;

import com.tfseven.pojo.Accounts;
import com.tfseven.pojo.SalaryInfo;

public interface IFinanceEvalDao {

	void calSalary(SalaryInfo sal);
	void calExpenditure(int prodID);
	void calProfitLoss(int prodID);
	String transferAmt(int sourceAccID, int destAccID, double balance);
	void addAccount(Accounts acc);
	String removeAccount(int accID);
}

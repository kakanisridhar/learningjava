package com.mridasoft.learning.beans;

import java.util.ArrayList;
import java.util.List;

import com.mridasoft.learning.concurrency.Car;

public class MaxLonCalculator {
	
	public List<AbstractSecurity> load() {
		
		ArrayList<AbstractSecurity> loans = new ArrayList<AbstractSecurity>();
		
		loans.add(new Bond(2));
		loans.add(new Equity());
		loans.add(new DefaultSecurity());
		loans.add(null);
		
		AbstractSecurity a = new Bond(2);
		System.out.println(a.getName());
		
		Bond b = new Bond(1);
		Bond c = new Bond(1);
		Bond d = b;
		int hc = b.hashCode();
		System.out.println(d==b && d.equals(b));//
		
		System.out.println(b.getName("s"));
		
		return loans;
		
	}
	
	public static void main(String[] args) {
		MaxLonCalculator ins = new MaxLonCalculator();
		ins.max(ins.load());
	}
	
	public double max(List<AbstractSecurity> loanList) {
		for(AbstractSecurity sec  :loanList ) {
			if(sec!=null)
				System.out.println(sec.getName());
		}
		
		return 0;
	}

}

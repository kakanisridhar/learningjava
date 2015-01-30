package com.mridasoft.learning.functional;

public class RiskCalculator {

	private int param1 = 1;
	private int param2 = 1;
	private CalcRisk riskCalculator;
	
	public int getParam1() {
		return param1;
	}
	public void setParam1(int param1) {
		this.param1 = param1;
	}
	public int getParam2() {
		return param2;
	}
	public void setParam2(int param2) {
		this.param2 = param2;
	}
	public CalcRisk getRiskCalculator() {
		return riskCalculator;
	}
	public void setRiskCalculator(CalcRisk riskCalculator) {
		this.riskCalculator = riskCalculator;
	}
	
	public int calculate(){
		return riskCalculator.calc(param1, param2);
	}
	
	public int someCalculation(int a, int b) {
		return param1*a + param2*b;
	}
	
	public static int ADD(int a,int b) {
		return a+b;
	}
	
	public static int SUBSTRACT(int a,int b) {
		return a-b;
	}
	
	public static void main(String[] args) {
		RiskCalculator calculator = new RiskCalculator();
		calculator.setParam1(10);
		calculator.setParam2(2);
		calculator.setRiskCalculator(RiskCalculator::ADD);
		System.out.println(calculator.calculate());
		calculator.setRiskCalculator(RiskCalculator::SUBSTRACT);
		System.out.println(calculator.calculate());
		calculator.setRiskCalculator(calculator::someCalculation);
		System.out.println(calculator.calculate());
	}
}

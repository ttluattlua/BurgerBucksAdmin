package bba.com.a.model;

public class Bb_OrderStatisticDto {

	private String period;
	private int profit;
	
	public Bb_OrderStatisticDto() {}

	public Bb_OrderStatisticDto(String period, int profit) {
		super();
		this.period = period;
		this.profit = profit;
	}

	public String getperiod() {
		return period;
	}

	public void setperiod(String period) {
		this.period = period;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "{ period:'" + period + "', profit:" + profit + "} ";
	}
	
	
}

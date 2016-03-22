package objects;

/**
 * 
 * @author Premraj M
 *
 */

public class Discount {
	private String discountCode;
	private String discountType;
	private String description;
	private String startDate;
	private int periodofDiscount;
	private double percentageDiscount;
	

	public Discount(String discountCode,String discountType, String description, 
			String startDate,int periodofDiscount,
			double percentageDiscount) {
		
		this.discountCode=discountCode;
		this.discountType=discountType;
		this.description=description;
		this.percentageDiscount=percentageDiscount;
		this.startDate=startDate;
		this.periodofDiscount=periodofDiscount;
		
	}


	public String getDiscountCode() {
		return discountCode;
	}


	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}


	public String getDiscountType() {
		return discountType;
	}


	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public int getPeriodofDiscount() {
		return periodofDiscount;
	}


	public void setPeriodofDiscount(int periodofDiscount) {
		this.periodofDiscount = periodofDiscount;
	}


	public double getPercentageDiscount() {
		return percentageDiscount;
	}


	public void setPercentageDiscount(double percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}
	

}

package objects;

/**
 * 
 * @author Premraj M
 *
 */

public class Discount {
	private String discountCode;
	
	private String description;
	private String startDate;
	private String periodofDiscount;
	private double percentageDiscount;
	

	public Discount(String discountCode,String description, 
			String startDate,String periodofDiscount,
			double percentageDiscount) {
		
		this.discountCode=discountCode;
		
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


	public String getPeriodofDiscount() {
		return periodofDiscount;
	}


	public void setPeriodofDiscount(String periodofDiscount) {
		this.periodofDiscount = periodofDiscount;
	}


	public double getPercentageDiscount() {
		return percentageDiscount;
	}


	public void setPercentageDiscount(double percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		int id = Integer.parseInt(getDiscountCode().substring(0, 4));
		result = prime * result + id;
		return result;
	}
	
	public boolean equals(Object discount) {
    	if (discount instanceof Discount) {
    		Discount dis = (Discount) discount;
    		if (this.getDiscountCode().equals(dis.getDiscountCode()))
    			if (this.getDescription().equals(dis.getDescription()))
    				if(this.getDiscountType().equals(dis.getDiscountType()))
    					if(this.getPercentageDiscount() == (dis.getPercentageDiscount()))
    						if(this.getStartDate().equals(dis.startDate))
    							if(this.getPeriodofDiscount() == dis.getPeriodofDiscount())
    								return true;
    		else return false;
    	}
    	return false;
    }
}

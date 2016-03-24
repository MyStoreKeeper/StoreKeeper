package objects;

/**
 * 
 * @author Premraj M
 *
 */
public class Category {
	
	private String name;
	private String code;

	public Category(String tname,String tcode) {
		this.name=tname;
		this.code=tcode;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getCode(){
		return code;
	}
	public void setCode(String code){
		this.code=code;
	}
	
	public boolean equals(Object category) {
    	if (category instanceof Category) {
    		Category cat = (Category) category;
    		if (this.getName().equals(cat.getName()))
    			if (this.getCode().equals(cat.getCode()))
    				return true;
    		else return false;
    	}
    	return false;
    }
}

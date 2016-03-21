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
	
}

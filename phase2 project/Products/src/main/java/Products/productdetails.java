package Products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productdetails")
public class productdetails {

	@Id
	@Column(name="p_id")
	private int p_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private int price;
	
	productdetails(){
		
	}

	public productdetails(int p_id, String name, int price) {
		super();
		this.p_id = p_id;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", name=" + name + ", price=" + price + "]";
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
		
}

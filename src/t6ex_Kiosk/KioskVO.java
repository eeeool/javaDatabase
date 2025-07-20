package t6ex_Kiosk;

public class KioskVO {
	private String part, product, detail, content, image;
	private int idx, calorie, price;
	
	public KioskVO() {}
	
	public KioskVO(int idx, String part, String product, String detail, String content, int calorie, String image, int price) {
        this.idx = idx;
        this.part = part;
        this.product = product;
        this.detail = detail;
        this.content = content;
        this.calorie = calorie;
        this.image = image;
        this.price = price;
    }
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getCalorie() {
		return calorie;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return product;
	}
}

package bean;

public class Hoa {
	private int idHoa;
	private String tenHoa;
	private int giaBan;
	private int soLuong;

	public Hoa() {

	}

	public Hoa(int idHoa, String tenHoa, int giaBan, int soLuong) {
		super();
		this.idHoa = idHoa;
		this.tenHoa = tenHoa;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
	}

	public int getIdHoa() {
		return idHoa;
	}

	public void setIdHoa(int idHoa) {
		this.idHoa = idHoa;
	}

	public String getTenHoa() {
		return tenHoa;
	}

	public void setTenHoa(String tenHoa) {
		this.tenHoa = tenHoa;
	}

	public int getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String toString() {
		return "ID hoa: " + this.idHoa + "\nTên hoa: " + this.tenHoa + "\nGiá bán: " + this.giaBan + "\nSố lượng: "
				+ this.soLuong;
	}

}

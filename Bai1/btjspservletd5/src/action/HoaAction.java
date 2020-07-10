package action;

import java.util.ArrayList;
import java.util.Scanner;

import bean.Hoa;
import exception.NumberException;

public class HoaAction {
	public ArrayList<Hoa> inputHoa(ArrayList<Hoa> list) {
		Scanner sc = new Scanner(System.in);
		int idHoa = 0, giaBan = 0, soLuong = 0;
		String tenHoa = "";
		boolean check = true;
		System.out.println("======== NHẬP THÔNG TIN HOA ========");
		while (true) {
			while (true) {
				try {
					System.out.print("Nhập id hoa: ");
					idHoa = Integer.parseInt(sc.nextLine());
					if (idHoa <= 0) {
						throw new NumberException("Vui lòng nhập id > 0!");
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("Vui lòng nhập đúng định dạng số!");
				} catch (NumberException e) {
					System.out.println(e.getMessage());
				}
			}

			System.out.print("Nhập tên hoa: ");
			tenHoa = sc.nextLine();

			while (true) {
				try {
					System.out.print("Nhập giá bán: ");
					giaBan = Integer.parseInt(sc.nextLine());
					if (giaBan <= 0) {
						throw new NumberException("Vui lòng nhập giá bán > 0!");
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("Vui lòng nhập đúng định dạng số!");
				} catch (NumberException e) {
					System.out.println(e.getMessage());
				}
			}

			while (true) {
				try {
					System.out.print("Nhập số lượng: ");
					soLuong = Integer.parseInt(sc.nextLine());
					if (soLuong <= 0) {
						throw new NumberException("Vui lòng nhập số lượng > 0!");
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("Vui lòng nhập đúng định dạng số!");
				} catch (NumberException e) {
					System.out.println(e.getMessage());
				}
			}

			if (list.size() > 0) {
				if (checkID(list, idHoa) && checkName(list, tenHoa)) {
					if (checkGiaBan(list, giaBan)) {
						for (Hoa hoa : list) {
							if (hoa.getIdHoa() == idHoa) {
								hoa.setSoLuong(hoa.getSoLuong() + soLuong);
								check = false;
								break;
							}
						}
						break;
					} else {
						System.out.println("Thông tin ID trùng không khớp, vui lòng nhập lại!");
					}
				} else if (!checkID(list, idHoa) && !checkName(list, tenHoa)) {
					check = true;
					break;
				} else {
					System.out.println("Thông tin ID trùng không khớp, vui lòng nhập lại!");
				}
			} else {
				check = true;
				break;
			}

		}
		
		if (check) {
			Hoa objHoa = new Hoa(idHoa, tenHoa, giaBan, soLuong);
			list.add(objHoa);
		}
		return list;
	}

	public static boolean checkID(ArrayList<Hoa> list, int id) {
		if (list.size() > 0) {
			for (Hoa hoa : list) {
				if (hoa.getIdHoa() == id) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	public static boolean checkName(ArrayList<Hoa> list, String name) {
		if (list.size() > 0) {
			for (Hoa hoa : list) {
				if (hoa.getTenHoa().equalsIgnoreCase(name)) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	public static boolean checkGiaBan(ArrayList<Hoa> list, int giaBan) {
		if (list.size() > 0) {
			for (Hoa hoa : list) {
				if (hoa.getGiaBan() == giaBan) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	public void toString1() {
		System.out.printf("%-10s%-20s%-15s%s\n", "ID hoa", "Tên hoa", "Giá bán", "Số lượng");
	}

	public void displayHoa(ArrayList<Hoa> list) {
		if (list.size() > 0) {
			System.out.println("======== DANH SÁCH HOA ========");
			toString1();
			for (Hoa hoa : list) {
				System.out.printf("%-10s%-20s%-15s%s\n", hoa.getIdHoa(), hoa.getTenHoa(), hoa.getGiaBan(),
						hoa.getSoLuong());
			}
		} else {
			System.out.println("Chưa có dữ liệu hoa!");
		}
	}

	public void displayHoaSoLuong(ArrayList<Hoa> list) {
		if (list.size() > 0) {
			ArrayList<Hoa> listHoa = new ArrayList<Hoa>();
			int dem = 0;
			for (Hoa hoa : list) {
				if (hoa.getSoLuong() > 10) {
					dem++;
					listHoa.add(hoa);
				}
			}
			if (dem == 0) {
				System.out.println("Không có hoa có số lượng > 10!");
			} else {
				System.out.println("======== DANH SÁCH HOA CÓ SỐ LƯỢNG > 10 ========");
				toString1();
				for (Hoa hoa : listHoa) {
					System.out.printf("%-10s%-20s%-15s%s\n", hoa.getIdHoa(), hoa.getTenHoa(), hoa.getGiaBan(),
							hoa.getSoLuong());
				}
			}
		} else {
			System.out.println("Chưa có dữ liệu hoa!");
		}
	}

	public void displayHoaGiaBan(ArrayList<Hoa> list) {
		if (list.size() > 0) {
			ArrayList<Hoa> listHoa = new ArrayList<Hoa>();
			int dem = 0;
			for (Hoa hoa : list) {
				if (hoa.getGiaBan() < 10000) {
					dem++;
					listHoa.add(hoa);
				}
			}
			if (dem == 0) {
				System.out.println("Không có hoa có giá bán < 10000!");
			} else {
				System.out.println("======== DANH SÁCH HOA CÓ GIÁ BÁN < 10000 ========");
				toString1();
				for (Hoa hoa : listHoa) {
					System.out.printf("%-10s%-20s%-15s%s\n", hoa.getIdHoa(), hoa.getTenHoa(), hoa.getGiaBan(),
							hoa.getSoLuong());
				}
			}
		} else {
			System.out.println("Chưa có dữ liệu hoa!");
		}
	}

	public void menu() {
		HoaAction obj = new HoaAction();
		ArrayList<Hoa> list = new ArrayList<Hoa>();
		while (true) {
			System.out.println("======== MENU HOA ========");
			System.out.println("--0. Exit");
			System.out.println("--1. Nhập thông tin hoa");
			System.out.println("--2. In danh sách hoa");
			System.out.println("--3. In danh sách hoa có số lượng > 10");
			System.out.println("--4. In danh sách hoa có giá bán < 10000");
			System.out.println("======== THE END ========");

			int luaChon = 0;
			Scanner input = new Scanner(System.in);
			while (true) {
				try {
					System.out.print("Nhập lựa chọn: ");
					luaChon = Integer.parseInt(input.nextLine());
					if (luaChon < 0 || luaChon > 4) {
						throw new NumberException("Vui lòng nhập lựa chọn từ 0 - 4!");
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("Vui lòng nhập đúng định dạng số!");
				} catch (NumberException e) {
					System.out.println(e.getMessage());
				}
			}

			if (luaChon == 0) {
				System.out.println("GOODBYE!");
				break;
			} else if (luaChon == 1) {
				list = obj.inputHoa(list);
			} else if (luaChon == 2) {
				obj.displayHoa(list);
			} else if (luaChon == 3) {
				obj.displayHoaSoLuong(list);
			} else {
				obj.displayHoaGiaBan(list);
			}
		}
	}
}

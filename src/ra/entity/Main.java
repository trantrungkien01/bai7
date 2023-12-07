package ra.entity;

import java.util.Scanner;

public class Main {
    Product[] arrProduct = new Product[100];
    int currentProductlog = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main objMain = new Main();
        objMain.displayMenuProduct(scanner, objMain);
    }

    public void displayMenuProduct(Scanner scanner, Main objMain) {
        int choice = 0;
        do {
            System.out.println("***********************MENU**************************\n" +
                    "1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)\n" +
                    "2. Hiển thị thông tin các sản phẩm\n" +
                    "3. Sắp xếp các sản phẩm theo lợi nhuận giảm dần\n" +
                    "4. Thống kê các sản phẩm theo giá\n" +
                    "5. Tìm các sản phẩm theo tên sản phẩm\n" +
                    "6. Nhập sản phẩm\n" +
                    "7. Bán sản phẩm\n" +
                    "8. Cập nhật trạng thái sản phẩm\n" +
                    "9. Thoát");
            System.out.println("Mời bạn lựa chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    objMain.inputDataMenu(scanner);
                    break;
                case 2:
                    objMain.displayBook();
                    break;
                case 3:
                    objMain.sortBookByCalProfit();
                    break;
                case 4:
                    objMain.statisBook(scanner);
                    break;
                case 5:
                    objMain.lookForProductByName(scanner);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Mời nhập lựa chọn từ 1-10");
            }
        } while (choice != 9);
    }

    public void inputDataMenu(Scanner scanner) {
        arrProduct[0] = new Product("P001", "Nước uống", 1f, 50f, 49f, 2, "Có gas", true);
        arrProduct[1] = new Product("P002", "Đồ ăn", 8f, 40f, 32f, 5, "Nóng", false);
        arrProduct[2] = new Product("P003", "Ăn vặt", 9f, 100f, 91f, 4, "Bẩn", false);
        arrProduct[3] = new Product("P004", "Buffet", 7f, 70f, 63f, 6, "Gía rẻ", true);
        currentProductlog = 4;
    }

    public void displayBook() {
        System.out.println("Thống kê sản phẩm: ");
        for (int i = 0; i < currentProductlog; i++) {
            arrProduct[i].displayData();
            System.out.println("\n----------------------------------------------------");
        }
    }

    public void sortBookByCalProfit() {
        sortByCalProfit(arrProduct, currentProductlog);
    }

    public void sortByCalProfit(Product[] arrProduct, int currentProductlog) {
        System.out.println("Đã sắp xếp xong, nhấn 2 để kiểm tra!");
        for (int i = 0; i < currentProductlog - 1; i++) {
            for (int j = i + 1; j < currentProductlog; j++) {
                if (arrProduct[i].getProfit() < arrProduct[j].getProfit()) {
                    Product temp = arrProduct[j];
                    arrProduct[j] = arrProduct[i];
                    arrProduct[i] = temp;
                }
            }
        }
    }

    public void statisBook(Scanner scanner) {
        for (int i = 0; i < currentProductlog; i++) {
            arrProduct[i].statisData(scanner, arrProduct, currentProductlog);
        }
    }

    public void lookForProductByName(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm muốn tìm kiếm:");
        String name = scanner.nextLine();
        System.out.println("Kết quả tìm kiếm:");
        for (int i = 0; i < currentProductlog; i++) {
            if (arrProduct[i].getProductName().contains(name)) {
                arrProduct[i].displayData();
            }
        }
    }
}





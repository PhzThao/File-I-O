package Bai_1;

import java.io.*;

class FileHandler {
    public void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File đã được tạo mới.");
            } else {
                System.out.println("File đã tồn tại.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String fileName, String data) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(data);
            writer.close();
            System.out.println("Dữ liệu đã được ghi vào file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            System.out.println("Dữ liệu trong file:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFilePath(String fileName) {
        File file = new File(fileName);
        return file.getAbsolutePath();
    }

    public boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public void createDirectory(String directoryName) {
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
            System.out.println("Thư mục đã được tạo mới.");
        } else {
            System.out.println("Thư mục đã tồn tại.");
        }
    }
}

public class Phuong_Thuc {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();

        // Tạo file mới
        fileHandler.createFile("example.txt");

        // Ghi dữ liệu vào file
        fileHandler.writeFile("example.txt", "Đây là dữ liệu được ghi vào file.");

        // Đọc file
        fileHandler.readFile("example.txt");

        // Lấy đường dẫn của file
        String filePath = fileHandler.getFilePath("example.txt");
        System.out.println("Đường dẫn của file: " + filePath);

        // Xóa file
        if (fileHandler.deleteFile("example.txt")) {
            System.out.println("File đã được xóa.");
        } else {
            System.out.println("Xóa file không thành công.");
        }

        // Tạo thư mục
        fileHandler.createDirectory("example_directory");
    }
}

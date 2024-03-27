package basic;

import java.util.Scanner;

public class ScannerExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String a = scanner.next(); // 사용자가 "Hello World" 입력

// 여기서 개행 문자('\n')를 처리하지 않고 바로 다음 입력을 받으면 문제가 발생할 수 있습니다.
// String a = scanner.nextLine();

        System.out.print("Enter another string: ");
        String b = scanner.nextLine(); // 여기서 개행 문자를 읽어와서 바로 빈 문자열을 반환할 수 있음

        System.out.println("a: " + a);
        System.out.println("b: " + b);



    }
}

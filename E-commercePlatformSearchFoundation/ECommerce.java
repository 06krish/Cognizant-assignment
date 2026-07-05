import java.util.*;
public class ECommerce {
    public static int binarySearch(String[]product,String key){
        int left  = 0;
        int right = product.length-1;
        while(left<=right){
            int mid = left + (right - left) / 2;
            int result = product[mid].compareToIgnoreCase(key);
            if(result == 0){
                return mid;
            }
            else if(result>0){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[]args){
        String[] products = {
            "Laptop",
            "Mobile",
            "Headphones",
            "Keyboard",
            "Mouse",
            "Monitor",
            "Camera",
            "Speaker"
        };
        Arrays.sort(products,String.CASE_INSENSITIVE_ORDER);
        Scanner sc = new Scanner(System.in);
        System.out.println("Available Products:");
        for(String product:products){
            System.out.println(product);
        }
        System.out.println("Enter the product you want to search:");
        String key = sc.nextLine();
        int idx = binarySearch(products,key);
        if(idx == -1){
            System.out.println("Product not found");
        }else{
            System.out.println("Product found at index: "+idx);
        }
    }
}

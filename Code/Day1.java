import java.util.Scanner;

class Day1 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int height[] = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = in.nextInt();
        }
        System.out.println(trap(height));
        in.close();
    }

    public static int trap(int[] height) {
        int n = height.length;
        int lmax[] = new int[n];
        int rmax[] = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > max)
                max = height[i];
            lmax[i] = max;
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            rmax[i] = max;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return ans;
    }
}
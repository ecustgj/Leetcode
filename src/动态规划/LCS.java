package 动态规划;

import java.util.Arrays;

public class LCS {
    static String ans(int i, int j, int[][] b, String a){
        String res="";
        if(i==0||j==0)
             return res;

        if(b[i][j]==1){
            res+=ans(i-1,j-1,b,a);
            res+=a.charAt(i-1);
        }
        if(b[i][j]==2){
            res+=ans(i,j-1,b,a);

        }
        if(b[i][j]==3){
            res+=ans(i-1,j,b,a);

        }
        return res;



    }
    public static void main(String[] args) {
        String a="1A2C3D4B56";
        String b="111B1D23A456A";
        int len_a=a.length();
        int len_b=b.length();
        int[][] dp=new int[len_a+1][len_b+1];
        int[][] road=new int[a.length()+1][b.length()+1];


        for(int i=1;i<=len_a;i++){
            for(int j=1;j<=len_b;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    //左上
                    road[i][j]=1;
                }
                else{
                    if(dp[i][j-1]>dp[i-1][j]){
                        dp[i][j]=dp[i][j-1];
                        //上
                        road[i][j]=2;
                    }
                    else{
                        dp[i][j]=dp[i-1][j];
                        //左
                        road[i][j]=3;
                    }
                }

            }
        }
        String res=ans(len_a,len_b,road,a);

        System.out.println(dp[len_a][len_b]);
        System.out.println(res);
    }
}

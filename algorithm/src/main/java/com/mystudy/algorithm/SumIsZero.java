package com.mystudy.algorithm;
/**
 * http://www.cnblogs.com/xiaxj/p/7245469.html
 * 问题描述：

求对于长度为N的数组A，求子数组的和接近0的子数组，要求时间复杂度O(NlogN) 

(1) 求出所有的sum[i]  sum[i]表示A的前 i 项和 
(2) 对sum[-1,0,...,N-1]排序，然后计算sum相邻元素的差的绝对值，最小记为 min1   
(3) min1 : 在A中任意取两个相邻子数组的和，求两者差的最小值。(相当于 i——j和的最小值)
(4) min2 : A的前k个元素的和的绝对值的最小值（为sum[0,1....n-1]中的最小值）
(5) min1和min2更小者，即为所求。


 *
 */
public class SumIsZero {
    public static int SumMinIsZero(int[] a, int length){
        int[] sum = new int[length];
        //同时定义sum[-1] = 0;
        //sum[-1] = 0;
        //求前n项的和并且存在sum数组中，在从里面求出绝对值最小的数
        sum[0] = a[0];
        int i;
        //求出所以的sum[i]
        for (i = 1; i < length; i++) {
            sum[i] = sum[i-1]+a[i];
        }
        int min2 = Math.abs(sum[0]);
        for (i = 0; i < sum.length; i++) {
            if (Math.abs(sum[i]) < min2) 
                min2 = Math.abs(sum[i]);
        }
        
        //同时对数组sum做排序
        quickSort(sum, 0, length-1);
        
        //求sum排序之后的相邻元素的最小值min1
        int min1 = Math.abs(sum[0]-sum[1]);
        for (int j = 2; j < sum.length; j++) {
            if (Math.abs(sum[j] - sum[j-1]) <min1) 
                min1 = Math.abs(sum[j] - sum[j-1]);
        }
        return (min1 > min2 ? min2:min1);
    }
    
    public static void quickSort(int[] a, int low,int high){
        int i,j;
        int temp;
        
        i=low;
        j=high;
        temp=a[low];                //取第一个元素为标准数据元素
        //下面的对左边和右边的扫描定位反复进行，直到左边的下标i大于或者等于右边元素的下标为止
        while(i<j){
            //在数组的右边扫描,如果数大于哨兵，则不改变位置,否则将j上的元素马上移动到i位置，
            //并且马上扫描左边
            while( i < j&& a[j]>=temp) j--;
            if (i<j) {
                a[i]=a[j];
                i++;
            }
            
            //在数组的左边扫描,如果数小于哨兵，则不改变位置，否则将左边i处的位置交换到
            //右边j处的位置，并且转回扫描右边
            while( i < j&& a[i] < temp) i++;
            if (i<j) {
                a[j]=a[i];
                j--;
            }
        }
        
        a[i]=temp;
        
        //对左边的子集合做递归查询
        if (low<i) {
            quickSort(a, low, i-1);
        }
        //对右边的子集合做递归查询
        if (i<high) {
            quickSort(a, j+1, high);
        }
    }
    
    public static void main(String[] args) {
    	int[] ss = {-3,1,1,-3,5};
    	int res = SumMinIsZero(ss, ss.length);
    	System.out.println(res);
	}
}

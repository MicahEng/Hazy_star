//Filename:GreedySelector.java
/*活动安排问题，尽量在一段时间中安排的活动数量最多，由结束时间所决定，也就是说
 *在每次活动中，我们尽可能挑时间最短的活动加入到集合，对此每个子集其实是最优，
 *最终求得整体的最优解。
*/
class GreedySelector{
  public static int greedySelector(int s[], int f[]){
      //s 存放活动开始的时间
      //f 存放活动结束的时间，且为非减序列排序
      int n = s.length;
      boolean[] flag = new boolean[n];
      //flag集合，用于判断活动是否加入,输出后元素若为true，表明加入背包。
      flag[1] = true;
      int j = 1;
      //因为结束时间为非减序列，所以在每一段中，结束时间最早的即为最优解
      int count = 1;
      //count记录安排的活动数量
      for(int i = 2; i < n; i++){
        if(s[i] >= f[j]){
          //因为f为非减序列，如果其实时间为上一个时间之后，即可加入安排，为子集最优解
          flag[i] = true;
          j = i;
          count++;
        }else{
          flag[i] = false;
        }
      }
      return count;
  }
  public static void main(String[] args){
    int s[] = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
    int f[] = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    int number = greedySelector(s, f);
    System.out.println("可以安排的活动数量：" + number);
  }
}

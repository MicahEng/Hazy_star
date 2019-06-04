//Filename:Knapsack.java
/*背包问题，在装载一堆货物
 *要求，是的背包中所装载的货物的价值最高。
 *0-1背包问题：在装载一堆货物，要求从全部货物中挑选
 *使得背包中中货物的价值最高。
 *背包问题可以满足贪婪算法的条件，因此可以使用贪婪算法。
 *0-1背包问题则无法使用贪婪算法得到最优解。一般使用动态规划算法。
 */
class Knapsack{
  public static float knapsack(float c, float w[], float v[]){
    int n = v.length;
    //先将单位质量的物品价值进行排序，以构造满足贪婪算法的条件
    float vEU[] = new float[n];
    for(int i = 0; i < n; i++){
      vEU[i] = v[i]/w[i];
    }
    float x[] = new float[n];
    //判断该种物品加入背包的量，1为全部加入
    for(int i = 0; i < n; i++) x[i] = 0;
    //初始化为0，表示背吧为空
    /*排序算法，可以之定义一个继承Comparable的类来直接实现
     *因为这里进行排序涉及到后续比较时候用到的物品价值以及重量，
     *所以选择外部的一个继承类来实现
     */
    float opt = 0;
    //用于存储背包所放物品的总价值
    Element d[] = new Element[n];
    for(int i = 0; i < n; i++)
      d[i] = new Element(w[i], v[i], i);
    //单位价值从高到低排序
    //i 设定为全局，方便在for循环外使用
    for(i = 0; i < n; i++){
      if(d[i].w > c) break;
      x[d[i].i] = 1;
      opt += d[i].v;
      c -= d[i].w;
    }
    if(i < n){
      x[d[i].i] = c/d[i].w;
      opt += x[d[i].i]*d[i].v;
    }
    return opt;



  }
  public static void main(String[] args){
    float C = 50;
    float w[] = {20, 10, 30};
    float v[] = {100, 60, 120};
    float number = knapsack(C, w, v);
    System.out.println("背包中物品的总价值为：" + number);
  }
}

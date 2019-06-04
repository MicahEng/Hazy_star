//Filename:Prim.java
/*与最短路径算法不同的是，Prim算法是生成一个最小生成树，
 *这样用树的边，代表节点与节点之间边以及权值。
 *这样就可以动态从树查找最短路径
 */
class Prim{
  public static void prim(float c[][]){
    int n = c.length;
    float lowcost[] = new float[n];
    int closest[] = new int[n];
    boolean s[] = new boolean[n];
    //lowcost表示源点到顶点的最短路径；closest表示每个顶点的前一个点；s用于标志是否检查过；

    s[1] = true;
    //从第一个点进行最小生成树的建立
    //初始化
    for(int i = 0; i < n; i++){
      lowcost[i] = c[1][i];
      closest[i] = 1;
      s[i] = false;
    }
    for(int i = 0; i < n; i++){
      //通过权值表进行更新
      float min = Float.MAX_VALUE;
      int j = 0;
      //由于数是从第一个开始构建，所以每个查找，进行该起始值的初始化
      for(int k = 1; k < n; k++)
        if((lowcost[k] < min) && (!s[k])){
          min = lowcost[k];
          j = k;
        }
      System.out.println(j + ", " +closest[j]);
      s[j] = true;
      for(int k = 1; k < n; k++)
        if((c[j][k] < lowcost[k]) && (!s[k])){
          lowcost[k] = c[j][k];
          closest[k] = j;
        }
    }
  }
  public static void main(String[] args){
    float max = Float.MAX_VALUE;
    float array[][] = {
      {max, 2, max, max, max, 9, 8},
      {2, max, 7, max, max, max, 3},
      {max, 7, max, 6, max, max, 1},
      {max, max, 6, max, 8, max, 5},
      {max, max, max, 8, max, 4, 3},
      {9, max, max, max, 4, max, 2},
      {8, 3, 1, 5, 3, 2, max},
    };
    prim(array);
  }
}

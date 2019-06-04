//Filename:Dijkstra.java
/*带权有向图，非负权值，求源顶点到其他点的最优路径
 *我们可以使用贪婪算法，先建立一个带权的二维矩阵来表示带权图
 *
 */
class Dijkstra{
  public static void dijkstra(int v, float a[][]){
    int n = a.length;
    float dist[] = new float[n];
    //v 为源顶点，dist[i]用于存储源点到顶点i之间的最短路径的长度
    int prev[] = new int[n];
    //表示顶点i的前一个点
    boolean s[] = new boolean[n];
    //标志这个点是否已经被检测过了

    //初始化
    if(v < 0 || v > n-1) return;//源点不在范围内
    for(int i = 0; i < n; i++){
      dist[i] = a[v][i];
      s[i] = false;
      //初始化都是未检测状态
      if(dist[i] == Float.MAX_VALUE) prev[i] = 0;
      //如果为极大值，将prev置0，表示目前没有前一节点
      else prev[i] = v;
    }
    dist[v] = 0;
    s[v] = true;
    //源点到源点是不用距离的，因此也不需要再次检测
    for(int i = 0; i < n; i++){
      //遍历n次，从源点出发，先对所有其他顶点遍历，找出最短的，并打上检查标志
      float temp = Float.MAX_VALUE;
      int u = v;
      for(int j = 0; j < n; j++)
        if((!s[j]) && (dist[j] < temp)){
          u = j;
          temp = dist[j];
        }
        //这个循环就找出了源点到接下来第一个点的最近的一个点
      s[u] = true;
      //表示这个点已经检测过了
      for(int j = 0; j < n; j++)
        if((!s[j]) && (a[u][j] < Float.MAX_VALUE)){
          float newdist = dist[u] + a[u][j];
          if(newdist < dist[j]){
            dist[j] = newdist;
            prev[j] = u;
          }
        }
          /*这个for循环是对第一个for中的点进行在度的贪婪搜索，
           *以第一个for循环找到的点为中心，去找这个中心点的下一个点，
           *如果下一个点与这个中心点的距离加上上一个点到中心点的距离，
           *小于一开始上一个点到下一个点的距离就对上一个点到下一个点的距离进行更新
           *同时用prev对标志的前一节点进行修改
           */

           //对原数组到各顶点的路径以及距离的输出
    }
    for(int i = 0; i < n; i++){
      if(i != v){
        System.out.print("从源点" + (v+1) + "到顶点" + (i+1) + "的最短路径长度为：" + dist[i]);
        System.out.print("," + "最短路径为：" + (v+1));
        path(v,i,prev);
        System.out.println();
      }
    }
  }
  //使用递归将路径找出来
  public static void path(int v, int i, int s[]){
    if(s[i] != v)
      path(v, s[i], s);
    System.out.print(" >> " + (i+1));
  }
  public static void main(String[]  args){
    int v = 1;
    float max = Float.MAX_VALUE;
    float array[][] = {
      {max, 3, 4, max, max, max},
      {max, max, 1, 9, 4, max},
      {max, max, max, 5, 13, max},
      {max, max, max, max, max, 8},
      {max, max, max, 12, max, 10},
      {max, max, max, max, max, max}
    };
    dijkstra(v-1, array);
  }
}

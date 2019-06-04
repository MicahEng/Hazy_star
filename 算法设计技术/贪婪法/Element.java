//Filename:Element.java
/*本类继承实现Comparable接口
 */
class Element implements Comparable{
  float w;
  float v;
  int i;
  public Element(float ww, float vv){
    w = ww;
    v = vv;
  }
  public Element(float ww, float vv, int ii){
    w = ww;
    v = vv;
    i = ii;
  }
  public int compareTo(Object x){
    float xw = ((Element)x).w;
    if(w < xw) return -1;
    if(w == xw) return 0;
    return 1;
  }
}

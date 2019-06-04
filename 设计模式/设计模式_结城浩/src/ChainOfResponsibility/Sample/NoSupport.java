//Filename:NoSupport.java
/*该类定义一个对问题不做任何处理的一个类
*/
public class NoSupport extends Support {
    public NoSupport(String name) {
        super(name);
    }
    protected boolean resolve(Trouble trouble) {     // 解决问题的方法
        return false; // 自己什么也不处理
    }
}
